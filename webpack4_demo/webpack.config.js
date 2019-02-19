const path = require("path")
module.exports = {
    mode: "development",
    // 入口
    entry: "./src/index.js",
    // 出口
    output: {
        // 出口的文件夹
        path: path.resolve(__dirname, "/dist/"),
        // 修改打包文件的名字,
        // [name] 的意思就是 根据入口文件的名字进行输出打包
        filename: "build.js"
    },
    // 模块,例如,解读CSS,图片如何转换,压缩
    module: {},
    // 插件,用于生产模板,和各项功能
    plugins: [],
    // 配置webpack开发服务功能
    devServer: {
        // 在这里增加了开发服务的功能
        // 设置需要监听的目录
        contentBase:path.resolve(__dirname,'dist'),
        //  
        host: "localhost",
        // 设置服务器的端口
        port: 3000,
        // 服务器是否启用压缩功能,一般启用
        compress: true,
 
        // 实时刷新
        inline: true,
        // 新文件的内存路径与配置文件中的publicPath相关，如http://localhost:8080/{publicPath}/bundle.js
        // publicPath: "/dist/"
    }
}

