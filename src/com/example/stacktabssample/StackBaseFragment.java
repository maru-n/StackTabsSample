package com.example.stacktabssample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StackBaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fragment newFragment = new SampleFragment();
        Bundle args = new Bundle();
        args.putInt("num", 0);
        newFragment.setArguments(args);
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.add(R.id.content, newFragment).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stackbase, container, false);
        return v;
    }

    public void pushContentFragment(Fragment f) {
    	FragmentTransaction ft = getChildFragmentManager().beginTransaction();
    	ft.add(R.id.content, f);
    	ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    	ft.addToBackStack(null);
    	ft.commit();
	}
}
