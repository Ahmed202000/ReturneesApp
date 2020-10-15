package com.hegazy.returnees;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SnigleItem extends AppCompatActivity {

    public ImagesAdapter adapter;
    ArrayList<Integer> list = new ArrayList<>();
    ListView listView;
    @BindView(R.id.activity_snigle_item_tv_name)
    TextView activitySnigleItemTvName;
    @BindView(R.id.activity_snigle_item_btn_share)
    ImageView activitySnigleItemBtnShare;
    @BindView(R.id.activity_snigle_item_btn_rate)
    ImageView activitySnigleItemBtnRate;
    @BindView(R.id.adView)
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snigle_item);
        ButterKnife.bind(this);



        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);



        //TODO get the object from the intent
        Data data=(Data) getIntent().getSerializableExtra("object");
        listView=(ListView) findViewById(R.id.imageslv);
        Integer [] images = data.getImages();
        list.addAll(Arrays.asList(images));
        adapter=new ImagesAdapter(SnigleItem.this , list);
        listView.setAdapter(adapter);


        activitySnigleItemTvName.setText(data.getSubject1());



    }

    @OnClick({R.id.activity_snigle_item_btn_share, R.id.activity_snigle_item_btn_rate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_snigle_item_btn_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "تحميل تطبيق إلخ .. ");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id= ");
                sendIntent.setType("img/plain");
                startActivity(Intent.createChooser(sendIntent, "اختار التطبيق الذي مشاركة النص معه :"));

                break;
            case R.id.activity_snigle_item_btn_rate:

                final String appPackageName = getPackageName();
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                }
                break;

        }
    }
}
