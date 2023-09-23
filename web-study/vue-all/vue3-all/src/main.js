import { createApp } from 'vue'
import App from './App.vue'
import router from './components/RouterUse/router.js'

const app = createApp(App)

app.use(router)
router.isReady().then(()=>{
    app.mount('#app')
})
