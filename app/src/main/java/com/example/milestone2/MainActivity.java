package com.example.milestone2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public int[] getnum(View view){
        EditText num1=(EditText) findViewById(R.id.editText1);
        EditText num2=(EditText) findViewById(R.id.editText2);
        String str=num1.getText().toString();
        String str2=num2.getText().toString();
        int f1=Integer.parseInt(str);
        int f2=Integer.parseInt(str2);
        int toreturn[]={f1,f2};
        return toreturn;
    }
    public void plus(View view){
        try{
            int a=getnum(view)[0]+getnum(view)[1];
            goToActivity2(""+a);
        }catch(Exception e){
            goToActivity2("Error!!!");
        }

    }
    public void minus(View view){
        try{
            int a=getnum(view)[0]-getnum(view)[1];
            goToActivity2(""+a);
        }catch(Exception e){
            goToActivity2("Error!!!");
        }
    }
    public void mult(View view){
        try{
            int a=getnum(view)[0]*getnum(view)[1];
            goToActivity2(""+a);
        }catch(Exception e){
            goToActivity2("Error!!!");
        }
    }
    public void div(View view){
        try {
            String toreturn = "";
            int num[] = getnum(view);
            if (num[1] == 0) {
                goToActivity2("Divides by Zero!!!");
                return;
            } else if (num[0] % num[1] == 0) {
                toreturn = "" + (num[0] / num[1]);
            } else {
                toreturn = String.format("%.2f", ((double) num[0] / (double) num[1]));
            }
            goToActivity2(toreturn);
        }catch(Exception e){
            goToActivity2("Error!!!");
        }
    }
    public void  goToActivity2(String a){
        Intent intent=new Intent(this,MainActivity2.class);
        intent.putExtra("message",""+a);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}