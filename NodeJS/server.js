const express = require('express');
const cors = require('cors');
const fs = require('fs');
const app = express();
app.use(cors());
app.get('/Users', (req, res) => {
	let users = '';
	fs.readFile(__dirname + '/Users.json','utf8', (err, data) => {
		if (err) {
			throw err;
		}
		users = data;
	});
	console.log(users);
	res.send(users);
});

const port = 5000;

app.listen(port, () => console.log('Server started on port ' + port));
