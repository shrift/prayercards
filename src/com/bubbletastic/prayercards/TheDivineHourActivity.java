package com.bubbletastic.prayercards;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class TheDivineHourActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tdh_main);
        
		Button fullWebPageButton = (Button) findViewById(R.id.button1);
		fullWebPageButton.setOnClickListener(new OnClickListener() {
			//@Override
			public void onClick(View v) {
				fullWebPagePressed();
			}
		});			
        
		Button mobileWebPageButton = (Button) findViewById(R.id.button2);
		mobileWebPageButton.setOnClickListener(new OnClickListener() {
			//@Override
			public void onClick(View v) {
				mobileWebPagePressed();
			}
		});			


        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.push_in_from_left, R.anim.push_out_to_right);
	}

	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
        	Intent intent = new Intent(this, CardListActivity.class);
        	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            overridePendingTransition(R.anim.push_in_from_left, R.anim.push_out_to_right);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    
    public void fullWebPagePressed() {
		String url = getString(R.string.url_tdh_full);
		launchWebBrowser(url);
    }
    
    public void mobileWebPagePressed() {
    
		String url = getString(R.string.url_tdh_mobile);
        launchWebBrowser(url);

    }
    
    private void launchWebBrowser(String url) {
    	
  	  	Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(url)); 
  	  	startActivity(browserIntent);    		
        overridePendingTransition(R.anim.push_in_from_right, R.anim.push_out_to_left);
    }
    
}
