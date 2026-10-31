package com.example.practicalfive;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Municipality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality);

        TextView munTitle = findViewById(R.id.munTitle);
        ImageView munImage = findViewById(R.id.munImage);
        TextView munInfoText = findViewById(R.id.munInfoText);
        Button visitButton = findViewById(R.id.visitButton);

        String receivedRaw = getIntent().getStringExtra(MainActivity.EXTRA_MUNICIPALITY);
        String cityName = TextProcessor.processMunicipality(receivedRaw);

        if(cityName == null){
            finish();
            Toast.makeText(this,"Bad data, return main screen",Toast.LENGTH_SHORT).show();
            return;
        }

        String[] summaryArray = getResources().getStringArray(R.array.municipalities_array);
        int colorRes;
        int drawableRes;
        String targetUrl;
        int index;

        switch (cityName){
            case "Beijing":
                colorRes = R.color.municipality_beijing;
                drawableRes = R.drawable.beijing;
                targetUrl = "https://english.beijing.gov.cn/";
                index = 0;
                break;
            case "Shanghai":
                colorRes = R.color.municipality_shanghai;
                drawableRes = R.drawable.shanghai;
                targetUrl = "https://english.shanghai.gov.cn/";
                index =1;
                break;
            case "Chongqing":
                colorRes = R.color.municipality_chongqing;
                drawableRes = R.drawable.chongqing;
                targetUrl = "https://english.cq.gov.cn/";
                index =2;
                break;
            case "Tianjin":
                colorRes = R.color.municipality_tianjin;
                drawableRes = R.drawable.tianjin;
                targetUrl = "https://en.tj.gov.cn/";
                index =3;
                break;
            default:
                finish();
                return;
        }

        munTitle.setText(cityName);
        munTitle.setBackgroundColor(getResources().getColor(colorRes));
        munTitle.setTextColor(getResources().getColor(R.color.color_text_light));
        munInfoText.setTextColor(getResources().getColor(colorRes));
        munImage.setImageResource(drawableRes);
        munInfoText.setText(summaryArray[index]);
        visitButton.setBackgroundTintList(getResources().getColorStateList(colorRes));

        visitButton.setOnClickListener(v -> {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(targetUrl));
            if(webIntent.resolveActivity(getPackageManager()) != null){
                startActivity(webIntent);
            }else{
                Toast.makeText(Municipality.this,"No browser app available",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
