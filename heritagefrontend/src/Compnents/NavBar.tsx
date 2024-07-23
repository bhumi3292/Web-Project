import { useNavigate } from 'react-router-dom';
import '../CSS/NavBar.css';
import logo from './assets/logo.png';
import cartImg from './assets/cart.png';
import accountIcon from './assets/user.png'; // Assuming you have an account icon image

function NavBar() {
    const navigate = useNavigate();
    const token = localStorage.getItem('token');

    const navigateToLogin = () => {
        navigate("/login");
    };
    const navigateToAddProduct = () => {
        navigate("/AddProduct");
    };

    const navigateToSignUp = () => {
        navigate("/signup");
    };

    const navigateToCart = () => {
        navigate("/cart");
    };
    const handleLogout = () => {
        // Remove the token from local storage
        localStorage.removeItem('token');
        // Redirect to the homepage or login page
        navigate('/login');
    };

    return (
        <nav className="NavBar">
            <img src={logo} alt="Logo" className="logo" />
            <input type="text" placeholder="Search..." className="searchBar" />
            <div className="NavActions">
                <img src={cartImg} alt="Cart" className="cartIcon" onClick={navigateToCart} />
                {token ? (
                    <div className="account">
                        <img src={accountIcon} alt="Account" className="accountIcon"  />
                        <button onClick={navigateToAddProduct} className="navButton">Add Product</button>
                        <button onClick={handleLogout} className="navButton">Logout</button>
                    </div>
                ) : (
                    <div className="account">
                        <button onClick={() => navigate("/login")} className="navButton">Login</button>
                        <span> | </span>
                        <button onClick={navigateToSignUp} className="navButton">Sign up</button>
                    </div>
                )}
            </div>
        </nav>
    );
}

export default NavBar;
