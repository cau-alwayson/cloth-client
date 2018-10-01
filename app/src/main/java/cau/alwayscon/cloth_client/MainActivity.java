package cau.alwayscon.cloth_client;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bottomButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomButton = findViewById(R.id.button11);
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BottomNavActivity.class);
                startActivity(intent);
            }
        });
    }

    public void LOGIN(View v){
        Intent intent = new Intent(getApplicationContext(),UploadImageActivity.class);
        startActivity(intent);
    }

    public void onButton5Clicked(View v){
        Intent intent = new Intent(getApplicationContext(),MainscreenActivity.class);
        startActivity(intent);
    }

    public void onButton6Clicked(View v){
        Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
        startActivity(intent);
    }

    public void onButton7Clicked(View v){
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}
