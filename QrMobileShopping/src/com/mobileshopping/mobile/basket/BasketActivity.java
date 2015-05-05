package com.mobileshopping.mobile.basket;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.fragmentexample.R;
import com.mobileshopping.mobile.main.MainActivity;
import com.mobileshopping.mobile.model.Product;
import com.mobileshopping.mobile.order.OrderActivity;
import com.mobileshopping.mobile.qrcode.QKActivity;

public class BasketActivity extends ListActivity {
	
	public static List<Product> productList = new ArrayList<Product>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basket);
		
        Intent productIntent = getIntent();
        Product product = (Product)productIntent.getSerializableExtra("Product");
        if (product != null) {
        	productList.add(product);
		}
        
		updateDisplay();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.basket, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Product product = productList.get(position);
        System.out.println(product.toString());
        
//        Intent productIntent = new Intent(getBaseContext(), ProductActivity.class);      
//        productIntent.putExtra("Product", product);
//        startActivity(productIntent);      
    }
    
    protected void updateDisplay() {

        ProductAdapter adapter = new ProductAdapter(this, R.layout.item_product, productList);
        setListAdapter(adapter);
    }
    
	public void addNewProduct(View v){
		//min activty icinden simple activity e gecmek icin intent kullaniliyor
		Intent intent = new Intent(getApplicationContext(),QKActivity.class);
		startActivity(intent);
	}
	
	public void completeShoppingOrder(View v){
		//min activty icinden simple activity e gecmek icin intent kullaniliyor
		Intent intent = new Intent(getApplicationContext(),OrderActivity.class);
		startActivity(intent);
	}
	
	public void returnToMain(View v) {
		// min activty icinden simple activity e gecmek icin intent kullaniliyor
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);
	}
}
