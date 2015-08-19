function subscribe(){
	cordova.exec(function(){
		console.log("test has been called success");
	}, function(){
		console.log("error happened");
	}, "MQTTService", "test", null);
}

exports.subscribe = subscribe;