import { useSelector, useDispatch } from "react-redux";
import { Button } from "@material-tailwind/react";
import "./navbar.css";
import { changeModalState } from "../../redux/loginToggleSlice";

function CustomNavbar() {
    const toggleState = useSelector((state) => state.sidebarToggle.value);
    const dispatch = useDispatch();
    
    return (
        <nav
            className={`${toggleState ? "ml-72" : "ml-24"} transition-all duration-300 fixed top-0 left-0 w-full z-50 mt-10 sm:mt-0`}
            id="navbara"
        >
            {!toggleState && (
                <div className="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto px-4 sm:px-6 lg:px-8">
                    {/* Testo "Adotta un amico" */}
                    <div className="sm:block md:w-auto">
                        <p className="text-lg font-medium">
                            Adotta un amico &nbsp;
                            <i className="fa fa-solid fa-arrow-right-long align-middle freccetta"></i>
                        </p>
                    </div>

                    {/* Logo */}
                    <a href="#" className="items-center w-full sm:w-auto justify-center sm:justify-start hidden sm:flex">
                        <img
                            src="src/assets/dogvilleLogo-removebg.png"
                            className="w-32"
                            alt="dogville Logo"
                        />
                    </a>

                    {/* Links */}
                    <div className="hidden w-full sm:block sm:w-auto overflow-x-auto mr-28">
                        <ul className="flex flex-col font-medium p-4 sm:p-0 mt-4 bg-gray-50 sm:flex-row md:space-x-8 sm:mt-0 bg-transparent gap-x-3 sm:flex-nowrap">
                            <li className="flex items-center">
                                <a href="tel:+393517416230">
                                    <i className="fa-solid fa-phone align-middle"></i>
                                </a>
                            </li>
                            <li className="flex items-center cursor-pointer">
                                <Button onClick={() => dispatch(changeModalState(true))} className="bg-transparent border-0 text-lg text-whiteino transNone">Accedi</Button>
                            </li>
                            <li className="flex items-center cursor-pointer">
                                <p>Registrati</p>
                            </li>
                        </ul>
                    </div>
                </div>
            )}
        </nav>
    );
}

export default CustomNavbar;

