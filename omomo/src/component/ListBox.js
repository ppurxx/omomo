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
    return wishItemList.map((wishItem, i) =>
        <WishItem
            key={i}
            wishItemNo={wishItem.wishItemNo}
            wishItemText={wishItem.wishItemText}
            wishItemCompletion = {wishItem.wishItemCompletion}
            hashTagList = {wishItem.hashTagList}
        />);
  };

  return(
      <>
        <div className="wishlist">
          <div style={{display: 'inline-block', width:'100%'}}>
            <div className="date">aaa</div>
            {buildWishItemListBoxJSX()}

          </div>
        </div>
      </>
  );

}

export default ListBox;