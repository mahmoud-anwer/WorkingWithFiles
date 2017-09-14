package com.example.root.workingwithfiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText content;
    Button loadButton, saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = (EditText) findViewById(R.id.editTextContent);
        loadButton = (Button) findViewById(R.id.buttonLoad);
        saveButton = (Button) findViewById(R.id.buttonSave);
    }

    public void save(View view) {
        String str;
        byte arrByte[];
        try {
            FileOutputStream fileOUT = this.openFileOutput("content.txt", this.MODE_PRIVATE);
            str = content.getText().toString();
            arrByte = str.getBytes();
            fileOUT.write(arrByte);
            fileOUT.close();
            Toast.makeText(this, "Saved successfully", Toast.LENGTH_LONG).show();
            content.setText("");
        }catch (Exception ex){content.setText(ex.getMessage());}
    }

    public void load(View view) {
        try {
            String str = "";
            byte arrByte[];
            FileInputStream fileIN = this.openFileInput("content.txt");
            int ch = 0;
            while ((ch = fileIN.read()) != -1){
                str += String.valueOf((char)ch);
            }
            fileIN.close();
            content.setText(str);
            Toast.makeText(this, "Loaded successfully", Toast.LENGTH_LONG).show();
        }catch (Exception ex){content.setText(ex.getMessage());}
    }
}
