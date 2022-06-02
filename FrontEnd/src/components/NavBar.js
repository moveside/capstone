import React, { useState } from "react";
import { NavLink } from "react-router-dom";
import "./NavBar.css";

function NavBar() {
  const [click, setClick] = useState(false);

  const handleClick = () => setClick(!click);
  return (
    <>
      <nav className="navbar">
        <div className="nav-container">
          <NavLink exact to="/about" className="nav-logo">
            Errs
          </NavLink>

          <ul className={click ? "nav-menu active" : "nav-menu"}>
            <li className="nav-item">
              <NavLink
                exact
                to="/menu"
                activeClassName="active"
                className="nav-links"
                onClick={handleClick}
              >
                메뉴 조회
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink
                exact
                to="/esl"
                activeClassName="active"
                className="nav-links"
                onClick={handleClick}
              >
                ESL 관리
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink
                exact
                to="/statistic"
                activeClassName="active"
                className="nav-links"
                onClick={handleClick}
              >
                주간 통계
              </NavLink>
            </li>
            <li className="nav-login">
              <NavLink
                exact
                to="/"
                activeClassName="active"
                className="nav-links"
                onClick={handleClick}
              >
                Logout
              </NavLink>
            </li>
          </ul>
          <div className="nav-icon" onClick={handleClick}>
            <i className={click ? "fas fa-times" : "fas fa-bars"}></i>
          </div>
        </div>
      </nav>
    </>
  );
}

export default NavBar;