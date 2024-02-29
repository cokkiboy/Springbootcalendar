import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import About from './pages/About';
import Home from './pages/Home';
import User from './pages/User';
import Login from './pages/Login';
import Join from './pages/Join';

import LoginConextProvider from './contexts/LoginContextProvider';

function App() {

    return (
        <div >
            <BrowserRouter>
                <LoginContextProvider>
                    <Routes>
                        <Route path="/home" exact={true}  component={<Home />} />
                        <Route path="/login" component={<Login />} />
                        <Route path="/join" component={<Join />} />
                        <Route path="/user" component={<User />} />
                        <Route path="/about" component={<About />} />

                    </Routes>
                </LoginContextProvider>
            </BrowserRouter>
        </div>
    );
}

export default App;
