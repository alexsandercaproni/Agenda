package com.control;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Alexsander on 10/05/2016.
 */
public class ThingSpeakSistema extends AppCompatActivity {

    private String url2 = "https://api.thingspeak.com/update?api_key=KLKB4UELYFEYC8U6&field2=1";
    private String mResponse2;

    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                mResponse2 = restTemplate.getForObject(url2, String.class, "Android");
            }
            catch (Exception e){
                Log.e("RESPONSE HTTP ERROR:", e.getCause().toString());
                mResponse2 = "Error:" + e.getCause().toString();
            }

        }
    };

    public void startTarefaSistema() {
        if (thread.getState() == Thread.State.NEW) {
            thread.start();
        }
    }
}
