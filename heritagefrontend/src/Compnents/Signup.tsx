import { useState, FormEvent } from 'react';
import { Link } from 'react-router-dom';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import '../CSS/Signup.css';

const Signup = () => {
    const [firstName, setFirstName] = useState<string>('');
    const [lastName, setLastName] = useState<string>('');
    const [email, setEmail] = useState<string>('');
    const [password, setPassword] = useState<string>('');
    const [contactNumber, setContactNumber] = useState<string>('');
    const [address, setAddress] = useState<string>('');
    const [city, setCity] = useState<string>('');
    const [state, setState] = useState<string>('');
    const [zipCode, setZipCode] = useState<string>('');
    const [country, setCountry] = useState<string>('');
    const [terms, setTerms] = useState<boolean>(false);

    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (!terms) {
            toast.error('You must agree to the Terms and Conditions.');
            return;
        }

        const customerData = {
            firstName,
            lastName,
            email,
            passwordHash: password,
            phoneNumber: contactNumber,
            address,
            city,
            state,
            zipCode,
            country
        };

        try {
            const response = await fetch('http://localhost:9090/api/customers', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(customerData),
            });

            if (!response.ok) {
                throw new Error('Failed to create customer');
            }

            const data = await response.json();
            console.log('Customer created:', data);
            toast.success('Signup successful!');
            setFirstName('');
            setLastName('');
            setEmail('');
            setPassword('');
            setContactNumber('');
            setAddress('');
            setCity('');
            setState('');
            setZipCode('');
            setCountry('');
            setTerms(false);
        } catch (error) {
            console.error('Error:', error);
            toast.error('Signup failed. Please try again.');
        }
    };

    return (
        <div className="signup-page">
            <div className="signup-container">
                <h2 className="signup-title">Sign up</h2>
                <form onSubmit={handleSubmit}>
                    <div className="form-item form-item-half">
                        <label htmlFor="firstName">First Name*</label>
                        <input
                            type="text"
                            id="firstName"
                            name="firstName"
                            value={firstName}
                            onChange={(e) => setFirstName(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-item form-item-half">
                        <label htmlFor="lastName">Last Name*</label>
                        <input
                            type="text"
                            id="lastName"
                            name="lastName"
                            value={lastName}
                            onChange={(e) => setLastName(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-item">
                        <label htmlFor="email">E-mail*</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-item">
                        <label htmlFor="password">Password*</label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-item">
                        <label htmlFor="contactNumber">Contact Number*</label>
                        <input
                            type="tel"
                            id="contactNumber"
                            name="contactNumber"
                            value={contactNumber}
                            onChange={(e) => setContactNumber(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-item">
                        <label htmlFor="address">Address*</label>
                        <input
                            type="text"
                            id="address"
                            name="address"
                            value={address}
                            onChange={(e) => setAddress(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-item">
                        <label htmlFor="country">Country*</label>
                        <input
                            type="text"
                            id="country"
                            name="country"
                            value={country}
                            onChange={(e) => setCountry(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-item">
                        <label htmlFor="city">City*</label>
                        <input
                            type="text"
                            id="city"
                            name="city"
                            value={city}
                            onChange={(e) => setCity(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-item form-item-half">
                        <label htmlFor="state">State*</label>
                        <input
                            type="text"
                            id="state"
                            name="state"
                            value={state}
                            onChange={(e) => setState(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-item form-item-half">
                        <label htmlFor="zipCode">Zip Code*</label>
                        <input
                            type="text"
                            id="zipCode"
                            name="zipCode"
                            value={zipCode}
                            onChange={(e) => setZipCode(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-item">
                        <label>
                            <input
                                type="checkbox"
                                name="terms"
                                checked={terms}
                                onChange={(e) => setTerms(e.target.checked)}
                                required
                            />
                            I agree to the Terms and Conditions
                        </label>
                    </div>
                    <button type="submit" className="submit-button">Submit</button>
                </form>
                <div className="login-text">
                    <span>Already have an account?</span>
                    <Link to="/login">Log in</Link>
                </div>
                <ToastContainer />
            </div>
        </div>
    );
};

export default Signup;
