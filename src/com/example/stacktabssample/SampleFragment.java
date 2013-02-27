package com.example.stacktabssample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public  class SampleFragment extends Fragment implements OnClickListener {
	int mNum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	mNum = getArguments() != null ? getArguments().getInt("num") : 1;
    	TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER);
        textView.setText("Fragment #" + mNum);
        textView.setBackgroundColor(Color.LTGRAY);
        textView.setOnClickListener(this);
        return textView;
    }

	@Override
	public void onClick(View v) {
		Fragment newFragment = new SampleFragment();
		Bundle args = new Bundle();
		args.putInt("num", mNum+1);
		newFragment.setArguments(args);
		((StackBaseFragment)this.getParentFragment()).pushContentFragment(newFragment);
	}
}
