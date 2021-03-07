/* eslint-disable import/no-extraneous-dependencies */
const path = require('path');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const CopyPlugin = require('copy-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const PATHS = require('./webpack.paths.js');

module.exports = {
  entry: `${PATHS.src}/js/index.jsx`,
  output: {
    filename: `${PATHS.assets}js/index.js`,
    path: `${PATHS.build}`,
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        resolve: {
          extensions: ['.js', '.jsx'],
        },
        use: {
          loader: 'babel-loader',
        },
      },
      {
        test: /\.scss$/,
        use: [
          {
            loader: 'style-loader',
          },
          MiniCssExtractPlugin.loader,
          {
            loader: 'css-loader',
            options: {
              url: false,
              modules: {
                localIdentName: '[local]',
              },
              importLoaders: 2,
            },
          },
          {
            loader: 'postcss-loader',
            options: {
              postcssOptions: {
                config: path.resolve(__dirname, 'postcss.config.js'),
              },
            },
          },
          {
            loader: 'sass-loader',
          },
        ],
      },
      {
        test: /\.(png|jpe?g|svg|gif|ico)$/,
        use: [
          {
            loader: 'file-loader',
            options: {
              name: '[name].[ext]',
              outputPath: `${PATHS.assets}img`,
            },
          },
          {
            loader: 'image-webpack-loader',
            options: {
              bypassOnDebug: true,
              optipng: {
                enabled: true,
              },
              pngquant: {
                strip: true,
                quality: [0.65, 0.90],
                speed: 5,
              },
              mozjpeg: {
                quality: 70,
                progressive: true,
              },
              svgo: {
                plugins: [
                  {
                    removeViewBox: false,
                  },
                ],
              },
            },
          },
        ],
      },
    ],
  },
  plugins: [
    new CleanWebpackPlugin(),
    new HtmlWebpackPlugin({
      filename: './index.html',
      template: `${PATHS.src}/index.html`,
      favicon: './source/favicon/favicon.ico',
    }),
    new MiniCssExtractPlugin({
      filename: `${PATHS.assets}css/style.css`,
    }),
    new CopyPlugin({
      patterns: [
        { from: `${PATHS.src}/fonts`, to: `${PATHS.assets}fonts` },
      ],
    }),
  ],
};
