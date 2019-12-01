package com.example.streetartgallery;

import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main5Activity extends AppCompatActivity {

    TextView out1, out2,out3,out4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        out1 =(TextView) findViewById(R.id.textView9);
          out2 =(TextView) findViewById(R.id.textView10);
        out3 =(TextView) findViewById(R.id.textView52);
        //out4 =(TextView) findViewById(R.id.textView4);

        new MyTask().execute();
    }

    private class MyTask extends AsyncTask<Void, Void, Void> {
        String o1,o2,o3,o4;
        @Override
        protected Void doInBackground(Void... params){

            URL url = null;

            Intent myNewIntent=getIntent();

            int InfoReceivedId=myNewIntent.getIntExtra("ID",99);


            try {

                url = new URL("http://192.168.2.20:8080/FinalProjectTeam7/cegepgim/types/typeofarts");

                HttpURLConnection client = null;

                client = (HttpURLConnection) url.openConnection();

                client.setRequestMethod("GET");

                int responseCode = client.getResponseCode();

                System.out.println("\n Sending 'GET' request to URL : " + url);

                System.out.println("Response Code : " + responseCode);

                InputStreamReader myInput= new InputStreamReader(client.getInputStream());

                BufferedReader in = new BufferedReader(myInput);
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                //print result
                System.out.println(response.toString());

                JSONObject obj =new JSONObject(response.toString());
                JSONArray mainarr = obj.getJSONArray("Type Of Arts");
                String s1 = "", s2 = "", s3 = "";
                o1 = obj.getString("Status");

                o2 = obj.getString("Timestamp");
                for (int i = 0; i < mainarr.length(); i++) {
                    JSONObject main2 = mainarr.getJSONObject(i);
                    s1 = main2.getString("art_type_id");
                    s2 = main2.getString("typeofart");
                    s3 += "\n" + "Art Type Id: " + s1 + "\n" + "Type of Art: " + s2 + "\n";
                }

                o3 = s3;
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void result){
            out1.setText("Status: "+o1);
             out2.setText("Timestamp: "+o2);
            out3.setText(o3);
            // out4.setText("artist_FirstName:"+o4);
            super.onPostExecute(result);
        }
    }
}