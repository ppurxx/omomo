import React from 'react';
import './Header.css';

function Header(){
  return(
      <>
        <header>
        <div className="search_box_wrap">
          <div className="search_text_wrap">
            <input className="search_text" type="text" placeholder="여기에 입력"/>
          </div>
          <div className="search_icon_wrap">
            <i className="search_icon fas fa-search"></i>
          </div>
        </div>

        <div className="menuicon">icon</div>
        </header>
      </>
    );
}

export default  Header;