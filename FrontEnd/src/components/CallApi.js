import React from "react";
import axios from "axios";
import './callapi.css';

class CallApi extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        openTime: "",
        closeTime: "",
        menuName1: "",
        menuName2: "",
        menuCost1: "",
        menuCost2: "",
        breakTime1: "",
        breakTime2: "",
        exp: "",
      };
    }
  
    changeHandler = (e) => {
      this.setState({ [e.target.name]: e.target.value });
    };
    submitHandler = (e) => {
      e.preventDefault();
      //console.log(this.state);
      const data = {
        openTime: "",
        closeTime: "",
        breakTime1: "",
        breakTime2: "",
        exp: "",
        menuName1: this.state.menuName1,
        menuName2: this.state.menuName2,
        menuCost1: this.state.menuCost1,
        menuCost2: this.state.menuCost2

      };
      axios
        .put("/api/v1/esl/2", data)
        .then((data) => {
          console.log(data);
        })
        .catch((err) => {
          console.log(err);
        });
    };
    submitHandler2 = (e) => {
        e.preventDefault();
        //console.log(this.state);
        const data2 = {
            openTime: this.state.openTime,
            closeTime: this.state.closeTime,
            breakTime1: this.state.breakTime1,
            breakTime2: this.state.breakTime2,
            exp: this.state.exp,
            menuName1: "",
            menuName2: "",
            menuCost1: "",
            menuCost2: "",

        };
        axios
          .put("/api/v1/esl/1", data2)
          .then((data2) => {
            console.log(data2);
          })
          .catch((err) => {
            console.log(err);
          });
      };
  
    render() {
      const { menuName1, menuCost1, menuName2, menuCost2,openTime, closeTime, breakTime1,breakTime2,exp} = this.state;
      return (
        <>
        <div className="blank"></div>
        <div>
          <form className="csv-form" onSubmit={this.submitHandler}>
            <div className="esl-title">매뉴판 ESL 수정</div>
            <div >
            메뉴 이름 : <input
              className="esl-input"
              type="text"
              name="menuName1"
              value={menuName1}
              onChange={this.changeHandler}
            />
              메뉴 가격 : <input
              className="esl-input"
              type="text"
              name="menuCost1"
              value={menuCost1}
              onChange={this.changeHandler}
            />
            </div>
            <div>
            메뉴 이름 : <input
              className="esl-input"
              type="text"
              name="menuName2"
              value={menuName2}
              onChange={this.changeHandler}
            />
            메뉴 가격 : <input
              className="esl-input"
              type="text"
              name="menuCost2"
              value={menuCost2}
              onChange={this.changeHandler}
            />
            </div>
            <br></br>
            <button type="submit">저장</button>
          </form>
          <form className="csv-form2" onSubmit={this.submitHandler2}>
            <div className="esl-title">웨이팅 ESL 수정</div>
            <div>
                Open time : <input
                className="esl-input"
                type="text"
                name="openTime"
                value={openTime}
                onChange={this.changeHandler}
                />
                Close time : <input
                className="esl-input"
                type="text"
                name="closeTime"
                value={closeTime}
                onChange={this.changeHandler}
                />
            </div>
            <div>
                Break time : <input
                className="esl-input-breaktime"
                type="text"
                name="breakTime1"
                value={breakTime1}
                onChange={this.changeHandler}
                />
                <br />
                추천 메뉴 : &nbsp;&nbsp;&nbsp;<input
                className="esl-input2"
                type="text"
                name="exp"
                value={exp}
                onChange={this.changeHandler}
                />
            </div>
            <button type="submit">저장</button>
            <button onClick={()=> window.open("http://3.36.36.228:8080/download", "_blank")}>csv 다운로드</button>
          </form>
        </div>
        </>
      );
    }
  }
  
  export default CallApi;