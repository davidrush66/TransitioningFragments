package com.Agtek.transitioningfragments;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	Fragment fragment;
	Button bFrag1,bFrag2,bFrag3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bFrag1 = (Button)findViewById(R.id.bFrag1);
        bFrag2 = (Button)findViewById(R.id.bFrag2);
        bFrag3 = (Button)findViewById(R.id.bFrag3);
        
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        StartFragment myFragment = new StartFragment();
        ft.add(R.id.myFragment, myFragment);
        ft.commit();
        
        bFrag1.setOnClickListener(btnOnClickListener);
        bFrag2.setOnClickListener(btnOnClickListener);
        bFrag3.setOnClickListener(btnOnClickListener);
        
        
    }
    
    Button.OnClickListener btnOnClickListener = new Button.OnClickListener(){

    	@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			android.app.Fragment newFragment;
			switch(v.getId()) {
			case R.id.bFrag1:
				newFragment = new Fragment1();
				break;
			case R.id.bFrag2:
				newFragment = new Fragment2();
				break;
			case R.id.bFrag3:
				newFragment = new Fragment3();
				break;
				default:
					newFragment = new StartFragment();
				
			}
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			transaction.replace(R.id.myFragment, newFragment);
			transaction.addToBackStack(null);
			transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			transaction.commit();
		}
    
    };

    @Override
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
    }

}
