const Koa = require('koa'),
    Router = require('koa-router'),
    cheerio = require('cheerio'),
    superagent = require('superagent-charset'),
    app = new Koa(),
    router = new Router();

router.get('/', function (ctx, next) {
    ctx.body = "路由搭建好啦";
});

app
    .use(router.routes())
    .use(router.allowedMethods());

app.listen(3000, () => {
    console.log('[服务已开启,访问地址为：] http://127.0.0.1:3000/');
});