const Koa = require("koa")
const Router = require("koa-router")

const app = new Koa()
const router = new Router({
    prefix:"/all"
})

// 层级路由1
const homeRouter = new Router()
homeRouter.get("/index", async (ctx) => {
    ctx.body = "home router\'s index"
})
homeRouter.get("/todo", async (ctx) => {
    ctx.body = "home router\' todo"
})
router
    .use("/home", homeRouter.routes())
// 如果不写仅仅通过允许的方法的话,会自动继承父级的router
// .use(homeRouter.allowedMethods())
const listRouter = new Router()
listRouter.get("/index", async (ctx) => {
    ctx.body = "list router\'s index"
})
listRouter.get("/todo", async (ctx) => {
    ctx.body = "list router\' todo"
})
router.use("/list", listRouter.routes())
const argsRouter = new Router()
argsRouter.get("/login", async (ctx) => {
    let query = ctx.query
    ctx.body = query
})
router
    .use("/login", argsRouter.routes())
    .use(argsRouter.allowedMethods())

app
    .use(router.routes())
    .use(router.allowedMethods())
    .listen(3000, () => {
        console.log("server is running at 3000 port")
    })
