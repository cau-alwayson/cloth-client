package cau.alwayscon.cloth_client;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainscreenActivity extends AppCompatActivity {

    Button button9;
    ImageView iv;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("113","URI=>"+data.getData());


        iv.setImageURI(data.getData());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        button9 = (Button)findViewById(R.id.button9);
        iv = (ImageView)findViewById(R.id.iv);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);

            }
        });


    }



    public void onBackButtonClicked(View v) {
        Toast.makeText(getApplicationContext(), "돌아가기 버튼을 눌렀어요.", Toast.LENGTH_LONG).show();
        finish();
    }


}
