/* eslint-disable import/no-extraneous-dependencies */
const { merge } = require('webpack-merge');
const common = require('./webpack.common.js');

const PATHS = require('./webpack.paths');

module.exports = merge(common, {
  mode: 'development',
  devServer: {
    host: 'localhost',
    contentBase: `${PATHS.build}/`,
    port: 8081,
    open: true,
  },
  target: 'web',
  devtool: 'inline-source-map',
});
