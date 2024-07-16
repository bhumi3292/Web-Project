import React, { FormEvent, useState } from 'react';
import { Link } from 'react-router-dom';
import '../CSS/Login.css';
import logo from "./assets/logo.png";

const Login: React.FC = () => {
    const [email, setEmail] = useState<string>('');
    const [password, setPassword] = useState<string>('');

    const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        console.log('Email:', email);
        console.log('Password:', password);
    };

    return (
        <div className="login-container">
            <div className="image-section">
                <img src={logo} alt="Logo" className="logo" />
            </div>
            <div className="login-section">
                <h2 className="login-title">Login</h2>
                <form onSubmit={handleSubmit}>
                    <label htmlFor="email">Email</label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                    <div className="remember-me">
                        <input type="checkbox" name="remember" id="remember" />
                        <label htmlFor="remember">Remember Me</label>
                    </div>
                    <button type="submit" className="login-button">Login</button>
                </form>
                <div className="signup-text">
                    <span>Don't have an account?</span>
                    <Link to="/signup">Sign up</Link>
                </div>
            </div>
        </div>
    );
}

export default Login;
