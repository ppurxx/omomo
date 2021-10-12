import React, {useState} from 'react';
import './WishItem.css';

const WishItem = (props) =>{
  const {wishItemNo, wishItemText, wishItemCompletion, hashTagList} = props;
  const [isCompleted, setIsCompleted] = useState(props.wishItemCompletion);

  const buildHashTagListJSX = () =>{
    return hashTagList.map(hashTag =>
      <input key={hashTag.hashTagName} className="wishitem_tag_button" type="button" value={hashTag.hashTagName}/>
    )
  }

  const completionButtonClickHandler = (e) =>{
    setIsCompleted(!isCompleted);
  }

  return <>
    <div className="wishitem">
      <div className="checkbox-container">
        <input type="checkbox" id={wishItemNo} checked={isCompleted} onClick={completionButtonClickHandler}/>
        <label htmlFor={wishItemNo}></label><span
          className="wishitem-text">{wishItemText}</span>
      </div>
      <div className="wishitem_tag_bar">
        {buildHashTagListJSX()}
      </div>
    </div>
  </>;
}

export default WishItem;