function subscribe(){
	cordova.exec(function(){
		console.log("test has been called success");
	}, function(e){
		console.log("error happened", e);
	}, "MQTTService", "test", []);
}

exports.subscribe = subscribe;