import React, { useEffect, useState } from 'react';

export const LoginContext = React.createContext();
LoginContext.displayName = 'LoginContextName'

const LoginContextProvider = ({ children }) => {
    const [isLogin, setIsLogin] = useState(false);

    const logout = () => {
        setIsLogin(false)
    }



    return (
        <LoginContextProvider value={ {isLogin, logout} }>
            {children}
        </LoginContextProvider>
    );
};

export default LoginContextProvider;