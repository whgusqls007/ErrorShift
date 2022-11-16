const express = require("express");
const app = express();
const port = 3001;

app.get("/filehome", (req, res) => {
  res.send("/filehome requested");
});

app.get("/file/download", (req, res) => {
  console.log("index.js /file/download get called");
  res.download("ErrorShift.jar");
});

app.listen(port);
