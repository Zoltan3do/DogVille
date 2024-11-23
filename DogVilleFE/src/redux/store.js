import { configureStore } from "@reduxjs/toolkit"
import { sidebarReducer } from "./sidebarSlice"
import { loginToggleReducer } from "./loginToggleSlice"
import { loginFetchReducer } from "./loginFetchSlice"

export default configureStore({
    reducer: {
        sidebarToggle: sidebarReducer,
        loginModalToggle: loginToggleReducer,
        loginFetches: loginFetchReducer,
    }
})

