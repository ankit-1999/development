const express = require("express");
const mysql = require("mysql");
const path = require("path");

const app = express();

app.use(express.static("public"));

app.set("view engine", "ejs");

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

var connection = mysql.createConnection({multipleStatements: true});

app.get("/login", (req, res) => {
  // res.sendFile(path.join(__dirname,'../views/login.html'));
  res.render("login");
});

app.get("/logout", (req, res) => {
  res.render("login");
});

app.get("/teacher", (req, res) => {
    let sql = "SELECT * FROM student";
    let query = db.query(sql, (err, result) => {
    if (err) {
      throw err;
    }
    console.log("students fetched.......");
    res.render("teacherView",{Students: result});
  });
  
});

app.get("/student", (req, res) => {
  res.render("studentView");
});

app.get("/addStudent", (req, res) => {
  res.render("add");
});

app.get("/", (req, res) => {
  res.render("home");
});

app.get("/students", (req, res) => {
  let sql = "SELECT * FROM student";
  let query = db.query(sql, (err, result) => {
    if (err) {
      throw err;
    }
    console.log("students fetched.......");
    res.send(result);
  });
});


app.get("/delete/:rollNo", (req, res) => {
 // console.log(req.params.rollNo);
  let sql = "DELETE FROM student WHERE rollNo = " + req.params.rollNo;
  let query = db.query(sql, (err, result) => {
    if (err) {
      throw err;
    }
    console.log("student got.....");
    res.redirect('/teacher');
  });
});

app.get('/edit/:rollNo', (req, res) => {
  // console.log(req.params.rollNo);
  let sql = "SELECT * FROM student WHERE rollNo = " + req.params.rollNo;
  let query = db.query(sql, (err, result) => {
    if (err) {
      throw err;
    }
    console.log("student got.....");
    if (result.length > 0) {
      res.render("edit", { student: result });
    } else {
      // alert("invalid student details");
      console.log("invalid student details");
      res.redirect("/teacher");
    }
  });

})

app.get('/editStudent', (req, res) => {
 // console.log(req.query);
  let sql="UPDATE student SET `name` = '"+req.query.name+"', `dateOfBirth` = '"+req.query.dateOfBirth+"', `score` = '"+req.query.score+"' WHERE (`rollNo` = '"+req.query.rollNo+"');"
  let query = db.query(sql, (err, result) => {
    if (err) {
      throw err;
    }
    console.log("student record updated scessfully in database.......");
    res.redirect('/teacher');
  });
})

app.get('/add', (req, res) => {
  let sql = "INSERT INTO student VALUES ('"+req.query.rollNo+"',"+"'"+req.query.name+"',"+"'"+req.query.dateOfBirth+"',"+"'"+req.query.score+"')";
  let query = db.query(sql, (err, result) => {
    if (err) {
      throw err;
    }
    console.log("student inserted in database.......");
    res.redirect('/teacher');
  });
})

app.get('/displayResult', (req, res) => {
 // console.log(req.query);
  let sql = `SELECT * FROM student WHERE rollNo = ${req.query.rollNo}`;
  let query = db.query(sql, (err, result) => {
    if (err) {
      throw err;
    }
    console.log("student got.....");
    if (result.length > 0) {
      console.log(result[0].rollNo);
      if(result[0].name==req.query.name)
      {
        res.render("result", { student: result });
      }
      else
      {
        console.error("invalid student details");
        res.redirect("/student");
      }
    } else {
      // alert("invalid student details");
      console.error("invalid student details");
      res.redirect("/student");
    }
  });
 

  
})

app.listen(3000, () => {
  console.log("server started on port 3000 ");
});
