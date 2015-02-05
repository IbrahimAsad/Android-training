package ibrahim.driverstasks;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends Activity  {

    private EditText user_id;
    private EditText user_code;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user_code= (EditText) findViewById(R.id.user_id);
        user_code=(EditText)findViewById(R.id.user_code);
        login=(Button)findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                doServerCall();
            }
        });
    }


    private void doServerCall(){
         String uID=user_id.getText().toString();
         String uCode=user_code.getText().toString();
    }
}



