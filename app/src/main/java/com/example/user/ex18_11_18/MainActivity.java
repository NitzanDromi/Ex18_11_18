package com.example.user.ex18_11_18;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText edInput;
    TextView tv;
    String str;
    InputStream is;
    String FILENAME = "Filename.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.textView);
        edInput = (EditText)findViewById(R.id.editText);
    }

    public void showfile(View view) {

        try {
            is = openFileInput(FILENAME);
            InputStreamReader tmp=new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(tmp);
            StringBuffer buffer=new StringBuffer();
            while ((str=reader.readLine())!= null){
                buffer.append(str+"\n");
            }
            is.close();
            tv.setText(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void enterFiles(View view) {

        str = edInput.getText().toString();
        try {
            FileOutputStream fos=openFileOutput(FILENAME, Context.MODE_PRIVATE);
            OutputStreamWriter osw=new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(str);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
