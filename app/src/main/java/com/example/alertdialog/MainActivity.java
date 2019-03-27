package com.example.alertdialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context=MainActivity.this;
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        View v = View.inflate(MainActivity.this, R.layout.my_dialog, null);
        Button button=findViewById(R.id.clickme);
        final EditText tvUsername=(EditText)v.findViewById(R.id.tv_username);
        final EditText tvPassword=(EditText)v.findViewById(R.id.tv_password);

        builder.setView(v);
        builder.setCancelable(false);
        final AlertDialog alertDialog=builder.create();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
        v.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                alertDialog.dismiss();
            }
        });
        v.findViewById(R.id.btn_sign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = tvUsername.getText().toString().trim();
                String psd = tvPassword.getText().toString().trim();
                if (uname.equals("lxy") && psd.equals("123456")) {
                    Toast.makeText(MainActivity.this, "登录成功", 0).show();
                    alertDialog.dismiss();// 对话框消失
                }
                else {
                    Toast.makeText(MainActivity.this, "登录失败", 0).show();
                    alertDialog.dismiss();// 对话框消失
                }
            }
        });
    }
}
