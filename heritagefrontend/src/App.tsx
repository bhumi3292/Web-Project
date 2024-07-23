import NavBar from "./Compnents/NavBar.tsx";
import { createBrowserRouter, Outlet, RouterProvider } from "react-router-dom";
import Footer from "./Compnents/fOOTER.tsx";
import Home from "./Compnents/Home.tsx";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import Login from "./Compnents/Login.tsx";
import Signup from "./Compnents/Signup.tsx";
import CartPage from "./Compnents/CartPage.tsx";
import AddProduct from "./Compnents/AddProduct/AddProduct.tsx";

const AppLayout = () => {
    return (
        <>
            <NavBar />
            <Outlet />
            <Footer />
        </>
    );
};

const queryClient = new QueryClient();

function App() {
    const router = createBrowserRouter([
        {
            element: <AppLayout />,
            children: [
                {
                    path: "/",
                    element: <Home />
                },
                {
                    path: "/login",
                    element: <Login />
                },
                {
                    path: "/signup",
                    element: <Signup />
                },{
                    path: "/cart",
                    element: <CartPage />
                },{
                    path:"/AddProduct",
                    element: <AddProduct/>
                }
            ]
        }
    ]);

    return (
        <>
            <QueryClientProvider client={queryClient}>
                <RouterProvider router={router} />
            </QueryClientProvider>
        </>
    );
}

export default App;
