const connection=require("./database")

exports.sendComment = function sendComment(req, res) {
    let idUser = req.body.idUser;
    let text = req.body.text;
    let published = req.body.published;
    let datum = req.body.datum;
	let accommodationFacilityId = req.body.accommodationFacilityId;
    connection.query("insert into ratingBase.reviews (idUser, accommodationFacilityId, published, date, text) values (?, ?, ?, ?, ?)", [idUser, accommodationFacilityId, published, datum, text], (err, result) => {
	if (err) res.status(400).send(err);
	else {
		
		res.status(200).send('dodat komentar');

	}
	
    });
};

exports.getAllComments = function getAllComments(req, res) {

    connection.query("select * from ratingBase.reviews", (err, result) => {
	if (err) res.status(400).send(err);
	else {
		
		res.status(200).send(result);

	}
	
    });
};

exports.publishComment = function publishComment(req, res) {
	let flag = req.body.flag;
    let id = req.body.id;
    connection.query("UPDATE `reviews` SET `published` = "+flag+" where id = "+id, (err, result) => {
	if (err) res.status(400).send(err);
	else {
		
		res.status(200).send(result);

	}
	
    });
};

