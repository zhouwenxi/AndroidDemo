package com.qishui.android.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.qishui.android.R;
import com.qishui.android.adapter.CommonAdapter;
import com.qishui.android.adapter.ViewHolder;
import com.qishui.android.base.BaseActivity;
import com.qishui.android.utils.L;

import java.util.ArrayList;

public class ListActivity extends BaseActivity {

    @Override
    public int setLayoutID() {
        return R.layout.activity_list;
    }

    @Override
    public void setEvent() {

        L.e("00000000");

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("" + i);
        }

        ListView lv = findViewById(R.id.lv);
        //lv.setAdapter(new MyAdapter(list));

        lv.setAdapter(new CommonAdapter<String>(this, list, R.layout.item_tv) {
            @Override
            public void convert(ViewHolder viewHolder, String item) {
                viewHolder.setText(R.id.item_tv, item);
            }
        });

    }

    /**
     * 适配
     */
    class MyAdapter extends BaseAdapter {

        ArrayList<String> list;

        public MyAdapter(ArrayList<String> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v;
            if (convertView == null) {
                v = View.inflate(getApplicationContext(), R.layout.item_tv, null);
            } else {
                v = convertView;
            }

            TextView tv = v.findViewById(R.id.item_tv);
            tv.setText(list.get(position));

            return v;
        }
    }
}
