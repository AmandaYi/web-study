const Koa = require("koa")
const app = new Koa()

const port = 8000

const Router = require("koa-router")
// const router = new Router({
//     prefix :"/api"
// })
const router = new Router()
app.use(router.routes())
app.use(router.allowedMethods())
router.get("/", (ctx, next) => {
    ctx.body = "Hello Router"
    next()
})
router.get("/todo", (ctx, next) => {
    ctx.body = "todo something"
    next()
})
app.listen(port)
console.log('starting at ' + port);
