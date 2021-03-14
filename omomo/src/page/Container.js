import React from 'react';
import Header from '../component/Header.js'
import InputBox from '../component/InputBox.js';
import ListBox from '../component/ListBox.js';

function Container() {


  return (
      <>
        <h1>Container</h1>
        <Header/>
        <ListBox/>
        <InputBox/>
      </>
  );
}

export default Container;