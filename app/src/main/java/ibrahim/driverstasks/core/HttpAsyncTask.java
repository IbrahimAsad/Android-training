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

import ibrahim.driverstasks.LoginActivity;


public class HttpAsyncTask extends AsyncTask {

    @Override
    protected String doInBackground(Object[] params) {
//        return null;

        ServerCall.getDataFromSrver();
        return  null;

    }

}



