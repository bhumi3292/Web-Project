import NavBar from "./Compnents/NavBar.tsx";
import { createBrowserRouter, Outlet, RouterProvider } from "react-router-dom";
import Footer from "./Compnents/fOOTER.tsx";
import Home from "./Compnents/Home.tsx";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import Login from "./Compnents/Login.tsx";
import Signup from "./Compnents/Signup.tsx";

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
