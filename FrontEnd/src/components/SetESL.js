import React, { useEffect, useState} from "react";
import axios from "axios";

const SetESL=()=>{
    const [product, setProduct] = useState([]);

    const changeHandler = (e) => {
        this.setState({ [e.target.name]: e.target.value });
    };
    const data = {
        name: this.state.name,
        location: this.state.location,
        price_range: this.state.price_range,
        id: this.state.id
      };
    const submitHandler = (e) => {
        e.preventDefault();
        //console.log(this.state);

        axios.put("http://3.36.36.228:8080/api/v1/esl/2", data)
        .then((data) => {
            console.log(data);
        })
        .catch((err) => {
            console.log(err);
        });
    };
    
    const { menuName, menuCost, openTime, closeTime } = this.state;
    return (
      <div>
        <form onSubmit={submitHandler}>
          <input
            type="text"
            name="menuName"
            value={menuName}
            onChange={changeHandler}
          />
          <br />
          <input
            type="text"
            name="menuCost"
            value={menuCost}
            onChange={changeHandler}
          />
          <br />

          <button type="submit">submit</button>
        </form>
      </div>
    );
};

export default SetESL
