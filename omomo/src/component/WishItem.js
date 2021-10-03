import React from 'react';
import './WishItem.css';

const WishItem = (props) =>{
  const {wishItemNo, wishItemText, wishItemCompletion, hashTagList} = props;

  const buildHashTagListJSX = () =>{
    console.log(hashTagList);
    return hashTagList.map(hashTag =>
      <input className="wishitem_tag_button" type="button" value={hashTag.hashTagName}/>
    )
  }

  return <>
    <div className="wishitem">
      <div className="checkbox-container">
        <input type="checkbox" id="wi1"/>
        <label htmlFor="wi1"></label><span
          className="wishitem-text">{wishItemText}</span>
      </div>
      <div className="wishitem_tag_bar">
        {buildHashTagListJSX()}
      </div>
    </div>
  </>;
}

export default WishItem;