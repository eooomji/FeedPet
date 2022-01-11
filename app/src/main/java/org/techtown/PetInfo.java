package org.techtown.mypetinformation_scoroll_ver;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class PetInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InitialIzeView();
    }

    Button feed_cal_btn;
    TextView feed_amount;

    public void InitialIzeView(){
        feed_cal_btn = (Button)findViewById(R.id.button);
        feed_amount = (TextView)findViewById(R.id.textView5);
    }

    public void onBtnCal(View view){
        double age = 4.0;
        double weight = 27.0;
        double result = 0.0;

        if(age <= 1){
            result = weight * 5;
        } else {
            result = weight * 2;
        }
        feed_amount.setText(String.format("%.2f", result)+"g");

    }
}
