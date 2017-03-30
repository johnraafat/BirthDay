package com.example.john.birthday;
import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import static java.util.Calendar.*;
public class SecondActivity extends AppCompatActivity {
    EditText editText2;
    TextView textView4;
    Button button2;
    Button button4;
    ImageView imageView;
    EditText editText;
    TextView textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
          editText2=(EditText)findViewById(R.id.editText2);
          textView4=(TextView) findViewById(R.id.textView4);
          button2=(Button)findViewById(R.id.button2);
          button4=(Button)findViewById(R.id.button4);
          imageView=(ImageView)findViewById(R.id.imageView);
          editText=(EditText)findViewById(R.id.editText);
        textView5=(TextView)findViewById(R.id.textView5);
         Toast.makeText(getApplicationContext(), " Please Enter Your Birth Date ", Toast.LENGTH_LONG).show();
          button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String inputYear = editText2.getText().toString();
                    String inputMonth = editText.getText().toString();
                    Calendar calendar = getInstance();
                    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                    int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
                    int currentAgeYear = 0;
                    int currentAgeMonth = 0;
                    if(Integer.parseInt(inputMonth)<1 || Integer.parseInt(inputMonth)>12 || Integer.parseInt(inputYear) < 1900 || Integer.parseInt(inputYear) > currentYear){
                        textView4.setVisibility(View.VISIBLE);
                        textView4.setText(" Please Enter The Correct Date ");
                        imageView.setVisibility(View.INVISIBLE);
                        textView5.setText(null);

                    }else{
                    if (currentMonth == Integer.parseInt(inputMonth) ){
                        currentAgeYear= currentYear-Integer.parseInt(inputYear);
                        currentAgeMonth=0;
                    }if(currentMonth < Integer.parseInt(inputMonth)){
                        currentAgeYear=currentYear-Integer.parseInt(inputYear);
                        currentAgeMonth=currentMonth-Integer.parseInt(inputMonth);
                        currentAgeMonth+=12;
                        currentAgeYear--;


                    }if(currentMonth > Integer.parseInt(inputMonth)){
                        currentAgeYear=currentYear-Integer.parseInt(inputYear);

                        currentAgeMonth= currentMonth-Integer.parseInt(inputMonth);


                    }

                    textView4.setVisibility(View.VISIBLE);
                    textView4.setText(" You're " + currentAgeYear + " Years And "+ currentAgeMonth+" Months Old " );
                    imageView.setVisibility(View.VISIBLE);
                        textView5.setVisibility(View.VISIBLE);
                        textView5.setText("" + (12-currentAgeMonth) + " Months Left Until Your BirthDay :D");
                    //3shan a hide el keyboard b3d ma calculate
                        InputMethodManager imm2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm2.hideSoftInputFromWindow(editText.getWindowToken(), 0);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);


                }}
                catch (Exception e){
                textView4.setVisibility(View.VISIBLE);
                textView4.setText(" Please Enter Your Birth Date ");
                    textView5.setText(null);
                }
            }

        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setText(null);
                textView4.setPadding(0,0,0,0);
                editText.setText(null);
                imageView.setVisibility(View.INVISIBLE);
                textView5.setText(null);
                textView5.setPadding(0,0,0,0);
                editText2.setText(null);
            }

        });




    }

}
