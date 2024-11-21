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

export const executeLoginFetch = (param1, param2) => async (dispatch) => {
    try {
        const url = "http://locahost:3001/auth/login";
        const response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ email: param1, password: param2 }),
        });
        if (!response.ok) {
            response.json().then((error) => {
                alert(error.message)
            })
            throw new Error("Errore nella chiamata API");
        }
        const data = await response.json();
        localStorage.setItem("Access Token", data.accessToken);
        dispatch(fetchLogin(data));
        alert("Login avvenuto con successo!")
    } catch (error) {
        console.error("Errore durante la fetch:", error);
    }
};

export const { fetchLogin } = loginFetchSlice.actions;
export const loginFetchReducer = loginFetchSlice.reducer;