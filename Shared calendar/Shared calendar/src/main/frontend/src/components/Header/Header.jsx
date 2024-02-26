import React from "react";
import './Header.css'
import {Link} from 'react-router-dom'
const Header = () => {
   return(

       <header>
        <div  className="logo">
            <Link to="/">
              <img  src=""  alt="logo"  className='logo'/>

            </Link>

        </div>
         <div  className="util">
             <ul>

                 <li><Link to="/login" >로그인</Link></li>
                 <li><Link to="/join" >회원가입</Link></li>
                 <li><Link to="/about" >소개</Link></li>

             </ul>
             <ul>

                 <li><Link to="/user" >마이페이지</Link></li>
                 <li><button className='link'>로그아웃</button></li>

             </ul>


         </div>

       </header>

   )


}

export default Header