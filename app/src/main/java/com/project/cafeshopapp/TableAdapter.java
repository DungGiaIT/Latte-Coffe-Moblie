package com.project.cafeshopapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class TableAdapter extends BaseAdapter {
    private Context context;
    private List<Table> tableList;

    public TableAdapter(Context context, List<Table> tableList) {
        this.context = context;
        this.tableList = tableList;
    }

    @Override
    public int getCount() {
        return tableList.size();
    }

    @Override
    public Object getItem(int position) {
        return tableList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView icon;
        TextView number;
        TextView statusText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_table, parent, false);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.tableIcon);
            holder.number = convertView.findViewById(R.id.tableNumber);
            holder.statusText = convertView.findViewById(R.id.tableStatusText);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Table table = tableList.get(position);

        switch (table.getStatus()) {

            case "serving":
                holder.icon.setImageResource(R.drawable.ic_coffee_logo);
                holder.statusText.setText("Đang phục vụ");
                break;
            case "paid":
                holder.icon.setImageResource(R.drawable.ic_check_done);
                holder.statusText.setText("Đã thanh toán");
                break;
            case "waiting":
                holder.icon.setImageResource(R.drawable.ic_coffee_clock);
                holder.statusText.setText("Đang chờ");
                break;
            default:
                holder.icon.setImageResource(R.drawable.ic_table);
                holder.statusText.setText("Trống");
                break;
        }

        String formattedNumber = String.format("#Bàn %02d", table.getNumber());
        holder.number.setText(formattedNumber);

        return convertView;
    }
}

