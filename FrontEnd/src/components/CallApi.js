import React from "react";
import axios from "axios";

class CallApi extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        menuName: "",
        menuCost: "",
        openTime: "",
        closeTime: ""
      };
    }
  
    changeHandler = (e) => {
      this.setState({ [e.target.name]: e.target.value });
    };
    submitHandler = (e) => {
      e.preventDefault();
      //console.log(this.state);
      const data = {
        menuName: this.state.menuName,
        menuCost: this.state.menuCost,
        openTime: this.state.openTime,
        closeTime: this.state.closeTime
      };
      axios
        .put("http://3.36.36.228:8080/api/v1/esl/2", data)
        .then((data) => {
          console.log(data);
        })
        .catch((err) => {
          console.log(err);
        });
    };
  
    render() {
      const { menuName, menuCost, openTime, closeTime } = this.state;
      return (
        <div>
          <form onSubmit={this.submitHandler}>
            <input
              type="text"
              name="menuName"
              value={menuName}
              onChange={this.changeHandler}
            />
            <br />
            <input
              type="text"
              name="menuCost"
              value={menuCost}
              onChange={this.changeHandler}
            />
            <br />
            <input
              type="text"
              name="openTime"
              value={openTime}
              onChange={this.changeHandler}
            />
            <br />
            <input
              type="text"
              name="closeTime"
              value={closeTime}
              onChange={this.changeHandler}
            />
            <button type="submit">저장</button>
          </form>
        </div>
      );
    }
  }
  
  export default CallApi;