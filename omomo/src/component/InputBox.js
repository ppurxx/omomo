import React, {useState} from 'react';
import TagSelector from './TagSelector';

function InputBox(){
  const [inputText, setInputText] = useState('');
  const [hashtagText, setHashtagText] = useState('');
  const [tagSelectorOpenFlag, setTagSelectorOpenFlag] = useState(false);

  const saveInputText = () => {
    console.log('save : ' + inputText);
    //TODO call api address with inputText
  }

  const onChangeInputText = (e) =>{
    let len = inputText.length;
    if(len===0) return;

    let character = inputText.substr(len-1,len);

    if(isCharacterHashTag(character)){
      openTagSelector();
    }else if(isSpaceBar(character)){
      closeTagSelector();
    }


    if(tagSelectorOpenFlag){
      //TODO how to change hashtagText
    }else{
      //TODO how to change inputText
    }

    setInputText(e.target.value);
    openTagSelector();

  }

  const isSpaceBar = (character) =>{
    return character === ' ';
  }

  const isCharacterHashTag = (character) =>{
    return character === '#';
  }

  const openTagSelector = () =>{
    if(!tagSelectorOpenFlag){
      setTagSelectorOpenFlag(true);

    }
  }

  const closeTagSelector = () =>{
    setTagSelectorOpenFlag(false);
  }

      return(
      <>
        <TagSelector inputText={inputText} openFlag={tagSelectorOpenFlag}/>
        <input type={"text"} value={inputText} onChange={onChangeInputText}/>
        <input type={"button"} onClick={saveInputText} value={"save"}/>
      </>
  );
}

export default InputBox;