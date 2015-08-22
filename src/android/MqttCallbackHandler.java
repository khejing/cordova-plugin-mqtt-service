package com.yang.eto1.CordovaPlugin;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttCallbackHandler implements MqttCallback {
  @Override
  public void connectionLost(Throwable cause) {
//	  cause.printStackTrace();
    if (cause != null) {
    }
  }

  @Override
  public void messageArrived(String topic, MqttMessage message) throws Exception {
	  
  }

  @Override
  public void deliveryComplete(IMqttDeliveryToken token) {
    // Do nothing
  }

}
