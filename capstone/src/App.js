import "./App.css";
import React from "react";
import NavBar from "./components/NavBar";
import {BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { Home } from "./pages/Home";
import { About } from "./pages/About";
import { Login } from "./pages/Login";
import { Contact } from "./pages/Contact";
import { TestLogin } from "./Login/TestLogin";
import CallApi from "./components/CallApi";
function App() {
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
        <div>
          <CallApi />
        </div>
      </Router>
    </>
  );
}

export default App;