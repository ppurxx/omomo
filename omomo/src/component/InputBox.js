import React, {useState,useEffect,useRef} from 'react';
import Hashtag from "./Hashtag";

function InputBox(){
  const inputTextRef = React.createRef();
  const [inputText,setInputText] = useState('');
  const [modifiedHashtagText, setModifiedHashtagText] = useState();
  const [filteredHashtagList,setFilteredHashtagList] = useState([]);

  useEffect(()=>{
    filterHashtag(modifiedHashtagText);

        const strListSplit = inputText.split('#');
        const wishItem = strListSplit[0];
        const hashTagList = strListSplit.slice(1,strListSplit.length);

        if(inputText.length>0&&validateInputText(wishItem,hashTagList)){
          modifyHashtagText();
        }
      },
      []
  );

  const filterHashtag = (modifiedHashtagText)=>{
    //@@TODO find matchingHashTag from back-end by modifiedHashtagText
    setFilteredHashtagList(['맛집','맛집2','맛집3','맛집55','맛집55','맛집55']);

  }

  const modifyHashtagText = (hashtag)=>{
    const cursorIndex = inputTextRef.current.selectionEnd;
    const startIndex = findStartIndexOfModifiedHashtag(cursorIndex);
    const endIndex = findEndIndexOfModifiedHashtag(cursorIndex);

    let modifiedHashtag;

    if(hashtag!==''){
      modifiedHashtag = hashtag;
    }else{
      modifiedHashtag = inputText.substr(startIndex,endIndex-startIndex-1).replace(' ','');
    }

    console.log(1+inputText.substr(0,startIndex));
    console.log(2+inputText.substr(hashtag));
    console.log(3+inputText.substr(endIndex,inputText.length));
    let res = inputText.substr(0,startIndex).concat(modifiedHashtag).concat(inputText.substr(endIndex,inputText.length));
    setInputText(res);
    setModifiedHashtagText(modifiedHashtag);




  }

  const findEndIndexOfModifiedHashtag = (cursorIndex) =>{
    let lastIndex = cursorIndex;

    for(let i=cursorIndex;i<=inputText.length;i++){
      if(inputText.charAt(lastIndex)==='#'){
        break;
      }
      lastIndex++;
    }
    return lastIndex;
  }

  const findStartIndexOfModifiedHashtag = (cursorIndex)=>{
    let startPosition = cursorIndex;
    for(let i=cursorIndex;i>=0;i--){
      startPosition--;
      if(inputText.charAt(startPosition)==='#'){
        break;
      }
    }
    return startPosition;
  }


  const validateInputText = (wishItem,hashTagList) =>{
    if(!hashTagList.length)return false;
    if(wishItem===""){
      alert('insert wishItem name!!!');
      return false;
    }else{
      return true;
    }
  }

  const saveInputText = () => {
  //   const strListSplitted = inputText.split('#');
  //   const wishItem = strListSplitted[0];
  //   const hashTagList = strListSplitted.slice(1,strListSplitted.length);
  //
  //   //TODO call api address with wishItem & hashTagList
  }

  const onChangeInputText = (e) =>{
    setInputText(e.target.value);
  }

  function clickHashtag(hashtag){
    modifyHashtagText(hashtag);
  }


    return(
      <>
        <div>
          {filteredHashtagList.map((hashtag,index)=>(
              <Hashtag onClick={() => {clickHashtag(hashtag)}} hashtagText={hashtag} inputText={inputText} setInputText={setInputText} key={index}/>
          ))}
        </div>
        <input ref={inputTextRef} type={"text"} onChange={onChangeInputText} value={inputText}/>
        <input type={"button"} onClick={saveInputText} value={"save"}/>
      </>
    );
}

export default InputBox;