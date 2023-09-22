export const SAVE_ORDER = "saveOrder"
export function saveOrder(orderInfo) {
    return { type: SAVE_ORDER, payload: orderInfo }
}
export function getOrder(id) {
    // return (dispatch) => {
    //     fetch(url).then(res => {
    //         dispatch(saveOrder(res.info))
    //     })
    // }
    return (dispatch) => {
        setTimeout(() => {
            dispatch(saveOrder({ id: 2, orderNo: 123456789, productName: "衣服" }))
        }, 2000)
    }
}