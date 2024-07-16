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
       <>
       <div className="flex flex-col items-center justify-center min-h-screen bg-[var(--background)] p-6">
          <div className="flex flex-col md:flex-row bg-[var(--card)] shadow-lg rounded-lg overflow-hidden">
            <div className="md:w-1/2 max-h-screen p-6 bg-[var(--primary)] flex flex-col items-center justify-center">
              <img src={logo} alt="Heritage Heaven" className="mb-4"/>  {/* Adjust the width and height as needed */}
            </div>
            <div className="md:w-1/2 p-8">
              <h2 className="text-2xl font-bold text-center mb-6 text-[var(--foreground)]">Login</h2>
              <form className="space-y-4" onSubmit={handleSubmit}>
                <div>
                  <label htmlFor="email" className="block text-sm font-medium text-[var(--foreground)]">Email</label>
                  <input 
                    type="email" 
                    id="email" 
                    className="mt-1 block w-full p-2 border border-[var(--border)] rounded-md bg-[var(--input)] text-[var(--foreground)]" 
                    required 
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                  />
                </div>
                <div>
                  <label htmlFor="password" className="block text-sm font-medium text-[var(--foreground)]">Password*</label>
                  <input 
                    type="password" 
                    id="password" 
                    className="mt-1 block w-full p-2 border border-[var(--border)] rounded-md bg-[var(--input)] text-[var(--foreground)]" 
                    required
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </div>
                <div className="flex items-center">
                  <input type="checkbox" id="remember" className="h-4 w-4 text-[var(--primary)] border-[var(--border)] rounded"/>
                  <label htmlFor="remember" className="ml-2 block text-sm text-[var(--foreground)]">Remember Me</label>
                </div>
                <div className="flex justify-center">
                  <button type="submit" className="login-button">Login</button>
                </div>
              </form>
              <p className="mt-4 text-center text-sm text-[var(--foreground)]">
                Don’t have an account? <a href="#" className="font-medium text-[var(--primary)] hover:underline">Sign up</a>
              </p>
            </div>
          </div>
        </div>
       </>
    );
}

export default Login;
