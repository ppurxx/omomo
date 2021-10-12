import React from 'react';
import './TagBar.css'


function TagBar(){
  return (
      <>
        <div className="mainitems">
          <div className="tagbar">
            <input className="tag_button" type="button" value="#All"/>
            <input className="tag_button" type="button" value="#카페"/>
            <input className="tag_button" type="button" value="#맛집"/>
            <input className="tag_button" type="button" value="#관광지"/>
            <input className="tag_button" type="button" value="#전시"/>
            <input className="tag_button" type="button" value="#기념일"/>
            <input className="tag_button" type="button" value="#액티비티"/>
            <input className="tag_button" type="button" value="#전시"/>
            <input className="tag_button" type="button" value="#기념일"/>
            <input className="tag_button" type="button" value="#액티비티"/>
          </div>
          <div style={{display:'inline-block', width:'100%'}}></div>
          <label className="switch">
            <input type="checkbox"/>
              <span className="slider round"></span>
          </label>
        </div>
      </>
  );
}



export default TagBar;