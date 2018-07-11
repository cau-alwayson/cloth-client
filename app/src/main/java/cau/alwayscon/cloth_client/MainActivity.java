package cau.alwayscon.cloth_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LOGIN(View v){
        Intent intent = new Intent(getApplicationContext(),UploadImageActivity.class);
        startActivity(intent);
    }
}
