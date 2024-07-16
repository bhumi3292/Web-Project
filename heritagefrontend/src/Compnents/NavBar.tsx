import { useNavigate } from 'react-router-dom';
import '../CSS/NavBar.css';
import logo from './assets/logo.png';
import cartImg from './assets/cart.png';
import accountIcon from './assets/user.png'; // Assuming you have an account icon image

function NavBar() {
    const navigate = useNavigate();

    const navigateToLogin = () => {
        navigate("/login");
    };

    const navigateToSignUp = () => {
        navigate("/signup");
    };

    const navigateToCart = () => {
        navigate("/cart");
    };

    return (
        <nav className="NavBar">
            <img src={logo} alt="Logo" className="logo" />
            <input type="text" placeholder="Search..." className="searchBar" />
            <div className="NavActions">
                <img src={cartImg} alt="Cart" className="cartIcon" onClick={navigateToCart} />
                <div className="account">
                    <img src={accountIcon} alt="Account" className="accountIcon" />
                    <button onClick={navigateToLogin} className="navButton">Login</button>
                    <span> | </span>
                    <button onClick={navigateToSignUp} className="navButton">Sign up</button>
                </div>
            </div>
        </nav>
    );
}

export default NavBar;
