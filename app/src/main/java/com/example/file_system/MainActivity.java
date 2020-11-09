package com.example.file_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed=(EditText)findViewById(R.id.et);
        tv=(TextView)findViewById(R.id.tv);
        tv.setVisibility(View.GONE);
    }

    public void wm(View view)
    {
        String msg=ed.getText().toString();
        String file_name="Hello_File";
        try{
            FileOutputStream fileOutputStream=openFileOutput(file_name,MODE_PRIVATE);
            fileOutputStream.write(msg.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"Message saved",Toast.LENGTH_LONG).show();
            ed.setText("");
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void rm(View view)
    {
        try{
            String message;
            FileInputStream fileInputStream=openFileInput("Hello_File");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();
            while((message=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(message+"\n");
            }
            tv.setText(stringBuffer.toString());
            tv.setVisibility(View.VISIBLE);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}