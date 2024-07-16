function ProductCard(){
    return(<div className="max-w-sm mx-auto bg-card text-card-foreground p-4 rounded-lg shadow-md">
        <img className="w-full h-48 object-cover rounded-lg mb-4" src="https://placehold.co/300x200" alt="Product image" />
        <div className="text-left">
          <p className="font-bold">Product Name</p>
          <p>Description</p>
          <p>Price:</p>
          <p>Availability:</p>
        </div>

        <div className="SecondCard">
            <img className="Second" src="" alt="Product img"/>
            <div className="text-left">
          <p className="font-bold">Product Name</p>
          <p>Description</p>
          <p>Price:</p>
          <p>Availability:</p>
          </div>


        </div>
      </div>
      
    )
}
export default ProductCard