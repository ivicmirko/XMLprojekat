const mysql = require('mysql');

let connection = mysql.createConnection({
    host: "35.188.142.212",
    user: "root",
    database: "ratingBase",
    password: "root"
});

connection.connect(function(err) {
    if (err) {
        console.error('Error connecting: ' + err.stack);
        return;
    }
    console.log('Connected as thread id: ' + connection.threadId);
});

module.exports = connection;