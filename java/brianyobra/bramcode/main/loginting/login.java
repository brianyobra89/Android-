package brianyobra.bramcode.main.loginting;

import android.app.ProgressDialog;
import android.content.Intent;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



import brianyobra.bramcode.main.MainActivity;
import brianyobra.bramcode.main.R;


public class login extends AppCompatActivity {


    EditText editPassword, editName;
    Button btnSignIn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editName=(EditText)findViewById(R.id.etLoginUsername);
        editPassword=(EditText)findViewById(R.id.etLoginPassword);

        btnSignIn=(Button)findViewById(R.id.btnLogin);




        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDashboard();
            }
            });


    }


    /**
     * Launch Dashboard Activity on Successful Sign Up
     */
    private void loadDashboard() {


        Intent i = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(i);
        finish();

    }






}
