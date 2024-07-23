import axios from 'axios';
import React, { useEffect, useState } from 'react';
import PaymentModal from './PaymentModal';

const CartPage: React.FC = () => {
  const [cartItems, setCartItems] = useState<any[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [checkoutError, setCheckoutError] = useState<string | null>(null); 
  const [checkoutSuccess, setCheckoutSuccess] = useState<boolean>(false);
  const [orderHistory, setOrderHistory] = useState<any[]>([]);
  const [isPaymentModalOpen, setIsPaymentModalOpen] = useState<boolean>(false);
  const [selectedOrderId, setSelectedOrderId] = useState<number | null>(null);
  const userId = localStorage.getItem('userId');

  useEffect(() => {
    const fetchCartItems = async () => {
      try {
        const response = await axios.get(`http://localhost:9090/api/cart-items/cart/${userId}`);
        console.log(response);
        setCartItems(response.data);
      } catch (err) {
        setError('Failed to fetch cart items.');
        console.error(err);
      } finally {
        setLoading(false);
      }
    };
    const fetchOrderHistory = async () => {
      try {
        const response = await axios.get(`http://localhost:9090/api/orders/user/${userId}`);
        console.log(response);
        setOrderHistory(response.data);
      } catch (err) {
        console.error('Failed to fetch order history:', err);
      }
    };
    if (userId) {
      fetchCartItems();
      fetchOrderHistory();
    } else {
      setError('User ID is not available.');
      setLoading(false);
    }
  }, [userId]);

  const totalPrice = cartItems.reduce((total, item) => total + item.product.price * item.quantity, 0);
  const tax = (parseFloat(totalPrice) * 0.1).toFixed(2);
  const totalWithTax = (parseFloat(totalPrice) + parseFloat(tax)).toFixed(2);

  const handleRemoveItem = async (itemId: number) => {
    try {
      await axios.delete(`http://localhost:9090/api/cart-items/${itemId}`);
      setCartItems(cartItems.filter(item => item.id !== itemId));
    } catch (err) {
      console.error('Failed to remove item:', err);
    }
  };

  const handleUpdateQuantity = async (itemId: number, quantity: number, productId: number, cartId: number) => {
    console.log(itemId, quantity, productId, cartId);
    try {
      await axios.put(`http://localhost:9090/api/cart-items/${itemId}`, { quantity, productId, cartId });
      setCartItems(cartItems.map(item => item.id === itemId ? { ...item, quantity } : item));
      window.location.reload();
    } catch (err) {
      console.error('Failed to update quantity:', err);
    }
  };

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  const handleCheckout = async () => {
    const customerId = parseInt(userId || '', 10);
    try {
      const orderItems = {
        customerId,
        totalAmount: totalPrice,
      };
      console.log(orderItems);
      await axios.post('http://localhost:9090/api/orders', orderItems);
      setCheckoutSuccess(true);
      setCartItems([]);
    } catch (err) {
      setCheckoutError('Failed to process the order.');
      console.error('Failed to process order:', err);
    }
  };

  const handlePayNow = (orderId: number) => {
    setSelectedOrderId(orderId);
    setIsPaymentModalOpen(true);
  };

  const handlePayment = async (paymentData: any) => {
    try {
      await axios.post(`http://localhost:9090/api/payments`, paymentData);
      const updatedOrderHistory = orderHistory.map(order =>
        order.orderId === paymentData.orderId ? { ...order, orderStatus: 'paid' } : order
      );
      setOrderHistory(updatedOrderHistory);
      setIsPaymentModalOpen(false);
    } catch (err) {
      console.error('Failed to process payment:', err);
    }
  };

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-3xl font-semibold mb-6">Shopping Cart</h1>
      <div className="flex flex-col lg:flex-row">
        {/* Cart Items Section */}
        <div className="w-full lg:w-3/4 lg:pr-6">
          {cartItems.map(item => (
            <div key={item.product.productId} className="flex items-center mb-4 bg-white p-4 rounded-lg shadow-md">
              <img src={item.product.image} alt={item.product.name} className="w-24 h-24 object-cover rounded-lg mr-4"/>
              <div className="flex-grow">
                <h2 className="text-lg font-bold">{item.product.name}</h2>
                <p className="text-sm text-muted-foreground">{item.product.description}</p>
                <p className="text-sm">Price: Npr.{item.product.price}</p>
                <p className="text-sm">Quantity: {item.quantity}</p>
              </div>
              <div className="flex flex-col items-end">
                <button 
                  className="bg-red-500 text-white py-1 px-2 rounded-full mb-2"
                  onClick={() => handleRemoveItem(item.id)}
                >
                  Remove
                </button>
                <button 
                  className="bg-blue-500 text-white py-1 px-2 rounded-full"
                  onClick={() => handleUpdateQuantity(item.cartItemId, item.quantity + 1, item.product.productId, item.cart.cartId)}
                >
                  Increase Quantity
                </button>
                {item.quantity > 1 && (
                  <button 
                    className="bg-blue-500 text-white py-1 px-2 rounded-full mt-2"
                    onClick={() => handleUpdateQuantity(item.cartItemId, item.quantity - 1, item.product.productId, item.cart.cartId)}
                  >
                    Decrease Quantity
                  </button>
                )}
              </div>
            </div>
          ))}
        </div>
        {/* Order Summary Section */}
        <div className="w-full lg:w-1/4 bg-white p-6 rounded-lg shadow-md">
          <h2 className="text-xl font-semibold mb-4">Order Summary</h2>
          <p>Total Price: Npr.{totalPrice}</p>
          <p>Tax (10%): Npr.{tax}</p>
          <p>Total with Tax: Npr.{totalWithTax}</p>
          <button 
            className="bg-green-500 text-white py-2 px-4 rounded-lg w-full mt-4"
            onClick={handleCheckout}
          >
            Checkout
          </button>
          {checkoutError && <p className="text-red-500 mt-2">{checkoutError}</p>}
          {checkoutSuccess && <p className="text-green-500 mt-2">Order placed successfully!</p>}
        </div>
      </div>
      {/* Order History Section */}
      <div className="mt-8">
        <h2 className="text-2xl font-semibold mb-4">Order History</h2>
        {orderHistory.map(order => (
          <div key={order.orderId} className="bg-white p-4 rounded-lg shadow-md mb-4">
            <p>Order ID: {order.orderId}</p>
            <p>Total Amount: Npr.{order.totalAmount}</p>
            <p>Order Status: {order.orderStatus}</p>
            {order.orderStatus === 'pending' && (
              <button 
                className="bg-green-500 text-white py-2 px-4 rounded-lg"
                onClick={() => handlePayNow(order.orderId)}
              >
                Pay Now
              </button>
            )}
          </div>
        ))}
      </div>
      <PaymentModal
        isOpen={isPaymentModalOpen}
        onClose={() => setIsPaymentModalOpen(false)}
        onPay={handlePayment}
        orderId={selectedOrderId!}
      />
    </div>
  );
};

export default CartPage;
