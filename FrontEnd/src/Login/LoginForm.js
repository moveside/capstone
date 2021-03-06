import React, { useState } from 'react';
import { Redirect } from 'react-router-dom';
import Footer from '../pages/Footer';
import './login.css';

function LoginForm({ authenticated, login, location }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleClick = () => {
    try {
      login({ email, password });
    } catch (e) {
      alert('Failed to login');
      setEmail('');
      setPassword('');
    }
  };

  const { from } = location.state || { from: { pathname: "/" } };
  if (authenticated) return <Redirect to={from} />;

  return (
    <>
      <div className='app'>
        <div className='login-form'>
          <div className="title">Login</div>
          <div className="form">
            <form>
              <div className='input-container'>
                <input
                  value={email}
                  onChange={({ target: { value } }) => setEmail(value)}
                  type="text"
                  placeholder=" 관리자 ID"
                />
              </div>
              <div className='input-container'>
                <input
                  value={password}
                  onChange={({ target: { value } }) => setPassword(value)}
                  type="password"
                  placeholder=" password"
                />
              </div>
              <div className='button-container'>
                <button className='login-button' onClick={handleClick}>Login</button>
              </div>
            </form>
          </div>
        </div>
      </div>
      <div>
        <Footer></Footer>
      </div>
    </>
  );
}

export default LoginForm;