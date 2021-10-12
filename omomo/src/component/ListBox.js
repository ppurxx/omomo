import React, {useEffect, useState} from 'react';
import Axios from 'axios';
import WishItem from "./WishItem.js";

function ListBox() {
  const [wishItemList, setWishItemList] = useState([]);
  const getWishItemListByUserId = () => {
    //@@TODO : after apply security module, have to change token & loginUserId
    const userId = 'nick';
    Axios.get('api/v1/wishitem/'+userId)
    .then(response => {
      setWishItemList(response.data);
    })
  };

  useEffect(()=>{
    getWishItemListByUserId();
  },[])



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
          <div style={{display: 'inline-block', width:'100%'}}>
            {buildWishItemListBoxJSX()}
          </div>
        </div>
      </>
  );

}

export default ListBox;