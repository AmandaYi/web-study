import { createRouter, createWebHashHistory } from "vue-router"
import List from "./list.vue"
import Detail from "./detail.vue"

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        { path: "/list", component: List, name: "list" },
        { path: "/detail", component: Detail, name: "detail" }
    ]
})
const routes = [
    {
        path: "/list"
    }
]

export default router