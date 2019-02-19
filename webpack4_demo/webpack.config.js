const path = require("path")
// 引入插件
const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
module.exports = {
    mode: "production",
    // 入口
    entry: {
        /* ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓  ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ */
        // 这里新增加了一个入口,并修改了入口的名字也就是index,和 index2
        index: "./src/index.js",
        /* ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ */
    },
    // 出口
    output: {
        // 出口的文件夹
        path: path.resolve(__dirname, "./dist/"),
        // 修改打包文件的名字,
        // [name] 的意思就是 根据入口文件的名字进行输出打包
        /* ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓  ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ */
        // 修改添加的地方添加的地方, 这里修改了一下输出的文件名为入口的key值
        filename: "[name].js",
        // PS, 强调, 如果这里有publicPath属性,并不会去覆盖掉devServer的属性,因为这是打包的环境
        /* ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ */
    },

    // 模块,例如,解读CSS,图片如何转换,压缩
    module: {
        rules: [
            {
                test: /\.css$/,
                // 第一种写法
                use: ["style-loader", "css-loader"],
                // // 第二种写法
                // loader: ["style-loader", "css-loader"],
                // // 第三种写法
                // use: [
                //     {
                //         loader: "style-loader"
                //         //这里可以跟配置项
                //     },
                //     {
                //         loader: "css-loader"
                //     }
                // ]
            },
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: [{
                    loader: "babel-loader",
                    options: {
                        presets: ["@babel/preset-env"]
                    }
                }]
            }
        ]
    },
    // 插件,用于生产模板,和各项功能
    plugins: [
        // 初始化JS处理插件
        new UglifyJsPlugin()
    ],
    // 配置webpack开发服务功能
    devServer: {
        // 在这里增加了开发服务的功能
        // 设置需要监听的目录
        contentBase: path.resolve(__dirname, 'dist'),
        //  
        host: "localhost",
        // 设置服务器的端口
        port: 3000,
        // 服务器是否启用压缩功能,一般启用
        compress: true,

        // 实时刷新
        inline: true,
        // 新文件的内存路径与配置文件中的publicPath相关，如http://localhost:8080/{publicPath}/bundle.js
        publicPath: "/dist/"
    }
}

