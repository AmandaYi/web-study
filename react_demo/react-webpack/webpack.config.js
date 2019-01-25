const path = require("path")
module.exports = {
    // 入口
    entry: "./app/index.js",
    // 出口
    output: {
        path: path.resolve(__dirname, "./dist"),
        filename: "index.js",
        publicPath: "temp/"
    },
    module: {
        rules: [

            {
                test: /\.css$/,
                use: [{
                    loader: "style-loader"
                },
                {
                    loader: "css-loader"
                }]
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loader: "babel-loader",
                // options: {
                //     presets: ["env", ]
                // }

            }]
    },
    devServer: {
        contentBase: "./",
        host: "localhost",
        compress: true,
        port: 2019
    }
}