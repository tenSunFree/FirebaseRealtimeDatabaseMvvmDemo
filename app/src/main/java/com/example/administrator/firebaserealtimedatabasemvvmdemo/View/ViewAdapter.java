package com.example.administrator.firebaserealtimedatabasemvvmdemo.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.firebaserealtimedatabasemvvmdemo.DependencyInjection.AppPackage.MyApplication;
import com.example.administrator.firebaserealtimedatabasemvvmdemo.R;

import java.util.ArrayList;

public class ViewAdapter extends BaseAdapter {

    private String[][] ElementsData ;   //資料
    private LayoutInflater inflater;    //加載layout
    private int indentionBase;          //item缩排
    private ArrayList<String> list = new ArrayList<String>();

    //優化Listview 避免重新加載
    //這邊宣告你會動到的Item元件
    static class ViewHolder{
        TextView numberTextView;
    }

    //初始化
    public ViewAdapter(ArrayList<String> list){
        this.list = list;
        indentionBase = 100;
    }

    //取得數量
    @Override
    public int getCount() {
        return list.size();
    }

    //取得Item
    @Override
    public Object getItem(int position) {
        return position;
    }

    //此範例沒有特別設計ID所以隨便回傳一個值
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //當ListView被拖拉時會不斷觸發getView，為了避免重複加載必須加上這個判斷
        if (convertView == null) {
            holder = new ViewHolder();
            inflater = LayoutInflater.from(MyApplication.getInstance());
            convertView = inflater.inflate(R.layout.listview_firebase, null);
            holder.numberTextView = (TextView) convertView.findViewById(R.id.numberTextView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.numberTextView.setText(list.get(position));
        return convertView;
    }
}
