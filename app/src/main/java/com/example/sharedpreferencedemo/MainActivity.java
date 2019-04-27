package com.example.sharedpreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user,pass;
    Button save,show;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.userid);
        pass = findViewById(R.id.passid);
        save = findViewById(R.id.saveid);
        show = findViewById(R.id.showid);
        result = findViewById(R.id.resultid);



        save.setOnClickListener(this);
        show.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.saveid)
        {



            String username = user.getText().toString() ;
            String password = pass.getText().toString() ;

            if(username.equals("") && username.equals(""))
            {
                Toast.makeText(getApplicationContext(),"Please Enter data",Toast.LENGTH_LONG).show();
            }
            else
            {
                //write data in shared preference
                SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username",username);
                editor.putString("password",password);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Successfully Store",Toast.LENGTH_LONG).show();
                result.setText("");


            }

        }
        if(v.getId() == R.id.showid)
        {
            //read the data

            SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);

            if(sharedPreferences.contains("username") && sharedPreferences.contains("password") )
            {
                String username =  sharedPreferences.getString("username","Data Not Found");
                String password =  sharedPreferences.getString("password","Data Not Found");

                result.setText("Username :"+username+"\n"+"Password :"+password);

            }

        }




    }
}
