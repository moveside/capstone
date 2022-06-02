import "./App.css";
import React, { useState } from "react";
import NavBar from "./components/NavBar";
import {BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import { Home } from "./pages/Home";
import { About } from "./pages/Menu";
import { ESL } from "./pages/ESL";
import { Contact } from "./pages/Statistics";
import Footer from "./pages/Footer";

import { signIn } from "./Login/auth";
import LoginForm from "./Login/LoginForm";
import LogoutButton from "./Login/LogoutButton";

function App() {
  const [user, setUser] = useState(null);
  const authenticated = user != null;

  const login = ({ email, password }) => setUser(signIn({ email, password }));
  const logout = () => setUser(null);

  return (
    <>

      <Router>
        <NavBar />
          <div className="pages">
          <Switch>
            <Route path="/menu" component={About} />
            <Route path="/esl" component={ESL} />
            <Route path="/statistic" component={Contact} />
            <Route
              exact path='/'
              render={props =>(
                <LoginForm authenticated={authenticated} login={login} {...props}/>
              )}
            />
            {authenticated ? (
              <LogoutButton logout={logout} />
            ) : (
              <Link to="/menu" >
                <button >Login</button>
              </Link>
            )}
            
          </Switch>
          </div>
      </Router>


    </>
  );
}

export default App;