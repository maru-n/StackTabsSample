package com.example.stacktabssample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;

public class MainActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
                StackBaseFragment.class, null);

        mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator("Contacts"),
        		StackBaseFragment.class, null);
    }
    
    @Override
    public void onBackPressed() {
    	FragmentManager fm = this.getSupportFragmentManager().findFragmentByTag(mTabHost.getCurrentTabTag()).getChildFragmentManager();
    	if( fm.getBackStackEntryCount() != 0) {
    		fm.popBackStack();
    	}else{
    		super.onBackPressed();
    	}
    }
}