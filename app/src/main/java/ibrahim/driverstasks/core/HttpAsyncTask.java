package ibrahim.driverstasks.core;

import android.os.AsyncTask;

/**
 * Created by Ibrahim on 2/5/2015.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;


public class HttpAsyncTask extends AsyncTask {
    @Override
    protected String doInBackground(String... urls) {

        return GET(urls[0]);
    }
    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
        try {
            JSONObject json = new JSONObject(result);

            String str = "";

            JSONArray articles = json.getJSONArray("articleList");
            str += "articles length = "+json.getJSONArray("articleList").length();
            str += "\n--------\n";
            str += "names: "+articles.getJSONObject(0).names();
            str += "\n--------\n";
            str += "url: "+articles.getJSONObject(0).getString("url");

            etResponse.setText(str);
            //etResponse.setText(json.toString(1));

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}



