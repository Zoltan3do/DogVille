import CustomNavbar from "../navbar/CustomNavbar";
import CustomSidebar from "../sidebar/CustomSidebar";

function HomepageCustom() {
    return (
        <div className="flex flex-col h-screen">
            <CustomNavbar />

            <div className="flex flex-grow">
                <div className="flex-shrink-0">
                    <CustomSidebar />
                </div>
            </div>
        </div>
    )
}
export default HomepageCustom;