package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {

    EditText inputID = findViewById(R.id.inputID);
    EditText inputPW = findViewById(R.id.inputPW);
    TextView Failmsg = findViewById(R.id.Failmsg);

    Button LOGIN = findViewById(R.id.LoginBtn);
    Button SIGNUP = findViewById(R.id.SignUpBtnM);

    DatabaseHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    // onCreate() : 시작점 역할
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Failmsg.setVisibility(View.INVISIBLE);

        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] idResult = DBHelper.getIDResult();
                String idTxt = inputID.getText().toString();
                String[] pwResult = DBHelper.getIDResult();
                String pwTxt = inputPW.getText().toString();

                for(int i = 0; i < idResult.length; i++) {
                    if (idResult[i] == idTxt && pwResult[i] == pwTxt) {
                        Intent intent = new Intent(getApplicationContext(), UserInfo.class); // 화면 전환 -> petList로 (이거 이름 수정해야함)
                        startActivity(intent);
//                      break;
                    }
                    else {
                        Failmsg.setVisibility(v.VISIBLE);
                    }
                }
            }
        });

        SIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });
    }
}
