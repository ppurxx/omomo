import React, {useState,useEffect,useRef} from 'react';
import TagSelector from "./TagSelector";
import "./InputBox.css";
import Hashtag from "./Hashtag";

const InputBox = () =>{
  const [inputValue,setInputValue] = useState('');
  const inputValueRef = useRef();
  const [tagList, setTagList] = useState([]);
  const tagSelectorRef = useRef();


  useEffect(()=>{
    const currentInputValue = getCurrentInputValue();


    if(currentInputValue.value.startsWith('#') &&
        currentInputValue.value.length>1
        ){

      fetch('api/v1/hashtag?searchHashtagKeyword='+encodeURIComponent(currentInputValue.value),{
        method: "GET",
        headers: {
          'Content-type': 'application/json'
        }
      })
      .then(res => res.json())
      .then(response => {
        setTagList(response.map(item=>item.hashTagName));
      });
    }else{
      setTagList([]);
    }


  },[inputValue]);

  useEffect(()=>{
    if(tagList.length>0){
      tagSelectorRef.current.style.display="block";
    }else{
      tagSelectorRef.current.style.display="none";
    }
  },[tagList]);


  const hashtagClickHandler = (text) =>{
    //replace searchHashtagText to searchedHashtagTextName
    replaceTargetValue(text);
    inputValueRef.current.setSelectionRange(inputValue.length,inputValue.length);
    inputValueRef.current.focus();
  };

  const getCurrentInputValue = () =>{
    const currentCursorIndex = inputValueRef.current.selectionStart-1;

    let firstIndexOfFocusedInputValue=currentCursorIndex;
    while(firstIndexOfFocusedInputValue>0){
      if(" "===inputValue.charAt(firstIndexOfFocusedInputValue)){
        break;
      }
      firstIndexOfFocusedInputValue--;
    }

    let lastIndexOfFocusedInputValue=currentCursorIndex;
    while(lastIndexOfFocusedInputValue<inputValue.length){
      if(" "===inputValue.charAt(lastIndexOfFocusedInputValue)){
        break;
      }
      lastIndexOfFocusedInputValue++;
    }

    return {
      firstIndexOfFocusedInputValue: firstIndexOfFocusedInputValue,
      lastIndexOfFocusedInputValue: lastIndexOfFocusedInputValue,
      value: inputValue.substring(firstIndexOfFocusedInputValue,lastIndexOfFocusedInputValue).replaceAll(" ","")
    };
  }

  const replaceTargetValue = (searchedHashtagTextName) =>{
    const currentInputValue = getCurrentInputValue();

    const leftSideValueOfCursor = inputValue.substring(0,currentInputValue.firstIndexOfFocusedInputValue);
    const rightSideValueOfCursor = inputValue.substring(currentInputValue.lastIndexOfFocusedInputValue,inputValue.length);
    setInputValue(leftSideValueOfCursor + " "+ searchedHashtagTextName +" "+rightSideValueOfCursor);
  };


  const inputValueChangeHandler = (e) =>{
    setInputValue(e.target.value);
  }

  const buildTagListJSX = () =>{
    return tagList.map((tagItem,i) =>
        <Hashtag
            key={i}
            tagItem={tagItem}
            onClick={hashtagClickHandler}
        />
    );
  };

  const postButtonClickHandler = () =>{
    const hashTagRegEx = /#[a-zA-Z0-9가-힣]+/;
    const requestData = matchRegExAll(inputValue, hashTagRegEx);
    if(requestData){
      //call creation api
    }else{
      alert('해쉬태그를 달 대상에 공백이 포함되어있거나 여러개임');
    }
  }

  const matchRegExAll = (targetString, regEx) =>{
    let result = [];
    let count = 0;
    while(regEx.test(targetString)){
      const matchedString = regEx.exec(targetString)[0];
      result.push(matchedString);
      targetString = targetString.replace(matchedString,'');
      count ++;
      if(count>5)break;
    }

    targetString = targetString.trim();
    if(targetString.indexOf(' ')>0){
      return null;
    }

    return {
      hashTagList : result,
      wishItem : targetString
    };
  }


  return(
    <>
      <div className={"input-box"}>
        <div className={"tag-selector"} ref={tagSelectorRef}>
          {buildTagListJSX()}
        </div>
      <input
          className={"input_text_box"}
          type={Text}
          value={inputValue}
          ref={inputValueRef}
          onChange={inputValueChangeHandler}/>
      <input type={"button"} value={"전송"} onClick={postButtonClickHandler}/>
      </div>
    </>
  );
}

export default InputBox;