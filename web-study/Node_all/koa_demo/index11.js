// 静态资源
const Koa = require("koa")
const path = require("path")
const static = require("koa-static")

const staticPath = "./static"

const app = new Koa()


app
    .use(static(path.join(__dirname, staticPath)))
     
    .listen(3001, () => {
        console.log("server is running at 3001")
    })
