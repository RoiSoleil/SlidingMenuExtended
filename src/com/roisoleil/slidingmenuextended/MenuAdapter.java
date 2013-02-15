package com.roisoleil.slidingmenuextended;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

public class MenuAdapter extends BaseAdapter {

	protected Activity activity;

	protected Menu menu;

	public MenuAdapter(Activity activity, int menuRes) {
		menu = new SlidingMenu(activity);
		MenuInflater menuInflater = new MenuInflater(activity);
		menuInflater.inflate(menuRes, menu);
	}

	@Override
	public int getCount() {
		return menu.size();
	}

	@Override
	public Object getItem(int position) {
		return menu.getItem(position);
	}

	@Override
	public long getItemId(int position) {
		return menu.getItem(position).getItemId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = menu.getItem(position).getActionView();
		view.setLayoutParams(new AbsListView.LayoutParams(parent
				.getLayoutParams()));
		return view;
	}
}
