import { SAVE_ORDER } from "./action"

const initialState = {
    orderInfo: {
        id: "",
        orderNo: "",
        prodductName: ""
    }
}
export function reducer(state = initialState, action) {
    switch (action.type) {
        case SAVE_ORDER: {
            return {
                ...state,
                orderInfo: { ...action.payload }
            }
        }
        default: {
            return state
        }
    }
}