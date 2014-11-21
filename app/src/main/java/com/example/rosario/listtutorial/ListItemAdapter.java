package com.example.rosario.listtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Rosario on 15/11/2014.
 */
public class ListItemAdapter extends BaseAdapter {

    private Context mContext = null;
    private ArrayList<ListItem> mArrayList = null;
    private LayoutInflater mLayoutInflater = null;

    public ListItemAdapter ( Context context, ArrayList<ListItem> arrayList ){
        this.mContext = context;
        this.mArrayList = arrayList;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public int  getCount () {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class Holder{
        ImageView imageUser;
        TextView txtHeader;
        TextView txtSubHeader;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder ;
        View view = convertView;
        //Checar si la vista es nula, si es asi crear una nueva
        if (view == null){
            holder = new Holder();
            view  = this.mLayoutInflater.inflate(R.layout.list_item,null);
            holder.imageUser = (ImageView) view.findViewById(R.id.image_user);
            holder.txtHeader = (TextView) view.findViewById(R.id.text_header);
            holder.txtHeader = (TextView) view.findViewById(R.id.txt_subheader);
            view.setTag(holder);
        }else{
            holder =(Holder)view.getTag();
        }
        holder.imageUser.setImageDrawable(this.mArrayList.get(position).getImageUser());
        holder.txtHeader.setText(this.mArrayList.get(position).getHeader());
        holder.txtSubHeader.setText(this.mArrayList.get(position).getSubHeader());

        return view;
    }


}
