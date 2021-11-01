import React, {useCallback, useEffect, useRef, useState} from 'react';
import Axios from 'axios';
import WishItem from "./WishItem.js";

function ListBox() {
  const [wishItemList, setWishItemList] = useState([]);
  const [lastPageNumber, setLastPageNumber] = useState(0);
  const wishlistRef = useRef(null);
  const innerListBox = useRef(null);
  const [lastScrollTop, setLastScrollTop] = useState(0);
  const getWishItemListByUserId = () => {
    //@@TODO : after apply security module, have to change token & loginUserId
    const userId = 'nick';
    Axios.get('api/v1/wishitem/'+userId+'/'+lastPageNumber)
    .then(response => {
      if(response.data.length>0){
        setWishItemList(response.data.reverse().concat(wishItemList));
      }
    });


  };

  const handleScroll = () =>{
    if(wishlistRef.current.scrollTop === 0 && lastPageNumber!==0){
      getWishItemListByUserId();
      setLastPageNumber(lastPageNumber+1);
    }
  }

  useEffect(()=>{
    getWishItemListByUserId();
  },[]);

  useEffect(()=>{
    if(lastPageNumber===0 && wishItemList.length>0){
      wishlistRef.current.scrollTo(0,10000);
      setLastPageNumber(lastPageNumber+1);
    }
    // console.log(wishlistRef.current.scrollHeight+','+wishlistRef.current.clientHeight+','+lastScrollTop);
    wishlistRef.current.scrollTo(0,wishlistRef.current.scrollHeight - wishlistRef.current.clientHeight - lastScrollTop);
    setLastScrollTop(wishlistRef.current.scrollTop+lastScrollTop);

  },[wishItemList]);



  const buildWishItemListBoxJSX = () => {
    let previousDate = '';
    return wishItemList.sort((a,b)=>a.modifiedDateTime>b.modifiedDateTime?0:1)
    .map((wishItem, i) => {
      const curDate = wishItem.modifiedDateTime.substring(0,10);
      if(previousDate === curDate){
        return <>
        <WishItem
            key={wishItem.wishItemNo}
            wishItemNo={wishItem.wishItemNo}
            wishItemText={wishItem.wishItemText}
            wishItemCompletion={wishItem.wishItemCompletion}
            hashTagList={wishItem.hashTagList}
        /> </>;
      }else{
        previousDate = curDate;
        return <>
          <div key={i} className="date">{curDate}</div>
          <WishItem
              key={wishItem.wishItemNo}
              wishItemNo={wishItem.wishItemNo}
              wishItemText={wishItem.wishItemText}
              wishItemCompletion={wishItem.wishItemCompletion}
              hashTagList={wishItem.hashTagList}
          />
        </>;
      }
    });
  };

  return(
      <>
        <div className="wishlist">
          <div style={{display: 'inline-block', width:'100%' , height:'100%',  overflow: 'scroll'}} ref={wishlistRef} onScroll={handleScroll}>
            <div ref={innerListBox}>
              {buildWishItemListBoxJSX()}
            </div>
          </div>
        </div>
      </>
  );

}

export default ListBox;