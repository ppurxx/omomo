import React, {useState,useEffect,useRef} from 'react';
import Hashtag from "./Hashtag";

function InputBox(){
  const [wishItem, setWishItem] = useState();
  const inputText = useRef();
  const [hashtagList, setHashtagList] = useState([]);
  let inputMode = useRef();
  const hashtagAssign = useRef();

  const INPUT_MODE = {
    WISHITEM : 'WISHITEM',
    HASHTAG : 'HASHTAG'
  }
  useEffect(()=>{
    if(inputMode.current===INPUT_MODE.WISHITEM || inputMode.current===undefined){
      inputMode.current = INPUT_MODE.WISHITEM;
      hashtagAssign.current.style.display="none";
    }else{
      hashtagAssign.current.style.display="block";
    }

  });

  const onChangeInputText = (e)=>{
    const inputWords = e.target.value;
    const inputWord = inputWords.charAt(inputWords.length-1);

    if (inputMode.current === INPUT_MODE.WISHITEM){
      if(inputWord === '#') {
        inputMode.current = INPUT_MODE.HASHTAG;
        setWishItem(e.target.value.substr(0, inputWords.length - 1));
        inputText.current.value = '';
      }else if(inputWords.length===0){
        console.log('asdfasdf');
      }
    } else if (inputMode.current === INPUT_MODE.HASHTAG &&
        inputWord === '#') {
      setHashtagList(hashtagList.concat(inputWords.substr(0,inputWords.length-1)));
      inputText.current.value ='';
    }
  }

  const onKeyDownInputText = (e)=>{
    if(e.keyCode===8 &&
        inputText.current.value===''){
      setHashtagList(hashtagList.splice(0,hashtagList.length-1));
    }else if(e.keyCode===13){
      e.target.value='#';
      onChangeInputText(e);
    }
  }

  return(
    <>
      {wishItem}
      {hashtagList.map((hashtag,index)=>(
          <Hashtag onClick={() => {alert(hashtag)}} hashtagText={hashtag} key={index}/>
      ))}
      <div ref={hashtagAssign}>#</div>
      <input ref={inputText} type={"text"}
             onChange={onChangeInputText}
             onKeyDown={onKeyDownInputText}
      />
    </>
  );
}

export default InputBox;