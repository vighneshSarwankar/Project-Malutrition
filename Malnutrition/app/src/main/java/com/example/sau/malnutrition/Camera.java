package com.example.sau.malnutrition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;


public class Camera extends Activity {

    Button button;
    ImageView image_view;
    static int i = 0;
    static final int CAM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        button = (Button) findViewById(R.id.btn_start_camera);
        image_view = (ImageView) findViewById(R.id.image_view1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Intent cam_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cam_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(getFile(i)));
                Button btn_save = (Button) findViewById(R.id.btn_cam_save);
                btn_save.setEnabled(true);
                startActivityForResult(cam_intent, CAM_REQUEST);

            }
        });
    }

    private File getFile(int i) {
        File folder = new File("sdcard/mal_data");
        if (!folder.exists())
            folder.mkdir();

        File image = new File(folder, "img_" + i + ".jpg");
        return image;
    }


    public void onSave(View view) {
            }

    public void onCalibrate(View view) {
        Intent intent = new Intent(Camera.this, Calibration.class);
        startActivity(intent);
    }


    protected void  onCall(View view) {
        String path = "sdcard/mal_data/img_" + i + ".jpg";
        File imgFile = new File(path);

        if (imgFile.exists()) {

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ImageView myImage = (ImageView) findViewById(R.id.image_view1);
            myImage.setImageBitmap(myBitmap);
            image_view.setRotation(90);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "sdcard/mal_data/img_" + i + ".jpg";
        File imgFile = new File(path);
        if (imgFile.exists()) {

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ImageView myImage = (ImageView) findViewById(R.id.image_view1);
            myImage.setImageBitmap(myBitmap);
            image_view.setRotation(90);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "File not found";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}