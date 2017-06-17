package naman.com.bharatcustomers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Naman on 17-06-2017.
 */

class ShopGridAdapter extends RecyclerView.Adapter<ShopGridAdapter.ViewHolder>{

    ArrayList<Shop> shops;

    ShopGridAdapter(ArrayList<Shop> shops)
    {
        this.shops=shops;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShopGridAdapter.ViewHolder holder, int position) {
        holder.name1.setText(shops.get(position).shop_name);
        holder.address1.setText(shops.get(position).address);
        holder.contact1.setText("" + shops.get(position).contact);
        holder.price1.setText("₹" + shops.get(position).price);

    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name1,address1,contact1,price1;
        public ViewHolder(View itemView) {
            super(itemView);
            name1 = (TextView) itemView.findViewById(R.id.shopName1);
            address1 = (TextView) itemView.findViewById(R.id.address1);
            contact1 = (TextView) itemView.findViewById(R.id.contact1);
            price1 = (TextView) itemView.findViewById(R.id.price1);

        }
    }
}
