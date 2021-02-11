const proxy = require("http-proxy-middleware");

// src/setupProxy.js
module.exports = function(app) {
  app.use(
      proxy(["/tablet/api"], {
        target: "http://localhost:8080",
        changeOrigin: true
      })
  );
};