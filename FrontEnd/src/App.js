import "./App.css";
import React from "react";
import NavBar from "./components/NavBar";
import {BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { Home } from "./pages/Home";
import { About } from "./pages/Menu";
import { Login } from "./pages/ESL";
import { Contact } from "./pages/Statistics";
import axios from "axios";


function App() {
  const getd=()=>{
    axios.get("http://localhost:8080/menu").then(
        (response)=>{
            console.log(response);
        }
    );
  }

  return (
    <>
      <Router>
        <NavBar />
        <div className="pages">
          <Switch>
            <Route exact path="/" component={Home} />
            <Route path="/about" component={About} />
            <Route path="/login" component={Login} />
            <Route path="/contact" component={Contact} />
          </Switch>
          {/*<div>
            <TestLogin />
            <Switch>
              <Route exact path="/home" component={Home} />
            </Switch>
          </div>*/}
        </div>
        {/* <div>
            hi <button onClick={getd}>getget</button>
            <button onClick={postData}>post</button>
        </div> */}
        
      </Router>
    </>
  );
}

export default App;