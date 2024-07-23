import { useState, FormEvent } from 'react';
import { toast, ToastContainer } from 'react-toastify';
import axios from 'axios';
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
            passwordHash: password, // Ensure the password is hashed server-side
            phoneNumber: contactNumber,
            address,
            city,
            state,
            zipCode,
            country
        };

        try {
            const response = await axios.post('http://localhost:9090/api/customers', customerData, {
                headers: {
                    'Content-Type': 'application/json',
                }
            });

            console.log('Customer created:', response.data);
            toast.success('Signup successful!');
            // Reset form
            resetForm();
        } catch (error) {
            console.error('Error:', error);
            toast.error('Signup failed. Please try again.');
        }
    };

    const resetForm = () => {
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
    };

    return (
        <div className="min-h-screen flex items-center justify-center bg-muted p-4">
            <form className="bg-card p-6 rounded-lg shadow-lg w-full max-w-4xl" onSubmit={handleSubmit}>
                <h2 className="text-center text-2xl font-bold mb-6 text-primary">Sign Up</h2>
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                    {[
                        { id: 'first-name', label: 'First Name', type: 'text', value: firstName, setter: setFirstName, required: true },
                        { id: 'last-name', label: 'Last Name', type: 'text', value: lastName, setter: setLastName, required: true },
                        { id: 'email', label: 'E-mail', type: 'email', value: email, setter: setEmail, required: true },
                        { id: 'password', label: 'Password', type: 'password', value: password, setter: setPassword, required: true },
                        { id: 'contact-number', label: 'Contact Number', type: 'text', value: contactNumber, setter: setContactNumber, required: true },
                        { id: 'address', label: 'Address', type: 'text', value: address, setter: setAddress, required: true },
                        { id: 'country', label: 'Country', type: 'text', value: country, setter: setCountry, required: true },
                        { id: 'city', label: 'City', type: 'text', value: city, setter: setCity },
                        { id: 'state', label: 'State', type: 'text', value: state, setter: setState },
                        { id: 'zipcode', label: 'ZipCode', type: 'text', value: zipCode, setter: setZipCode }
                    ].map(({ id, label, type, value, setter, required }) => (
                        <div key={id}>
                            <label htmlFor={id} className="block text-sm font-medium text-foreground">{label}{required && '*'}</label>
                            <input 
                                type={type} 
                                id={id} 
                                className="mt-1 block w-full border border-border rounded-md p-2" 
                                required={required} 
                                value={value}
                                onChange={(e) => setter(e.target.value)}
                            />
                        </div>
                    ))}
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
                    <button type="submit" className="signup-button py-3 px-6">Sign Up</button>
                </div>
                <div className="mt-4 text-center">
                    <span className="text-muted-foreground">Follow us on</span>
                    <div className="flex justify-center mt-2 space-x-4">
                        <a href="#" className="text-primary"><img src="https://placehold.co/24x24?text=G" alt="Google"/></a>
                        <a href="#" className="text-primary"><img src="https://placehold.co/24x24?text=F" alt="Facebook"/></a>
                    </div>
                </div>
            </form>
            <ToastContainer />
        </div>
    );
};

export default Signup;
