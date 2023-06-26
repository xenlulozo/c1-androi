package com.example.cau_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Button btn = findViewById(R.id.button4);
         EditText height = findViewById(R.id.editTextPhone2);
         EditText width = findViewById(R.id.editTextPhone3);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                float a = Float.parseFloat(String.valueOf(height.getText()));
                if(a>=100){
                    a = a/100;
                }
                float b = Float.parseFloat(String.valueOf(width.getText()));
              float  resuilt = b/(a*a);
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedResuilt = decimalFormat.format(resuilt);
              String review ="";
              if(resuilt <18.5){
                  review= "Kết quả BMI của bạn: " +formattedResuilt + "\n\n Chỉ số BMI ở trên cho thấy bạn Gầy";
              }
              else if(resuilt >=23){
                  review ="Kết quả BMI của bạn: " +formattedResuilt + "\n\nChỉ số BMI ở trên cho thấy bạn Thừa cân";
              }
              else if(resuilt <23 && resuilt >= 12.5){
                  review= "Kết quả BMI của bạn: " +formattedResuilt + "\n\nChỉ số BMI ở trên cho thấy bạn Bình thường";
              }
              else{
                  review= "Lỗi trong tính toán kết quả";

              }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Nhận xét BMI của bạn")
                        .setMessage(review)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Handle OK button click
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Handle Cancel button click
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }
}