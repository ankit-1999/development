// Rest APIs for angular application

const express = require("express");
const mysql = require("mysql");

const app = express();
const cors = require("cors");
app.use(express.json());
app.use(cors());

const port = 4000;

const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "nodeassignment",
});

db.connect((err) => {
  if (err) {
    console.log("error");
    throw err;
  }
  console.log("Mysql Connect.....");
});

// to get all students
app.get("/students", (req, res) => {
  let sql = "SELECT * FROM student";
  let query = db.query(sql, (err, result) => {
    if (err) {
      throw err;
    }
    res.send(result);
  });
});

// to get student with given id
app.get("/student/:id", (req, res) => {
  let sql = "SELECT * FROM student WHERE rollNo =?";
  console.log(req.params.id);
  let query = db.query(sql, [req.params.id], (err, result) => {
    if (err) {
      throw err;
    }
    console.log(result);
    if (result.length > 0) {
      res.send(result);
    } else {
      console.log("No student found");
      res.status(404).send("invalid student rollno");
    }
  });
});

// to delete a student with give id
app.delete("/student/:id", (req, res) => {
  let sql = "DELETE FROM student WHERE rollNo =?";
  let query = db.query(sql, [req.params.id], (err, result) => {
    if (err) {
      throw err;
    }
    res.send("student deleted successfully");
  });
});

// add student
app.post("/addStudent", (req, res) => {
  const { rollNo, name, dateOfBirth, score } = req.body;
  let sql = "INSERT INTO student VALUES (?,?,?,?)";
  let query = db.query(
    sql,
    [rollNo, name, dateOfBirth, score],
    (err, result) => {
      if (err) {
        throw err;
      }
      res.send(req.body);
    }
  );
});

//update student
app.put("/updateStudent", (req, res) => {
  const { rollNo, name, dateOfBirth, score } = req.body;
  let sql =
    "UPDATE student SET name =? , dateOfBirth =?, score =?  WHERE rollNo =?";
  let query = db.query(
    sql,
    [name, dateOfBirth, score, rollNo],
    (err, result) => {
      if (err) {
        throw err;
      }
      res.send(req.body);
    }
  );
});

app.listen(port, () => {
  console.log("server started on port  " + port);
});
