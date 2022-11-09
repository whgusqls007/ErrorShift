const express = require("express");
const app = express();
const port = 3001;

app.get("/download", (req, res) => {
  res.download("./e206-1.0.0.jar");
});

app.listen(port);
