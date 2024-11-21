import { configureStore } from "@reduxjs/toolkit"
import { sidebarReducer } from "./sidebarSlice"
import { loginToggleReducer } from "./loginToggleSlice"

export default configureStore({
    reducer: {
        sidebarToggle: sidebarReducer,
        loginModalToggle: loginToggleReducer
    }
})