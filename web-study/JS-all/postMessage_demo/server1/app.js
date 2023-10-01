const Koa = require("koa")
const static = require("koa-static")
const path = require("path")

const app = new Koa()
app
    .use(static(path.join(__dirname, "./public")))
    .listen(3000, () => {
        console.log("服务3000")
    })