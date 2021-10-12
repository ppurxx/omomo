import React from 'react';
import Header from '../component/Header.js'
import InputBox from '../component/InputBox.js';
import ListBox from '../component/ListBox.js';
import TagBar from '../component/TagBar.js'
import './Container.css';

function Container() {


  return (
      <>
        <Header/>
        <main>
          <TagBar/>
          <ListBox/>
          <InputBox/>
        </main>
      </>
  );
}

export default Container;