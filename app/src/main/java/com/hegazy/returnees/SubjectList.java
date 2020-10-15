package com.hegazy.returnees;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubjectList extends AppCompatActivity {

    ListView listView ;
    ArrayList<Data> arraylist = new ArrayList<>();
    ListAdapter adapter;

    @BindView(R.id.adView)
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);
        ButterKnife.bind(this);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        listView=(ListView)findViewById(R.id.list_viewid) ;

        String[] AndRody_Subject = {
                getString(R.string.story4),
                getString(R.string.story5),
                getString(R.string.story6),
                getString(R.string.story7),
                };




        //TODO put integer [] of images of each chapter
        Integer [] chapter4 = {R.drawable.d4,R.drawable.d4_2,R.drawable.d4_3,R.drawable.d4_4};
        Integer [] chapter5 = {R.drawable.e5,R.drawable.e5_2,R.drawable.e5_3,R.drawable.e5_4,R.drawable.e5_5,R.drawable.e5_7};
        Integer [] chapter6 = {R.drawable.f6,R.drawable.f6_2,R.drawable.f6_3,R.drawable.f6_4,R.drawable.f6_5,R.drawable.f6_6};
        Integer [] chapter7 = {R.drawable.g7,R.drawable.g7_2,R.drawable.g7_3,R.drawable.g7_4};




        //TODO add these array to the array below

        Integer[] [] AndRody_image = {chapter4,chapter5,chapter6,chapter7};



        for (int i = 0; i <AndRody_Subject.length; i++) {
            Data abboudi = new Data(AndRody_Subject[i], AndRody_image[i]);
            arraylist.add(abboudi);
        }
        adapter = new ListAdapter(this, arraylist);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(SubjectList.this,SnigleItem.class);

                //TODO send all object to singleitem activity
                i.putExtra("object",arraylist.get(position));

                startActivity(i);
            }
        });

    }

}
