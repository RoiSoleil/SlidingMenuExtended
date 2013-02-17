package com.roisoleil.slidingmenuextended;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.roisoleill.slidingmenuextended.R;

public abstract class MenuFragment extends ListFragment implements
		OnItemClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setListAdapter(new MenuAdapter(getActivity(), getMenuRes()));
		getListView().setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Object object = parent.getItemAtPosition(position);
		if (object instanceof SlidingMenuItem) {
			SlidingMenuItem slidingMenuItem = (SlidingMenuItem) object;
			slidingMenuItem.click();
		}
	}

	public abstract int getMenuRes();

}
