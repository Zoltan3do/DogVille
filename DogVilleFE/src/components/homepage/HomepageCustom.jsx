import CustomNavbar from "../navbar/CustomNavbar";
import CustomSidebar from "../sidebar/CustomSidebar";
import { useSelector } from "react-redux";

function HomepageCustom() {
    const toggleState = useSelector((state) => state.sidebarToggle.value);
    return (
        <>
            <div className="flex flex-col mb-32">
                {/* Navbar */}
                <CustomNavbar />
            </div>

            {/* Sidebar e Contenuto */}
            <div className="flex flex-grow">
                <div className="flex-shrink-0">
                    <CustomSidebar />
                </div>
                <div className={`bg-transparent ${toggleState ? "ml-72" : "ml-24"} transition-all duration-300 flex-grow p-4 `}>
                    <div className=" relative container flex justify-center items-start w-full mx-auto">
                        <img src="src/assets/doga.png" alt="zoeRemoved" className="max-w-screen-sm w-full"/>
                    </div>
                </div>
            </div>
        </>
    );
}

export default HomepageCustom;
