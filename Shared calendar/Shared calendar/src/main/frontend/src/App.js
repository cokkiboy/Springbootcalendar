import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import About from './pages/About';
import Home from './pages/Home';
import User from './pages/User';
import Login from './pages/Login';
import Join from './pages/Join';
import ErrorPage from './pages/ErrorPage'; // 사용자 정의 에러 페이지
import LoginConextProvider from './contexts/LoginContextProvider';

function App() {
    const [hello, setHello] = useState('');

    useEffect(() => {
        axios.get('/')
            .then(response => setHello(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div className="App">
            <BrowserRouter>
                <LoginContextProvider>
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/login" element={<Login />} />
                        <Route path="/join" element={<Join />} />
                        <Route path="/user" element={<User />} />
                        <Route path="/about" element={<About />} />

                    </Routes>
                </LoginContextProvider>
            </BrowserRouter>
        </div>
    );
}

export default App;
