package ibrahim.driverstasks;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.internal.ca;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import ibrahim.driverstasks.core.APIConstant;
import ibrahim.driverstasks.core.DriverData;
import ibrahim.driverstasks.core.ServerCall;


public class LoginActivity extends Activity  {

    private EditText user_id;
    private EditText user_code;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("STARTTTTTTT", "VVVV");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        user_id= (EditText) findViewById(R.id.user_id);
        user_code=(EditText)findViewById(R.id.user_code);
        login=(Button)findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.v("CLICCCKED","VVVV");
                doServerCall();

            }
        });

    }


    private void doServerCall()  {
         String uID=user_id.getText().toString();
         String uCode=user_code.getText().toString();
//        String path= APIConstant.path;
//            APIConstant.c
        APIConstant.setServerURL(APIConstant.loginPath);
        APIConstant.setParameters(uID+"?"+"code="+uCode);
        Log.v("PATH ",APIConstant.cuurentPath);
           ServerCall.makeCall();
           Log.v("after servercall.makecall",APIConstant.response.toString());
        try {
            if ("OK".equalsIgnoreCase(APIConstant.response.get("status").toString() )) {
                String driver= APIConstant.response.getJSONObject("data").getString("driver_name");
                DriverData.driver_id=APIConstant.response.getJSONObject("data").getString("driver_id");
                DriverData.driver_name=APIConstant.response.getJSONObject("data").getString("driver_name");
                Toast.makeText(this,"Welcome Back "+driver, Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Wrong ID or code .. try again..", Toast.LENGTH_LONG).show();
            }
        } catch (JSONException e){
          Toast.makeText(this,"unable to connect to server .. try ", Toast.LENGTH_LONG).show();
//            Toast.mak

        }
        //ViewTasksActivity
        Intent intent = new Intent(this, ViewTasksActivity.class);
        startActivity(intent);

    }
}



