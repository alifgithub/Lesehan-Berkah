package com.example.ferryal.try_list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class listview extends AppCompatActivity {

    int[] IMAGES = {R.mipmap.ayam,R.mipmap.nasgor,R.mipmap.lele, R.mipmap.naskun,R.mipmap.pecel,R.mipmap.rames,R.mipmap.soto,
            R.mipmap.coca,R.mipmap.juice,R.mipmap.esbuah,R.mipmap.kopi,R.mipmap.milo,R.mipmap.mineral,R.mipmap.teh};

    String[] NAMES = {"Nasi Ayam","NasI Goreng", "Nasi Lele","Nasi Kuning","Nasi Pecel","Nasi Rames","Nasi Soto",
            "Coca Cola","Aneka Juice","Es Buah", "Kopi","Milo","Air Mineral","Teh Manis"};

    String[] DESCRIPTIONS = {"Rp. 13.000","Rp. 12.000","Rp. 15.000","Rp. 11.000","Rp. 10.000","Rp. 12.000","Rp. 13.000","Rp. 4.000","Rp. 10.000",
            "Rp. 16.000","Rp. 7.000","Rp. 4.000","Rp. 3.000","Rp. 4.000"};

    Button review;
    Button antar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        review = (Button) findViewById(R.id.review);

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(listview.this, Review.class);
                startActivity(i);
            }
        });

        antar = (Button) findViewById(R.id.antar);

        antar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(listview.this, Antar.class);
                startActivity(i);
            }
        });

        ListView listView=(ListView)findViewById(R.id.listview);

        CustomAdapter customAdapter=new CustomAdapter();

        listView.setAdapter(customAdapter);

    }

    private class ViewHolder {
        TextView mNama;
        TextView mDesc;
        ImageView mImgs;
        //CheckBox mpilih;

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;

            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.customlayout, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.mImgs = (ImageView)view.findViewById(R.id.imageView);
                viewHolder.mNama = (TextView)view.findViewById(R.id.textView_name);
                viewHolder.mDesc = (TextView)view.findViewById(R.id.textView_desciption);


                view.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            viewHolder.mImgs.setImageResource(IMAGES[i]);
            viewHolder.mNama.setText(NAMES[i]);
            viewHolder.mDesc.setText(DESCRIPTIONS[i]);

            //viewHolder.mpilih.setChecked(false);

            return view;
        }
    }


}
