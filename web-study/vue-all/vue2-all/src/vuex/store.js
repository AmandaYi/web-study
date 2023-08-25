import Vue from "vue"
import Vuex from "vuex"

Vue.use(Vuex)

const baseUse = {
    // 这里写错了字母，找问题找了好久，一直调取不到函数，写成了namespace: true
    namespaced: true,
    state: {
        computedData: {
            limitPrice: 10 // 保存服务价格
        }
    },
    mutations: {
        updateComputedData(state, payload = 0) {
            if (payload != 0) {
                state.computedData.limitPrice = payload
            } else {
                state.computedData.limitPrice = 100
            }

        }
    }
}
const store = new Vuex.Store({
    modules: {
        baseUse
    }
})
export default store