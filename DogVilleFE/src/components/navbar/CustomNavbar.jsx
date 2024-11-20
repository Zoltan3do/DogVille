function CustomNavbar() {
    return (

        <>
            <nav className="bg-transparent ml-1 ">
                <div className="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto ">
                    <div className="hidden w-full md:block md:w-auto" id="navbar-dropdown">
                            <p>Adotta un amico &nbsp;<i className="fa fa-solid fa-arrow-right-long align-middle freccetta"></i></p>
                    </div>
                    <a href="#" className="flex items-center space-x-3 rtl:space-x-reverse">
                        <img src="src/assets/dogvilleLogo-removebg.png" className="w-32" alt="dogville Logo" />
                    </a>

                    <div className="hidden w-full md:block md:w-auto" id="navbar-dropdown">
                        <ul className="flex flex-col font-medium p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 bg-transparent">
                            <a href=""><i className="fa-solid fa-phone align-bottom"></i></a> {/* INSERIRE IL NUMERO DI TELEFONO PRESO DALLA FETCH */}
                            <p>Login</p>
                            <p>Sign In</p>
                        </ul>
                    </div>
                </div>
            </nav>
        </>
    )
}

export default CustomNavbar;