import React, { useState } from 'react';

interface PaymentModalProps {
  isOpen: boolean;
  onClose: () => void;
  onPay: (paymentData: any) => void;
  orderId: number;
}

const PaymentModal: React.FC<PaymentModalProps> = ({ isOpen, onClose, onPay, orderId }) => {
  const [paymentMethod, setPaymentMethod] = useState('Credit Card');
  const [paymentAmount, setPaymentAmount] = useState('');

  const handlePay = () => {
    const paymentData = {
      paymentMethod,
      paymentAmount: parseFloat(paymentAmount),
      orderId,
    };
    onPay(paymentData);
  };

  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50">
      <div className="bg-white p-6 rounded-lg shadow-lg w-96">
        <h2 className="text-xl font-semibold mb-4">Payment Details</h2>
        <div className="mb-4">
          <label className="block text-sm font-medium text-gray-700">Payment Method</label>
          <select
            value={paymentMethod}
            onChange={(e) => setPaymentMethod(e.target.value)}
            className="mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
          >
            <option>Credit Card</option>
            <option>Debit Card</option>
            <option>eSewa</option>
            <option>Cash on Delivery</option>
          </select>
        </div>
        <div className="mb-4">
          <label className="block text-sm font-medium text-gray-700">Payment Amount</label>
          <input
            type="text"
            value={paymentAmount}
            onChange={(e) => setPaymentAmount(e.target.value)}
            className="mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
          />
        </div>
        <div className="flex justify-end">
          <button
            className="bg-red-500 text-white py-2 px-4 rounded-lg mr-2"
            onClick={onClose}
          >
            Cancel
          </button>
          <button
            className="bg-green-500 text-white py-2 px-4 rounded-lg"
            onClick={handlePay}
          >
            Pay Now
          </button>
        </div>
      </div>
    </div>
  );
};

export default PaymentModal;
