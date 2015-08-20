package com.yang.eto1.CordovaPlugin;

import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class MQTTService extends CordovaPlugin{
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext){
		if("test".equals(action)){
			Log.i("MQTTService", "test has been called");
			return true;
		}
		return false;
	}
}