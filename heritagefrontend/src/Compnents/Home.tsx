import React, { useEffect, useState } from 'react';
import "../CSS/Home.css";
import hoemlogo from "./assets/homelogo.png";
import home1 from "./assets/home1.png";
import home2 from "./assets/home2.png";
import home3 from "./assets/home3.png";
import home4 from "./assets/home4.png";
import home5 from "./assets/home5.png";
import home6 from "./assets/home6.png";
import ProductCard from "./ProductCard";
import axios from 'axios';

const Home: React.FC = () => {
  const [categories, setCategories] = useState<string[]>([]);
  const [products, setProducts] = useState<any[]>([]);

  useEffect(() => {
    // Fetch categories from API
    axios.get('http://localhost:9090/api/categories')
      .then(response => {
        // Update the categories state with the fetched data
        setCategories(response.data.map((category: { categoryName: string }) => category.categoryName));
      })
      .catch(error => {
        console.error('Error fetching categories:', error);
      });

    // Fetch products from API
    axios.get('http://localhost:9090/api/products')
      .then(response => {
        // Update the products state with the fetched data
        setProducts(response.data);
      })
      .catch(error => {
        console.error('Error fetching products:', error);
      });
  }, []);

  return (
    <>
      {/* ---------------Side bar----------------- */}
      <div className="flex">
        <div className="Sidebar">
          {categories.length > 0 ? (
            categories.map((category, index) => (
              <button key={index}>{category}</button>
            ))
          ) : (
            <p>Loading categories...</p>
          )}
        </div>

        <div className="w-3/4 p-6">
          <div className="relative">
            <img src={hoemlogo} alt="Unique Handicrafts and Antique Collections" className="w-full h-48 object-cover"/>
            <div className="absolute inset-0 flex flex-col items-center justify-center bg-black bg-opacity-50 text-white">
              <h2 className="text-lg font-semibold">Unique Handicrafts and Antique Collections</h2>
              <p className="text-sm mb-4">Explore our exquisite collection of handcrafted items and antique pieces.</p>
              <div className="flex space-x-4">
                <button className="bg-[#F68704] text-primary-foreground py-2 px-4 rounded-full">Buy</button>
                <button className="bg-[#F68704] text-primary-foreground py-2 px-4 rounded-full">Explore</button>
              </div>
            </div>
          </div>

          <div className="flex space-x-4 mt-6">
            <div className="w-1/6 h-full">
              <img src={home1} alt="Artisanal Crafts Craftsmanship at its Best" className="w-full h-24 object-cover"/>
              <p className="text-center text-sm mt-2">Artisanal Crafts Craftsmanship at its Best</p>
            </div>
            <div className="w-1/6">
              <img src={home2} alt="A wooden sculpture" className="w-full h-24 object-cover"/>
              <p className="text-center text-sm mt-2">A wooden sculpture</p>
            </div>
            <div className="w-1/6">
              <img src={home3} alt="1016 1068" className="w-full h-24 object-cover"/>
              <p className="text-center text-sm mt-2">1016 1068</p>
            </div>
            <div className="w-1/6">
              <img src={home4} alt="Bamboo Baskets" className="w-full h-24 object-cover"/>
              <p className="text-center text-sm mt-2">Bamboo Baskets</p>
            </div>
            <div className="w-1/6">
              <img src={home6} alt="Locket" className="w-full h-24 object-cover"/>
              <p className="text-center text-sm mt-2">Locket</p>
            </div>
          </div>

          <div className="flex items-center mt-12">
            <div className="w-1/2">
              <h2 className="text-2xl font-semibold">Hand Crafted Earrings Awaits</h2>
              <p className="mt-4 text-muted-foreground">Indulge in the beauty of artisanal craftsmanship with our stunning array of handcrafted marvels. Each piece is meticulously curated to bring you joy and add a touch of elegance to your surroundings.</p>
              <button className="mt-6 bg-[#F68704] text-primary-foreground py-2 px-4 rounded-full">Cart List</button>
            </div>
            <div className="w-1/2">
              <img src={home5} alt="Hand Crafted Earrings" className="size-64 object-cover rounded-lg"/>
            </div>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 mt-12">
            {products.length > 0 ? (
              products.map(product => (
                <ProductCard key={product.productId} product={product} />
              ))
            ) : (
              <p>Loading products...</p>
            )}
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
