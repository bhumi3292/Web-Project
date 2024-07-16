import React from 'react';

interface ProductCardProps {
  product: {
    id: number;
    name: string;
    description: string;
    price: string;
    availability: string;
    image: string;
  };
}

const ProductCard: React.FC<ProductCardProps> = ({ product }) => {
  return (
    <div className="items-center p-4 bg-card text-card-foreground rounded-lg shadow-md m-2 flex flex-col">
      <img src={product.image} alt={product.name} className="w-24 h-24 object-cover rounded-lg mb-4"/>
      <div className="text-center">
        <h2 className="text-lg font-bold">{product.name}</h2>
        <p className="text-muted-foreground">{product.description}</p>
        <p className="text-muted-foreground">Price: {product.price}</p>
        <p className="text-muted-foreground">Availability: {product.availability}</p>
      </div>
      <div className="flex space-x-4 mt-4">
        <button className="bg-[#F68704] text-primary-foreground py-2 px-4 rounded-full">Buy now</button>
        <button className="bg-gray-300 text-primary-foreground py-2 px-4 rounded-full">Add to Cart</button>
      </div>
    </div>
  );
};

export default ProductCard;

