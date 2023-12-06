package com.example.javamobil_vize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class ConvertorView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor_view);

        //button Tanımlama

        //Decimal
        EditText decimalInput = findViewById(R.id.decimalInput);
        Spinner decimalSpinner = findViewById(R.id.decimalSpinner);
        TextView decimalResult = findViewById(R.id.decimalResult);
        //Byte

        EditText byteInput = findViewById(R.id.byteInput);
        Spinner byteSpinner = findViewById(R.id.byteSpinner);
        TextView byteResult = findViewById(R.id.byteResult);

        //Celcius
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton fahrenaytBtn = findViewById(R.id.fahrenaytRadio);
        RadioButton KelvinBtn = findViewById(R.id.KelvinRadio);
        EditText celciusInput = findViewById(R.id.celciusInput);
        TextView celciusResult = findViewById(R.id.CelciusResult);


        // Spinner List
        String[] decimalArray ={"Seçim Yapınız","İkilik","Sekizlik","Onaltılık"};
        String[] byteArray = {"Seçim Yapınız","KiloByte","MegaByte","KibiByte"};

        //Array Adaptors

        ArrayAdapter<String> decimalAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,decimalArray);
        ArrayAdapter<String> byteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,byteArray);
        decimalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        byteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            decimalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    try {
                       String result = "";
                       String selectedValue = (String)  parent.getItemAtPosition(position);
                       String value = decimalInput.getText().toString();
                       int decimalValue  = Integer.parseInt(value);
                       switch (selectedValue){
                           case "Seçim Yapınız":
                               result = "";
                           case "İkilik":
                               result = Integer.toBinaryString(decimalValue);
                           case "Sekizlik":
                               result = Integer.toOctalString(decimalValue);
                           case "Onaltılık":
                               result = Integer.toHexString(decimalValue);
                       }
                       decimalResult.setText("Sonuç : "+result );


                    }catch(NumberFormatException error){
                        //Hata Oluşma Durumu
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    //....
                }
            });
            byteSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Double result = 0.0;
                    String selectedValue = (String)  parent.getItemAtPosition(position);
                    String value = byteInput.getText().toString();
                    Double byteValue  = Double.parseDouble(value);

                    try {
                        switch ( selectedValue){
                            case "Seçim Yapınız":
                                result = 0.0;
                            case "KiloByte":
                                result = byteValue * 1000;
                            case "MegaByte":
                                result = byteValue * 1024 * 1024;
                            case "KibiByte":
                                result = byteValue * 1024;
                        }
                        byteResult.setText("sonuc: "+result);

                    }catch (NumberFormatException error){

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int radioGroup) {
                    RadioButton selectedRadio = findViewById(radioGroup);
                    String selectedValue = selectedRadio.getText().toString();
                    String inputValue = celciusInput.getText().toString();
                    Double input = Double.parseDouble(inputValue);
                    Double result = 0.0;
                    try {
                        switch (selectedValue){
                            case "Fahrenayt":
                                result = (input * 9/5) + 32;
                            case "Kelvin":
                                result = input + 273.15;
                        }
                        celciusResult.setText("sonuc : "+result);

                    }catch (NumberFormatException error){

                    }

                }
            });

    }
}