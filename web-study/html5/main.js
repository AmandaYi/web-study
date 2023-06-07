const Koa = require("koa")
const App = new Koa()

const Router = require("koa-router")
const static = require("koa-static")
const router = new Router({
    prefix: "/api"
})
router.get("websockettest")

App
    .use(router.routes(), router.allowedMethods())
    .use(static(__dirname + "/views/"))




    .listen(3000, () => {
        console.log("at 3000")
    });