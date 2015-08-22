var mqttClient = {
	connect: function(server, opts, successCb, errorCb){
    	cordova.exec(successCb, errorCb, "MQTTService", "connect", [server, opts]);
	},
	onConnectionLost: function(cb){
		cordova.exec(cb, null, "MQTTService", "onConnectionLost", []);
	},
	onMessage: function(messageCb){
		cordova.exec(messageCb, null, "MQTTService", "onMessage", []);
	},
	subscribe: function(topic){
		cordova.exec(null, null, "MQTTService", "subscribe", [topic])
	},
	publish: function(topic, msg){
		cordova.exec(null, null, "MQTTService", "publish", [topic, msg])
	},
	end: function(){
		cordova.exec(null, null, "MQTTService", "end", []);
	}
}

module.exports = mqttClient;