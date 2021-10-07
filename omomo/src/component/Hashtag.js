import React,{useEffect} from 'react';
import './Hashtag.css';

function Hashtag(props){
  const {tagItem, onClick} = props;

  return(
      <>
        <button className={"tag_button"} onClick={e=>onClick(tagItem)}>{tagItem}</button>
      </>
  );
}

export default Hashtag;