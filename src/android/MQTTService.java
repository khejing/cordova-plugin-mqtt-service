package com.yang.eto1.CordovaPlugin.MQTTService;

import android.util.Log;

import org.apache.cordova.CordovaPlugin;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class MQTTService extends CordovaPlugin{
	public void test(){
		Log.i("MQTTService", "test has been called");
	}
}