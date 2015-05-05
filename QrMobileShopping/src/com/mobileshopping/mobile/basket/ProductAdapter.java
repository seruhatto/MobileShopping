package com.mobileshopping.mobile.basket;

import java.util.List;

import com.example.fragmentexample.R;
import com.mobileshopping.mobile.model.Product;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

@SuppressLint("ViewHolder")
public class ProductAdapter extends ArrayAdapter<Product> {

    private Context context;

    private List<Product> productList;

    public ProductAdapter(Context context, int resource, List<Product> object) {
        super(context, resource, object);
        this.context = context;
        this.productList = object;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        System.out.println("hithere adaptor");
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_product, parent, false);

        // Display product name in the TextView widget

        Product product = productList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.textView1);
        tv.setText(product.getProductName());

        return view;
    }

}
