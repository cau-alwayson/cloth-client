package cau.alwayscon.cloth_client;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class UploadImageActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView uploadedImage;
    ImageButton bUploadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);

        uploadedImage =(ImageView) findViewById(R.id.uploadedImage);

        bUploadImage = (ImageButton) findViewById(R.id.bUploadImage);

        uploadedImage.setOnClickListener(this);
        bUploadImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
