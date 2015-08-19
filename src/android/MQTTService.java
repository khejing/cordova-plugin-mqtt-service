package com.yang.eto1.CordovaPlugin;

import android.util.Log;

import org.apache.cordova.CordovaPlugin;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class MQTTService extends CordovaPlugin{
	public boolean test(){
		Log.i("MQTTService", "test has been called");
		return true;
	}
}