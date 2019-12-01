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

public class Main9Activity extends AppCompatActivity {

    TextView out1, out2,out3,out4,out5,out6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        out1 =(TextView) findViewById(R.id.textView91);
        out2 =(TextView) findViewById(R.id.textView92);
        out3 =(TextView) findViewById(R.id.textView93);
        out4 =(TextView) findViewById(R.id.textView95);
        out5 =(TextView) findViewById(R.id.textView96);
        out6 =(TextView) findViewById(R.id.textView97);

        new MyTask().execute();
    }

    private class MyTask extends AsyncTask<Void, Void, Void> {
        String o1,o2,o3,o4,o5,o6;
        @Override
        protected Void doInBackground(Void... params){

            URL url = null;

            Intent myNewIntent=getIntent();

            int InfoReceivedId=myNewIntent.getIntExtra("ID",99);

            String nameRecieved1=myNewIntent.getStringExtra("pass");
            String nameRecieved2=myNewIntent.getStringExtra("LNAME");
            String nameRecieved3=myNewIntent.getStringExtra("FNAME");


            try {

                url = new URL("http://192.168.2.20:8080/FinalProjectTeam7/cegepgim/user/finduser&"+InfoReceivedId);

                HttpURLConnection client = null;

                client = (HttpURLConnection) url.openConnection();

                client.setRequestMethod("GET");

                int responseCode = client.getResponseCode();

                System.out.println("\n Sending 'GET' request to URL : " + url);

                System.out.println("Response Code : " + responseCode);

                InputStreamReader myInput = new InputStreamReader(client.getInputStream());

                BufferedReader in = new BufferedReader(myInput);
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                //print result
                System.out.println(response.toString());

                JSONObject obj = new JSONObject(response.toString());
                o1 = obj.getString("Status");
                o2 = obj.getString("Timestamp");
                if(o1.equals("OK")) {
                    o3 = obj.getString("USER_ID");
                    o4 = obj.getString("PASSWORD");
                    o5 = obj.getString("USER_LASTNAME");
                    o6 = obj.getString("USER_FIRSTNAME");
                }else{
                    o3 = obj.getString("message");
                    o4="";
                    o5 = "";
                    o6 = "";
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
            out3.setText("USER_ID: "+o3);
            out4.setText("PASSWORD: "+o4);
            out5.setText("USER_LASTNAME: "+o5);
            out6.setText("USER_FIRSTNAME: "+o6);

            // out4.setText("artist_FirstName:"+o4);
            super.onPostExecute(result);
        }
    }
}