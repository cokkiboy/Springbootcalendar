
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import About from './pages/About';
import Home from './pages/Home';
import User from './pages/User';
import Login from './pages/Login';
import Join from './pages/Join';


function App() {
  const [hello, setHello] = useState('')

  useEffect(() => {
    axios.get('/')
        .then(response => setHello(response.data))
        .catch(error => console.log(error))
  }, []);

  return (
     <BrowserRouter>
         <Routes>
             <Route  path="/" element={<Home />}></Route>
             <Route  path="/login" element={<Login/>}></Route>
             <Route  path="/join" element={<Join/>}></Route>
             <Route  path="/user" element={<User/>}></Route>
             <Route  path="/about" element={<About/>}></Route>
         </Routes>

     </BrowserRouter>
  );
}

export default App;