import { useState, FormEvent } from 'react';
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
        <div className="min-h-screen flex items-center justify-center bg-muted p-4">
            <form className="bg-card p-6 rounded-lg shadow-lg w-full max-w-4xl" onSubmit={handleSubmit}>
                <h2 className="text-center text-2xl font-bold mb-6 text-primary">Sign up</h2>
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                    <div>
                        <label htmlFor="first-name" className="block text-sm font-medium text-foreground">First Name*</label>
                        <input 
                            type="text" 
                            id="first-name" 
                            className="mt-1 block w-full border border-border rounded-md p-2" 
                            required 
                            value={firstName}
                            onChange={(e) => setFirstName(e.target.value)}
                        />
                    </div>
                    <div>
                        <label htmlFor="last-name" className="block text-sm font-medium text-foreground">Last Name*</label>
                        <input 
                            type="text" 
                            id="last-name" 
                            className="mt-1 block w-full border border-border rounded-md p-2" 
                            required 
                            value={lastName}
                            onChange={(e) => setLastName(e.target.value)}
                        />
                    </div>
                    <div>
                        <label htmlFor="email" className="block text-sm font-medium text-foreground">E-mail*</label>
                        <input 
                            type="email" 
                            id="email" 
                            className="mt-1 block w-full border border-border rounded-md p-2" 
                            required 
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                    </div>
                    <div>
                        <label htmlFor="password" className="block text-sm font-medium text-foreground">Password*</label>
                        <input 
                            type="password" 
                            id="password" 
                            className="mt-1 block w-full border border-border rounded-md p-2" 
                            required 
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                    </div>
                    <div>
                        <label htmlFor="contact-number" className="block text-sm font-medium text-foreground">Contact Number*</label>
                        <input 
                            type="text" 
                            id="contact-number" 
                            className="mt-1 block w-full border border-border rounded-md p-2" 
                            required 
                            value={contactNumber}
                            onChange={(e) => setContactNumber(e.target.value)}
                        />
                    </div>
                    <div>
                        <label htmlFor="address" className="block text-sm font-medium text-foreground">Address*</label>
                        <input 
                            type="text" 
                            id="address" 
                            className="mt-1 block w-full border border-border rounded-md p-2" 
                            required 
                            value={address}
                            onChange={(e) => setAddress(e.target.value)}
                        />
                    </div>
                    <div>
                        <label htmlFor="country" className="block text-sm font-medium text-foreground">Country*</label>
                        <input 
                            type="text" 
                            id="country" 
                            className="mt-1 block w-full border border-border rounded-md p-2" 
                            required 
                            value={country}
                            onChange={(e) => setCountry(e.target.value)}
                        />
                    </div>
                    <div>
                        <label htmlFor="city" className="block text-sm font-medium text-foreground">City</label>
                        <input 
                            type="text" 
                            id="city" 
                            className="mt-1 block w-full border border-border rounded-md p-2" 
                            value={city}
                            onChange={(e) => setCity(e.target.value)}
                        />
                    </div>
                    <div>
                        <label htmlFor="state" className="block text-sm font-medium text-foreground">State</label>
                        <input 
                            type="text" 
                            id="state" 
                            className="mt-1 block w-full border border-border rounded-md p-2" 
                            value={state}
                            onChange={(e) => setState(e.target.value)}
                        />
                    </div>
                    <div>
                        <label htmlFor="zipcode" className="block text-sm font-medium text-foreground">ZipCode</label>
                        <input 
                            type="text" 
                            id="zipcode" 
                            className="mt-1 block w-full border border-border rounded-md p-2" 
                            value={zipCode}
                            onChange={(e) => setZipCode(e.target.value)}
                        />
                    </div>
                </div>
                <div className="flex items-center mt-4">
                    <input 
                        id="terms" 
                        type="checkbox" 
                        className="h-4 w-4 text-primary border-border rounded" 
                        checked={terms}
                        onChange={(e) => setTerms(e.target.checked)}
                    />
                    <label htmlFor="terms" className="ml-2 block text-sm text-foreground">I agree to the Terms and Conditions</label>
                </div>
                <div className="mt-6 flex justify-center">
                    <button type="submit" className="signup-button py-3 px-6">Sign up</button>  {/* Added padding to increase height */}
                </div>
                <div className="mt-4 text-center">
                    <span className="text-muted-foreground">Follow us on</span>
                    <div className="flex justify-center mt-2 space-x-4">
                        <a href="#" className="text-primary"><img src="https://placehold.co/24x24?text=G" alt="Google"/></a>
                        <a href="#" className="text-primary"><img src="https://placehold.co/24x24?text=F" alt="Facebook"/></a>
                    </div>
                </div>
            </form>
        </div>
    );
};

export default Signup;
