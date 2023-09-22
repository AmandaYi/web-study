import { createSlice } from "@reduxjs/toolkit"

const orderSlice = createSlice({
    name: "order",
    initialState: {
        id: "", // 订单id
        productName: "", // 产品名称
        orderNo: "" // 订单号
    },
    reducers: {
        saveOrder(state, action) {
            state.id = action.payload.id
            state.productName = action.payload.productName
            state.orderNo = action.payload.orderNo
        }
    }
})

export { orderSlice }