package com.cookandroid.project7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvName, tvEmail;
    Button button1;
    EditText dlgEditName, dlgEditEmail;
    TextView toastText;
    View diglogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diglogView = (View)View.inflate(MainActivity.this,R.layout.dialog1,null);
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);

                dig.setTitle("사용자 정보 입력");
                dig.setIcon(R.drawable.btn_star_big_on);
                dig.setView(diglogView );
                dig.setPositiveButton("확인", null);
                dig.setNegativeButton("취소", null);
                dig.show();

                dig.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dlgEditEmail = (EditText)diglogView.findViewById(R.id.dlgEdt2);
                                dlgEditName = (EditText) diglogView.findViewById(R.id.dlgEdt1);

                                tvName.setText(dlgEditName.getText().toString());
                                tvEmail.setText(dlgEditEmail.getText().toString());
                            }
                        });

                dig.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast toast = new Toast(MainActivity.this);
                                toastView=(View)View.inflate(MainActivity.this,
                                        R.layout.toast1,null);
                                toastText = (TextView) toastView.findViewById(R.id.toastText1);
                                toastText.setText("취소했습니다");
                                toast.setView(toastView);
                                toast.show();
                            }
                        });
            }



        });
    }
}