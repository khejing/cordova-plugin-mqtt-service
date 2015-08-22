package com.yang.eto1.CordovaPlugin;

import org.apache.cordova.CallbackContext;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;

class ActionListener implements IMqttActionListener {	
	public void onSuccess(IMqttToken asyncActionToken ){
		CallbackContext callbackContext = (CallbackContext)asyncActionToken.getUserContext();
		callbackContext.success();
	}
	
	public void onFailure(IMqttToken asyncActionToken, Throwable exception){
		CallbackContext callbackContext = (CallbackContext)asyncActionToken.getUserContext();
		callbackContext.error("async method failed");		
	}
}