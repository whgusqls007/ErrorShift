const express = require("express");
const app = express();
const port = 3001;

app.get("/file/download", (req, res) => {
  console.log('index.js /file/download get called')
  res.download("./e206-1.0.0.jar");
});

app.listen(port);
