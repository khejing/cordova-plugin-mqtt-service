package com.yang.eto1.CordovaPlugin;

import org.apache.cordova.CallbackContext;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttCallbackHandler implements MqttCallback {
	private CallbackContext msgCallback;

	protected setMsgCallbackContext(CallbackContext callbackContext){
		msgCallback = callbackContext;
	}

    @Override
    public void connectionLost(Throwable cause) {
	    //cause.printStackTrace();
        if (cause != null) {
        }
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
	    Log.i("MQTTService", "Java got message "+message.getPayload()+" from topic "+topic);
		msgCallback.suceess(message.getPayload());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // Do nothing
    }
}
