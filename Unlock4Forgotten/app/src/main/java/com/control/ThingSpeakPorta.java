package com.control;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Alexsander on 07/04/2016.
 */
public class ThingSpeakPorta extends AppCompatActivity {

    private String url = "https://api.thingspeak.com/update?api_key=KLKB4UELYFEYC8U6&field1=1";
    private String mResponse;

    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                mResponse = restTemplate.getForObject(url, String.class, "Android");
            }
            catch (Exception e){
                Log.e("RESPONSE HTTP ERROR:", e.getCause().toString());
                mResponse = "Error:" + e.getCause().toString();
            }

        }
    };

    public void startTarefa() {

        if (thread.getState() == Thread.State.NEW) {
            thread.start();
        }

        else{
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    try {
                        RestTemplate restTemplate = new RestTemplate();
                        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                        mResponse = restTemplate.getForObject(url, String.class, "Android");
                    }
                    catch (Exception e){
                        Log.e("RESPONSE HTTP ERROR:", e.getCause().toString());
                        mResponse = "Error:" + e.getCause().toString();
                    }

                }
            };

            thread1.start();
        }
        
    }


}
