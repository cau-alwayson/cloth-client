package cau.alwayscon.cloth_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    public void onBackButton2Clicked(View v) {
        Toast.makeText(getApplicationContext(), "돌아가기 버튼을 눌렀어요.", Toast.LENGTH_LONG).show();
        finish();
    }
}
