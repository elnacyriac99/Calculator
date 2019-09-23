package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etFirst;
    EditText etSecond;
    Button btFirst;
    Button btSecond;
    TextView tvResult;
    Button btThird;
    Button btForth;
    Button btFifth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFirst = findViewById(R.id.et_first);
        etSecond = findViewById(R.id.et_second);
        btFirst = findViewById(R.id.bt_first);
        btSecond = findViewById(R.id.bt_second);
        tvResult = findViewById(R.id.tv_result);
        btThird=findViewById(R.id.bt_third);
        btForth=findViewById(R.id.bt_forth);
        btFifth=findViewById(R.id.bt_fifth);
        btFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    /*new AddTask().execute();
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSecond.getText().toString());
                    c=add(a,b);
                    tvResult.setText(String.valueOf(c));*/
                    new AddTask().execute();
                } catch (Exception e) {
                    showErrorToast();
                }
            }
        });
        btSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSecond.getText().toString());
                    int c = a - b;
                    tvResult.setText(String.valueOf(c));
                } catch (Exception e) {
                    showErrorToast();
                }
            }
        });
        btThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSecond.getText().toString());
                    int c = a * b;
                    tvResult.setText(String.valueOf(c));
                } catch (Exception e) {
                    showErrorToast();
                }
            }
        });
        btForth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSecond.getText().toString());
                    int c = a / b;
                    tvResult.setText(String.valueOf(c));
                } catch (Exception e) {
                    showErrorToast();
                }
            }
        });
        btFifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    etFirst.setText("");
                    etSecond.setText("");
                    //int a = Integer.parseInt(etFirst.getText().toString());
                    //int b = Integer.parseInt(etSecond.getText().toString());
                    //int c = a + b;
                    tvResult.setText("");
                }

        });
    }

    public void showErrorToast() {
        Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();

    }
    public int add(int a,int b){
        return a+b;
    }
    class AddTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            String epoch=String.valueOf(System.currentTimeMillis());
            return epoch;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            tvResult.setText((String)o);
        }
    }
}
