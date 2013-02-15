package com.roisoleil.slidingmenuextended;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.roisoleill.slidingmenuextended.R;

public class SlidingMenuItem implements MenuItem {

	final static int NO_ICON = 0;

	SlidingMenu slidingMenu;

	int group;

	int id;

	int categoryOrder;

	int ordering;

	CharSequence title;

	int showAsAction;

	Drawable iconDrawable;

	int iconResId = NO_ICON;

	Intent intent;

	OnMenuItemClickListener onMenuItemClickListener;

	View actionView;

	ActionProvider actionProvider;

	SlidingMenuItem(SlidingMenu slidingMenu, int group, int id,
			int categoryOrder, int ordering, CharSequence title) {
		this.slidingMenu = slidingMenu;
		this.id = id;
		this.group = group;
		this.categoryOrder = categoryOrder;
		this.ordering = ordering;
		this.title = title;
	}

	SlidingMenuItem(SlidingMenu slidingMenu, int group, int id,
			int categoryOrder, int ordering, CharSequence title,
			int showAsAction) {
		this(slidingMenu, group, id, categoryOrder, ordering, title);
		this.showAsAction = showAsAction;
	}

	@Override
	public int getItemId() {
		return id;
	}

	@Override
	public int getGroupId() {
		return group;
	}

	@Override
	public int getOrder() {
		return ordering;
	}

	@Override
	public MenuItem setTitle(CharSequence title) {
		this.title = title;
		return this;
	}

	@Override
	public MenuItem setTitle(int title) {
		return setTitle(slidingMenu.getContext().getString(title));
	}

	@Override
	public CharSequence getTitle() {
		return title;
	}

	@Override
	public MenuItem setTitleCondensed(CharSequence title) {
		return this;
	}

	@Override
	public CharSequence getTitleCondensed() {
		return title;
	}

	@Override
	public MenuItem setIcon(Drawable icon) {
		iconResId = NO_ICON;
		iconDrawable = icon;
		return this;
	}

	@Override
	public MenuItem setIcon(int iconRes) {
		iconDrawable = null;
		iconResId = iconRes;
		return this;
	}

	@Override
	public Drawable getIcon() {
		if (iconDrawable != null) {
			return iconDrawable;
		}
		if (iconResId != NO_ICON) {
			Drawable icon = slidingMenu.getResources().getDrawable(iconResId);
			iconResId = NO_ICON;
			iconDrawable = icon;
			return icon;
		}
		return null;
	}

	@Override
	public MenuItem setIntent(Intent intent) {
		this.intent = intent;
		return this;
	}

	@Override
	public Intent getIntent() {
		return intent;
	}

	@Override
	public MenuItem setShortcut(char numericChar, char alphaChar) {
		return this;
	}

	@Override
	public MenuItem setNumericShortcut(char numericChar) {
		return this;
	}

	@Override
	public char getNumericShortcut() {
		return 0;
	}

	@Override
	public MenuItem setAlphabeticShortcut(char alphaChar) {
		return this;
	}

	@Override
	public char getAlphabeticShortcut() {
		return 0;
	}

	@Override
	public MenuItem setCheckable(boolean checkable) {
		return this;
	}

	@Override
	public boolean isCheckable() {
		return false;
	}

	@Override
	public MenuItem setChecked(boolean checked) {
		return this;
	}

	@Override
	public boolean isChecked() {
		return false;
	}

	@Override
	public MenuItem setVisible(boolean visible) {
		return this;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public MenuItem setEnabled(boolean enabled) {
		return this;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean hasSubMenu() {
		return false;
	}

	@Override
	public SubMenu getSubMenu() {
		return null;
	}

	@Override
	public MenuItem setOnMenuItemClickListener(
			OnMenuItemClickListener menuItemClickListener) {
		this.onMenuItemClickListener = menuItemClickListener;
		return this;
	}

	@Override
	public ContextMenuInfo getMenuInfo() {
		return null;
	}

	@Override
	public void setShowAsAction(int actionEnum) {
	}

	@Override
	public MenuItem setShowAsActionFlags(int actionEnum) {
		return this;
	}

	@Override
	public MenuItem setActionView(View view) {
		actionView = view;
		actionView.setId(getItemId());
		if (getIcon() != null) {
			((ImageView) view.findViewById(R.id.menuIcon))
					.setImageDrawable(getIcon());
		}
		if (getTitle() != null) {
			((TextView) view.findViewById(R.id.menuText)).setText(getTitle());
		}
		return this;
	}

	@Override
	public MenuItem setActionView(int resId) {
		LayoutInflater layoutInflater = LayoutInflater.from(slidingMenu
				.getContext());
		setActionView(layoutInflater.inflate(resId, new LinearLayout(
				slidingMenu.getContext()), false));
		return this;
	}

	@Override
	public View getActionView() {
		return actionView;
	}

	@Override
	public MenuItem setActionProvider(ActionProvider actionProvider) {
		this.actionProvider = actionProvider;
		return this;
	}

	@Override
	public ActionProvider getActionProvider() {
		return actionProvider;
	}

	@Override
	public boolean expandActionView() {
		return false;
	}

	@Override
	public boolean collapseActionView() {
		return false;
	}

	@Override
	public boolean isActionViewExpanded() {
		return false;
	}

	@Override
	public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
		return null;
	}

	public void click() {
		if (onMenuItemClickListener != null) {
			onMenuItemClickListener.onMenuItemClick(this);
		}
	}

}
