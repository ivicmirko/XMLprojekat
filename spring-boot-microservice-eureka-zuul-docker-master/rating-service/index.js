const connection=require("./database")

exports.ratingService = (req, res) => {
	var id=req.param('id');
	var fac=req.param('fac');
	//console.log(fac);
	
	if(id==0){
		connection.query("select * from testTable",(error,result)=>
		{
		  if (error){
			  res.status(400).send(error);
		  }else{
			params=req.params;
			res.status(200).send(result);
		  }
		});
	}else if(id==1){
		connection.query("select testTable.name from testTable",(error,result)=>
		{
		  if (error){
			  res.status(400).send(error);
		  }else{
			params=req.params;
			res.status(200).send(result);
		  }
		});
	}else if(id ==2){
		console.log(fac);
		connection.query("select * from ratingBase.reviews where facilityId=3",(error,result)=>
		{
		  if (error){
			  res.status(400).send(error);
		  }else{
			res.status(200).send(result);
		  }
		});
	}else if(id===3){
		
	}else if(id===4){
		
	}else if(id===5){
		
	}else{
		res.status(400).send("Bad request");
	}
};