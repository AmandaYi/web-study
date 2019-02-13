// 渲染模板
// ejs
const Koa = require("koa")
const path = require("path")
const view = require("koa-views")

const viewPath = "./view"

const app = new Koa();


app
    // 加载模板引擎
    .use(view(path.join(__dirname, viewPath), {
        extension: "ejs"
    }))
    // 进入路由等
    .use(async (ctx) => {
        let url = ctx.url, method = ctx.method
        if (url == "/" && method == "GET") {
            await ctx.render("index", {
                title: "首页",
                desc: "今天天气不错!"
            }, () => {
                ctx.body = "404"
            })
        }
    })
    .listen(3001, () => {
        console.log("server is running at 3000")
    })

