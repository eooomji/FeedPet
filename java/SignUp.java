package com.example.hello;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    EditText nameText;
    EditText userIDText;
    EditText userPWTEXT1;
    EditText userPWTEXT2;

    TextView checkID;
    TextView checkPW;

    Button CheckIdBtn;
    Button SignUpBtnM;

    DatabaseHelper DBHelper;

    int possibleID = 0, truePW = 0;

    @SuppressWarnings("unchecked")
    public final <E extends View> E findView (int id) {
        return (E) findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up); // 디자인

        nameText = findView(R.id.nameText);
        userIDText = findView(R.id.userIDText);
        userPWTEXT1 = findView(R.id.userPWTEXT1);
        userPWTEXT2 = findView(R.id.userPWTEXT2);

        checkID = findView(R.id.checkID);
        checkPW = findView(R.id.checkPW);

        CheckIdBtn = findView(R.id.CheckIdBtn);
        SignUpBtnM = findView(R.id.SignUpBtnM);

        final TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                String pwTxt1 = userPWTEXT1.getText().toString();
                String pwTxt2 = userPWTEXT2.getText().toString();

                if(pwTxt1.equals(pwTxt2)) {
                    checkPW.setText("비밀번호가 일치합니다.");
                    truePW = 1;
                }
                else {
                    checkPW.setText("비밀번호가 일치하지 않습니다.");
                }
            }
        };

        // clickEvent
        CheckIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] idResult = DBHelper.getIDResult();
                String idTxt = userIDText.getText().toString();

                if (idResult.length == 0) {
                    checkID.setText("사용 가능한 아이디입니다.");
                    possibleID = 1;
                }

                else {
                    for(int i = 0; i < idResult.length; i++) {
                        if (idResult[i] == idTxt) {
                            checkID.setText("중복된 아이디입니다. 다시 입력해주세요.");
                        } else {
                            checkID.setText("사용 가능한 아이디입니다.");
                            possibleID = 1;
                        }
                    }
                }
            }
        });

        SignUpBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (possibleID == 1 && truePW == 1) {
                    userPWTEXT1 = findView(R.id.userPWTEXT1);
                    nameText = findView(R.id.nameText);

                    String pwTxt = userPWTEXT1.getText().toString();
                    String nameTxt = nameText.getText().toString();
                    String idTxt = userIDText.getText().toString();

                    DBHelper.insert(idTxt, pwTxt, nameTxt);
                }
            }
        });
    }
}

//    @Override
//    public void onClick(View v) {
//        userIDText = findView(R.id.userIDText);
//        String idTxt = userIDText.getText().toString();
//
//        switch(v.getId()) {
//            case R.id.CheckIdBtn:   // CheckID 버튼 누른 경우
//                checkID = findView(R.id.checkID);
//                String[] idResult = DBHelper.getIDResult();
//
//                if (idResult.length == 0) {
//                    checkID.setText("사용 가능한 아이디입니다.");
//                    possibleID = 1;
//                }
//
//                for(int i = 0; i < idResult.length; i++) {
//                    if(idResult[i] == idTxt) {
//                        checkID.setText("중복된 아이디입니다. 다시 입력해주세요.");
//                    }
//                    else {
//                        checkID.setText("사용 가능한 아이디입니다.");
//                        possibleID = 1;
//                    }
//                }
//                break;
//            case R.id.SignUpBtnM:
//                if(possibleID == 1 && truePW == 1) {
//                    userPWTEXT1 = findView(R.id.userPWTEXT1);
//                    nameText = findView(R.id.nameText);
//
//                    String pwTxt = userPWTEXT1.getText().toString();
//                    String nameTxt = nameText.getText().toString();
//
//                    DBHelper.insert(idTxt, pwTxt, nameTxt);
//                }
//                break;
//        }
//    }
