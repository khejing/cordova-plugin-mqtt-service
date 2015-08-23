package com.yang.eto1.CordovaPlugin;

import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class MQTTService extends CordovaPlugin{
	private MqttAndroidClient client;
	private void connect(JSONArray args, CallbackContext callbackContext){
		String serverURI, clientId;
		boolean cleanSession;
		try{
			serverURI = args.getString(0);
			JSONObject opts = args.getJSONObject(1);
			clientId = opts.getString("clientId");
			cleanSession = opts.getBoolean("clean");			
		}catch(JSONException e){
            Log.e(this.getClass().getCanonicalName(), "JSONException Occured");
			callbackContext.error("JSON error");
			return;
		}

		client = new MqttAndroidClient(cordova.getActivity(), serverURI, clientId, new MemoryPersistence());
		client.setCallback(new MqttCallbackHandler());
        client.setTraceCallback(new MqttTraceCallback());
		MqttConnectOptions conOpt = new MqttConnectOptions();
		conOpt.setCleanSession(cleanSession);

        try {
            client.connect(conOpt, callbackContext, new ActionListener());
			Log.i("MQTTService", "mqtt connect success return");
        } catch (MqttException e) {
            Log.e(this.getClass().getCanonicalName(), "MqttException Occured", e);
			callbackContext.error(e.toString());
        }
	}

	private void onConnectionLost(CallbackContext callbackContext){
		Log.i("MQTTService", "mqtt onConnectionLost success");
	}

	private void onMessage(CallbackContext callbackContext){
		Log.i("MQTTService", "mqtt onMessage success");
	}

	private void subscribe(JSONArray args){
		String topic;
		try {
            topic = args.getString(0);
            client.subscribe(topic, 0);
            Log.i("MQTTService", "mqtt subscribe success");
        }catch (MqttSecurityException e) {
            Log.e(this.getClass().getCanonicalName(), "Failed to subscribe to" + topic, e);
        }catch (MqttException e) {
            Log.e(this.getClass().getCanonicalName(), "Failed to subscribe to" + topic, e);
        }
	}

	private void publish(JSONArray args){
		Log.i("MQTTService", "mqtt publish success");
	}

	private void end(){
		Log.i("MQTTService", "mqtt end success");
	}

	public boolean execute(String action, JSONArray args, CallbackContext callbackContext){
		if("connect".equals(action)){
			connect(args, callbackContext);
			return true;
		}else if("onConnectionLost".equals(action)){
			onConnectionLost(callbackContext);
			return true;
		}else if("onMessage".equals(action)){
			onMessage(callbackContext);
			return true;
		}else if("subscribe".equals(action)){
			subscribe(args);
			return true;
		}else if("publish".equals(action)){
			publish(args);
			return true;
		}else if("end".equals(action)){
			end();
			return true;
		}
		return false;
	}

	@Override
	public void onDestroy() {
		client.unregisterResources();
	}
}