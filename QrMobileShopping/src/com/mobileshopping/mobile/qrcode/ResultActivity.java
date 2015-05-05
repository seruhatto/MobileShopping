package com.mobileshopping.mobile.qrcode;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentexample.R;
import com.mobileshopping.mobile.basket.BasketActivity;
import com.mobileshopping.mobile.main.MainActivity;
import com.mobileshopping.mobile.model.Product;

public class ResultActivity extends Activity {

	public static final String RESULT = "result";
	public static String qrString;

	public static final String ENDPOINT = "http://217.78.109.129:8080/MobileShoppingWS/webapi";

	Product product;

	TextView productTextView;
	ProgressBar pb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		Intent intent = getIntent();
		qrString = intent.getStringExtra(RESULT);

		pb = (ProgressBar) findViewById(R.id.progressBar1);
		pb.setVisibility(View.INVISIBLE);

		productTextView = (TextView) findViewById(R.id.urunTextView);

		getProductfromWS();
	}

	public void addAndReturnMain(View v) {
		// min activty icinden simple activity e gecmek icin intent kullaniliyor
		Intent productIntent = new Intent(getApplicationContext(), BasketActivity.class);

		productIntent.putExtra("Product", product);
		startActivity(productIntent);  
	}

	public void cancelAndReturnMain(View v) {
		// min activty icinden simple activity e gecmek icin intent kullaniliyor
		Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent2);
	}

	// @Override
	// protected void onListItemClick(ListView l, View v, int position, long id)
	// {
	// super.onListItemClick(l, v, position, id);
	// Product product = productList.get(position);
	// System.out.println(product.toString());
	//
	// Intent productIntent = new Intent(getBaseContext(),
	// ProductActivity.class);
	// productIntent.putExtra("Product", product);
	// startActivity(productIntent);
	//
	// }

	public boolean getProductfromWS() {

		if (isOnline()) {
			System.out.println("orhan hit onOptionsItemSelected sys");
			requestData();
		} else {
			Toast.makeText(this, "Network isn't available", Toast.LENGTH_LONG)
					.show();
		}
		return false;
	}

	private void requestData() {

		RestAdapter adapter = new RestAdapter.Builder().setEndpoint(ENDPOINT)
				.build();

		ProductAPI api = adapter.create(ProductAPI.class);

		pb.setVisibility(View.VISIBLE);

		api.getProduct(qrString, new Callback<Product>() {

			@Override
			public void success(Product arg0, Response arg1) {
				System.out.println("orhan hit success sys" + arg0.toString());

				product = arg0;
				updateDisplay();
			}

			@Override
			public void failure(RetrofitError arg0) {
				System.out.println("orhan hit failure sys" + arg0.toString());
			}
		});

	}

	protected void updateDisplay() {

		// ProductAdapter adapter = new ProductAdapter(this,
		// R.layout.item_product, productList);
		// setListAdapter(adapter);
		pb.setVisibility(View.INVISIBLE);

		if (product != null) {
			productTextView.append(product.toString());
			pb.setVisibility(View.INVISIBLE);
		}

	}

	protected boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		} else {
			return false;
		}
	}
}
