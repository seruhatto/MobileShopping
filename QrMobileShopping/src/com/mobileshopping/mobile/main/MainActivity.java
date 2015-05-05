package com.mobileshopping.mobile.main;

import com.example.fragmentexample.R;
import com.mobileshopping.mobile.basket.BasketActivity;
import com.mobileshopping.mobile.information.InformationActivity;
import com.mobileshopping.mobile.order.OrderActivity;
import com.mobileshopping.mobile.qrcode.QKActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Intent intent = getIntent();
		//String s = intent.getStringExtra(RESULT);

	}
	

	public void addNewProduct(View v){
		//min activty icinden simple activity e gecmek icin intent kullaniliyor
		Intent intent = new Intent(getApplicationContext(),QKActivity.class);
		startActivity(intent);
	}
	
	public void userInformation(View v){
		//min activty icinden simple activity e gecmek icin intent kullaniliyor
		Intent intent = new Intent(getApplicationContext(),InformationActivity.class);
		startActivity(intent);
	}
	
	public void checkBasket(View v){
		//min activty icinden simple activity e gecmek icin intent kullaniliyor
		Intent intent = new Intent(getApplicationContext(),BasketActivity.class);
		startActivity(intent);
	}
	
	public void completeShoppingOrder(View v){
		//min activty icinden simple activity e gecmek icin intent kullaniliyor
		Intent intent = new Intent(getApplicationContext(),OrderActivity.class);
		startActivity(intent);
	}
	  




	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	}*/

	/**
	 * A placeholder fragment containing a simple view.
	 */
	/*public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}*/
}
