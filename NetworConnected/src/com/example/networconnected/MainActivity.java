package com.example.networconnected;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		TextView text = (TextView)findViewById(R.id.TextView);

		 /**ネットワーク接続チェック**/
        if ( networkIsConnected(this.getApplicationContext()) ) {

            Toast.makeText(this, "オンライン", Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(this, "オフライン", Toast.LENGTH_LONG).show();
        }
	
	}
	
	/**ネットワーク接続チェック**/
    public static boolean networkIsConnected(Context context){
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if( ni != null ){
            return cm.getActiveNetworkInfo().isConnected();
        }
        return false;
    }

}

