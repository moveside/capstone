import "./App.css";
import React, { useState } from "react";
import NavBar from "./components/NavBar";
import {BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import { Home } from "./pages/Home";
import { About } from "./pages/Menu";
import { ESL } from "./pages/ESL";
import { Contact } from "./pages/Statistics";

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
            <Route  exact path="/home" component={Home} />
            <Route path="/about" component={About} />
            <Route path="/login" component={ESL} />
            <Route path="/contact" component={Contact} />
            <Route
              path='/'
              render={props =>(
                <LoginForm authenticated={authenticated} login={login} {...props}/>
              )}
            />
            {authenticated ? (
              <LogoutButton logout={logout} />
            ) : (
              <Link to="/home" >
                <button >Login</button>
              </Link>
            )}
            
          </Switch>
          </div>
      </Router>

      
      {/* <TestLogin></TestLogin> */}
    </>
  );
}

export default App;