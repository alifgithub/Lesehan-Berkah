package com.example.ferryal.try_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class listview extends AppCompatActivity {

    int[] IMAGES = {R.mipmap.ayam,R.mipmap.nasgor,R.mipmap.lele, R.mipmap.naskun,R.mipmap.pecel,R.mipmap.rames,R.mipmap.soto,
            R.mipmap.coca,R.mipmap.juice,R.mipmap.esbuah,R.mipmap.kopi,R.mipmap.milo,R.mipmap.mineral,R.mipmap.teh};

    String[] NAMES = {"Nasi Ayam","NasI Goreng", "Nasi Lele","Nasi Kuning","Nasi Pecel","Nasi Rames","Nasi Soto",
            "Coca Cola","Aneka Juice","Es Buah", "Kopi","Milo","Air Mineral","Teh Manis"};

    String[] DESCRIPTIONS = {"Rp. 10.000","Rp. 10.000","Rp. 10.000","Rp. 10.000","Rp. 10.000","Rp. 10.000","Rp. 10.000","Rp. 10.000","Rp. 10.000",
            "Rp. 10.000","Rp. 10.000","Rp. 10.000","Rp. 10.000","Rp. 10.000","Rp. 10.000"};

    int harga = 0;
    boolean[] checkboxstate;
    private Button button;
    private TextView tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView=(ListView)findViewById(R.id.listview);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.mpilih);

        CustomAdapter customAdapter=new CustomAdapter();

        listView.setAdapter(customAdapter);

        button = (Button) findViewById(R.id.pesan);
        tot = (TextView) findViewById(R.id.tot);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tot.setText("" + harga);

            }
        });

    }

    private class ViewHolder {
        TextView mNama;
        TextView mDesc;
        ImageView mImgs;
        CheckBox mpilih;

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
                viewHolder.mpilih = (CheckBox) view.findViewById(R.id.mpilih);
                //checkboxstate = new boolean[i];


                view.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            viewHolder.mImgs.setImageResource(IMAGES[i]);
            viewHolder.mNama.setText(NAMES[i]);
            viewHolder.mDesc.setText(DESCRIPTIONS[i]);

            viewHolder.mpilih.setChecked(false);

            if (checkboxstate[i]) {
                viewHolder.mpilih.setChecked(true);
            } else {
                viewHolder.mpilih.setChecked(false);
            }

            viewHolder.mpilih.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (viewHolder.mpilih.isChecked())
                        checkboxstate[i] = true;
                    else
                        checkboxstate[i] = false;

                }
            });

            return view;
        }
    }

}
