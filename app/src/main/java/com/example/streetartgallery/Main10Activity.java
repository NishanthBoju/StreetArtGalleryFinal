package com.example.streetartgallery;

import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main10Activity extends AppCompatActivity {

    TextView out1, out2,out3,out4,out5,out6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        out1 =(TextView) findViewById(R.id.textView101);
        out2 =(TextView) findViewById(R.id.textView103);
        out3 =(TextView) findViewById(R.id.textView104);
        out4 =(TextView) findViewById(R.id.textView105);
        out5 =(TextView) findViewById(R.id.textView106);
        out6 =(TextView) findViewById(R.id.textView107);

        new MyTask().execute();
    }

    private class MyTask extends AsyncTask<Void, Void, Void> {
        String o1,o2,o3,o4,o5,o6;
        @Override
        protected Void doInBackground(Void... params){

            URL url = null;

            Intent myNewIntent=getIntent();

            int InfoReceivedId=myNewIntent.getIntExtra("ID",99);


            try {

                url = new URL("http://192.168.2.20:8080/FinalProjectTeam7/cegepgim/art/findArtDetails&"+InfoReceivedId);

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
                String str1=obj.getString("Status");
                if(str1.equals("OK")) {
                    o1 = obj.getString("Status");
                    o2 = obj.getString("Timestamp");
                    o3 = "" + obj.getInt("art_id");
                    o4 = obj.getString("DATECREATED");
                    o5 = obj.getString("art_name");
                    o6 = obj.getString("description");
                }else {
                    o1 = obj.getString("Status");
                    o2 = obj.getString("Timestamp");
                    o3 = obj.getString("message");
                    o4="";
                    o5="";
                    o6="";
                }
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
            out3.setText("Art ID: "+o3);
            out4.setText("DATE CREATED: "+o4);
            out5.setText("Art Name:"+o5);
            out6.setText("Art Description:"+o6);
            super.onPostExecute(result);
        }
    }
}