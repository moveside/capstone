import "./App.css";
import React from "react";
import NavBar from "./components/NavBar";
import {BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { Home } from "./pages/Home";
import { About } from "./pages/Menu";
import { ESL } from "./pages/ESL";
import { Contact } from "./pages/Statistics";
import Login from "./Login/LoginPage";
import TestLogin from "./Login/TestLogin";

function App() {

  return (
    <>
      <Router>
        <NavBar />
        <div className="pages">
          <Switch>
            <Route exact path="/" component={Home} />
            <Route path="/about" component={About} />
            <Route path="/login" component={ESL} />
            <Route path="/contact" component={Contact} />
          </Switch>
        </div>
        
      </Router>
      <Login></Login>
      {/* <TestLogin></TestLogin> */}
    </>
  );
}

export default App;