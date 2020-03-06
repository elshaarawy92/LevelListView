package com.les.levellistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdpter extends BaseAdapter {
    private List<ExampleBean> list = new ArrayList<>();
    private Context context;

    private List<String> idList = new ArrayList<>();
//    private List<Integer> choosePositionList = new ArrayList<>();
//    private List<Integer> unChoosePositionList = new ArrayList<>();
//    private List<String> pullPosition = new ArrayList<>();
//    private List<String> unPullPosition = new ArrayList<>();
//    private boolean isPull = true;

    private PullBean pullBean = new PullBean();

    private CheckBean checkBean = new CheckBean();

    private boolean firstLoad = true;


    public ListViewAdpter(Context context, List<ExampleBean> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.rlFirstLevel = convertView.findViewById(R.id.rl_first_level);
            if (firstLoad){
                viewHolder.rlFirstLevel.setTag(false);
            }
            viewHolder.rbFlChoose = convertView.findViewById(R.id.rb_fl_choose);
            viewHolder.btnPull = convertView.findViewById(R.id.btn_pull);
            viewHolder.rlSecondLevel = convertView.findViewById(R.id.rl_second_level);
            viewHolder.rbSlChoose = convertView.findViewById(R.id.rb_sl_choose);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (list.get(position).tag.equals(checkBean.tag)){
            viewHolder.rbSlChoose.setChecked(checkBean.isCheck);
        }

//        for (int i = 0; i < choosePositionList.size(); i ++){
//            if (position == choosePositionList.get(i)){
//                viewHolder.rbSlChoose.setChecked(true);
//            }
//        }

//        for (int i = 0; i < unChoosePositionList.size(); i ++){
//            if (position == unChoosePositionList.get(i)){
//                viewHolder.rbSlChoose.setChecked(false);
//            }
//        }
//
//        for (int i = 0; i < unPullPosition.size(); i ++){
//            if (list.get(position).tag.equals(unPullPosition.get(i))){
//                viewHolder.rlSecondLevel.setVisibility(View.GONE);
//            }
//        }
//
//        for (int i = 0; i < pullPosition.size(); i ++){
//            if (list.get(position).tag.equals(pullPosition.get(i))){
//                viewHolder.rlSecondLevel.setVisibility(View.VISIBLE);
//            }
//        }

        switch (list.get(position).level){
            case 1:
                viewHolder.rlFirstLevel.setVisibility(View.VISIBLE);
                viewHolder.rlSecondLevel.setVisibility(View.GONE);
                viewHolder.rbFlChoose.setText(list.get(position).name);
                break;
            case 2:
                if (list.get(position).tag.equals(pullBean.tag)){
                    if (pullBean.isPull){
                        viewHolder.rlSecondLevel.setVisibility(View.VISIBLE);
                        viewHolder.rbSlChoose.setText(list.get(position).name);
                    }else {
                        viewHolder.rlSecondLevel.setVisibility(View.GONE);
                    }
                }
                viewHolder.rlFirstLevel.setVisibility(View.GONE);
                break;
        }

        viewHolder.rbFlChoose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    String tag = list.get(position).tag;
                    checkBean.tag = tag;
                    checkBean.isCheck = true;
                    notifyDataSetChanged();
                }else {
                    String tag = list.get(position).tag;
                    checkBean.tag = tag;
                    checkBean.isCheck = false;
                    notifyDataSetChanged();
                }
            }
        });

        viewHolder.rbSlChoose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                }else {

                }
            }
        });

        viewHolder.btnPull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstLoad = false;
                pullBean.tag = list.get(position).tag;
                pullBean.isPull = !(Boolean)viewHolder.rlFirstLevel.getTag();
                viewHolder.rlFirstLevel.setTag(pullBean.isPull);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    class ViewHolder{
        RelativeLayout rlFirstLevel;
        CheckBox rbFlChoose;
        Button btnPull;

        RelativeLayout rlSecondLevel;
        CheckBox rbSlChoose;
    }
}

class PullBean{
    String tag;
    boolean isPull;
}

class CheckBean{
    String tag;
    boolean isCheck;
}
