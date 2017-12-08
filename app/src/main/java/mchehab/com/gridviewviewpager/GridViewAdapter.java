package mchehab.com.gridviewviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by muhammadchehab on 12/8/17.
 */

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private List<String> listImageURLs;

    public GridViewAdapter(Context context, List<String> listImageURLs){
        this.context = context;
        this.listImageURLs = listImageURLs;
    }

    @Override
    public int getCount() {
        return listImageURLs.size();
    }

    @Override
    public Object getItem(int position) {
        return listImageURLs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Picasso.with(context)
                .load(listImageURLs.get(position))
                .into(viewHolder.imageView);

        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
    }
}
