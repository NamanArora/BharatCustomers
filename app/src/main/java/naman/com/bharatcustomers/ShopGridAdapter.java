package naman.com.bharatcustomers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Naman on 17-06-2017.
 */

class ShopGridAdapter extends RecyclerView.Adapter<ShopGridAdapter.ViewHolder>{

    private ArrayList<Shop> shops = new ArrayList<Shop>();
    private Context context;

    ShopGridAdapter(ArrayList<Shop> shopsa, Context context)
    {
        shops=shopsa;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShopGridAdapter.ViewHolder holder, final int position) {
        holder.name1.setText(shops.get(position).shop_name);
        holder.address1.setText(shops.get(position).address);
        holder.contact1.setText("" + shops.get(position).contact);
        holder.price1.setText("₹" + shops.get(position).price);

        holder.price1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Checkout.class);
                intent.putExtra("contact", shops.get(position).contact);
                intent.putExtra("contact", shops.get(position).contact);
                intent.putExtra("contact", shops.get(position).contact);
                context.startActivity(new Intent(context, Checkout.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d("adapter", shops.size() + "");
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
