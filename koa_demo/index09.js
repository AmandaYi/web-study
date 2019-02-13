const Koa = require("koa")

const app = new Koa()





app.use(async (ctx) => {
    let url = ctx.url
    let method = ctx.method
    if (url == "/login" && method == "POST") {
        // 设置cookie
        ctx.cookies.set("username", "zzy", {
            maxAge: 10000,
            expires: new Date("2019-2-13 10:25"),
            path: "/",
            domain: "localhost",
            httpOnly: false,
            overwrite: false
        })
        ctx.body = {
            errmsg: "登陆成功!",
            errno: 0
        }
    } else {
        if (ctx.cookies.get("username")) {
            ctx.body = {
                username: ctx.cookies.get("username")
            }
        } else {
            ctx.body = {
                errmsg: "您还没有登录!",
                errno: -1
            }
        }
    }
})

app.listen(3000);


