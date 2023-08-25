import Vue from 'vue'
import App from './App.vue'
import store from "./vuex/store"
Vue.config.productionTip = false
Vue.config.devtools = true
const vm = new Vue({
  render: h => h(App),
  store
}).$mount('#app')