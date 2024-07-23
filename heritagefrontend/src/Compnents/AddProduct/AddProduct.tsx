import React, { useState } from 'react';
import axios from 'axios';

const AddProduct: React.FC = () => {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [price, setPrice] = useState<number | ''>('');
  const [stockQuantity, setStockQuantity] = useState<number | ''>('');
  const [availability, setAvailability] = useState<boolean>(true);
  const [categoryId, setCategoryId] = useState<number | ''>('');
  const [productImage, setProductImage] = useState<File | null>(null);

  const handleProductImageChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.target.files) {
      setProductImage(e.target.files[0]);
    }
  };

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append('name', name);
    formData.append('description', description);
    formData.append('price', price.toString());
    formData.append('stockQuantity', stockQuantity.toString());
    formData.append('availability', availability.toString());
    formData.append('categoryId', categoryId.toString());
    if (productImage) formData.append('image', productImage);

    try {
      const response = await axios.post('http://localhost:9090/api/products', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });
      console.log('Product added successfully:', response.data);
    } catch (error) {
      console.error('Error adding product:', error);
    }
  };

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-3xl font-bold mb-6">Add New Product</h1>
      <form onSubmit={handleSubmit} className="bg-white p-6 rounded-lg shadow-lg">
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          <div>
            <label htmlFor="name" className="block text-sm font-medium text-gray-700">Product Name</label>
            <input
              type="text"
              id="name"
              className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
            />
          </div>
          <div>
            <label htmlFor="description" className="block text-sm font-medium text-gray-700">Description</label>
            <textarea
              id="description"
              className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
              rows={4}
              value={description}
              onChange={(e) => setDescription(e.target.value)}
              required
            />
          </div>
          <div>
            <label htmlFor="price" className="block text-sm font-medium text-gray-700">Price</label>
            <input
              type="number"
              id="price"
              className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
              value={price}
              onChange={(e) => setPrice(Number(e.target.value))}
              required
            />
          </div>
          <div>
            <label htmlFor="stockQuantity" className="block text-sm font-medium text-gray-700">Stock Quantity</label>
            <input
              type="number"
              id="stockQuantity"
              className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
              value={stockQuantity}
              onChange={(e) => setStockQuantity(Number(e.target.value))}
              required
            />
          </div>
          <div>
            <label htmlFor="categoryId" className="block text-sm font-medium text-gray-700">Category ID</label>
            <input
              type="number"
              id="categoryId"
              className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
              value={categoryId}
              onChange={(e) => setCategoryId(Number(e.target.value))}
              required
            />
          </div>
          <div>
            <label htmlFor="availability" className="block text-sm font-medium text-gray-700">Availability</label>
            <select
              id="availability"
              className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
              value={availability ? 'true' : 'false'}
              onChange={(e) => setAvailability(e.target.value === 'true')}
            >
              <option value="true">In Stock</option>
              <option value="false">Out of Stock</option>
            </select>
          </div>
          <div>
            <label htmlFor="image" className="block text-sm font-medium text-gray-700">Product Image</label>
            <input
              type="file"
              id="image"
              className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
              accept="image/*"
              onChange={handleProductImageChange}
            />
          </div>
        </div>
        <div className="mt-6 flex justify-end">
          <button
            type="submit"
            className="bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-600"
          >
            Add Product
          </button>
        </div>
      </form>
    </div>
  );
};

export default AddProduct;
