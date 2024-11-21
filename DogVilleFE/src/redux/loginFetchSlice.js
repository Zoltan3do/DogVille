import { createSlice } from "@reduxjs/toolkit"

export const loginFetchSlice = createSlice({
    name: "loginFetch",

    initialState: {
        value: {}
    },

    reducers: {
        fetchLogin: (state, action) => {
            state.value = action.payload
        }
    }
})



export const {fetchLogin} = loginFetchSlice.actions;
export const loginFetchReducer = loginFetchSlice.reducer;