import { configureStore } from "@reduxjs/toolkit"
import { orderSlice } from "../services/orderReducer"
let store = configureStore({
    reducer: {
        [orderSlice.name]: orderSlice.reducer
    }
})

export { store }