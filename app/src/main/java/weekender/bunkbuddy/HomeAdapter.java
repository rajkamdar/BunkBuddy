package weekender.bunkbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Raj Kamdar on 21-01-2017.
 */

public class HomeAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<String> AL_subNames;
    ArrayList<Integer> AL_total,AL_attended;

    public HomeAdapter(Context context,  ArrayList<String> AL_subNames, ArrayList<Integer> AL_attended, ArrayList<Integer> AL_total) {
        this.context = context;
        this.AL_subNames = AL_subNames;
        this.AL_total = AL_total;
        this.AL_attended = AL_attended;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return AL_subNames.size();
    }

    @Override
    public Object getItem(int position) {
        return AL_subNames.get(position)+AL_total.get(position)+AL_attended.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        home_viewholder viewHolder;
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.custom_home,null);
            viewHolder=new home_viewholder((TextView)convertView.findViewById(R.id.home_subname_tv),(TextView)convertView.findViewById(R.id.home_percent_tv),(TextView)convertView.findViewById(R.id.home_total_tv),(TextView)convertView.findViewById(R.id.home_attended_tv));
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (home_viewholder) convertView.getTag();
        }

        viewHolder.getHome_subject_tc().setText(AL_subNames.get(position));
       viewHolder.getHome_attended_tv().setText(AL_attended.get(position).toString());
       viewHolder.getHome_total_tv().setText(AL_total.get(position).toString());
        if(AL_total.get(position)!=0)
            viewHolder.getHome_percent_tv().setText((AL_attended.get(position)*100)/AL_total.get(position)+"");
        else
            viewHolder.getHome_percent_tv().setText("0aay");
        return convertView;
    }
}
