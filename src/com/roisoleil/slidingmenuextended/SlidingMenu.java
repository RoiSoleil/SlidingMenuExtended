package com.roisoleil.slidingmenuextended;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class SlidingMenu implements Menu {

	Context context;

	Resources resources;

	List<MenuItem> menuItems = new ArrayList<MenuItem>();

	public SlidingMenu(Context context) {
		this.context = context;
		this.resources = context.getResources();
	}

	@Override
	public MenuItem add(CharSequence title) {
		return addInternal(0, 0, 0, title);
	}

	@Override
	public MenuItem add(int titleRes) {
		return addInternal(0, 0, 0, resources.getString(titleRes));
	}

	@Override
	public MenuItem add(int groupId, int itemId, int order, CharSequence title) {
		return addInternal(groupId, itemId, order, title);
	}

	@Override
	public MenuItem add(int groupId, int itemId, int order, int titleRes) {
		return addInternal(groupId, itemId, order,
				resources.getString(titleRes));
	}

	private MenuItem addInternal(int group, int id, int categoryOrder,
			CharSequence title) {
		int ordering = getOrdering(categoryOrder);
		SlidingMenuItem slidingMenuItem = new SlidingMenuItem(this, group, id,
				categoryOrder, ordering, title);

		menuItems.add(findInsertIndex(menuItems, ordering), slidingMenuItem);
		return slidingMenuItem;
	}

	@Override
	public SubMenu addSubMenu(CharSequence title) {
		return null;
	}

	@Override
	public SubMenu addSubMenu(int titleRes) {
		return null;
	}

	@Override
	public SubMenu addSubMenu(int groupId, int itemId, int order,
			CharSequence title) {
		return null;
	}

	@Override
	public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
		return null;
	}

	@Override
	public int addIntentOptions(int groupId, int itemId, int order,
			ComponentName caller, Intent[] specifics, Intent intent, int flags,
			MenuItem[] outSpecificItems) {
		return 0;
	}

	@Override
	public void removeItem(int id) {
		Set<MenuItem> toRemoves = new HashSet<MenuItem>();
		for (MenuItem menuItem : menuItems) {
			if (id == menuItem.getItemId()) {
				toRemoves.add(menuItem);
			}
		}
		menuItems.removeAll(toRemoves);
	}

	@Override
	public void removeGroup(int groupId) {
		Set<MenuItem> toRemoves = new HashSet<MenuItem>();
		for (MenuItem menuItem : menuItems) {
			if (groupId == menuItem.getGroupId()) {
				toRemoves.add(menuItem);
			}
		}
		menuItems.removeAll(toRemoves);
	}

	@Override
	public void clear() {
		menuItems.clear();
	}

	@Override
	public void setGroupCheckable(int group, boolean checkable,
			boolean exclusive) {
	}

	@Override
	public void setGroupVisible(int group, boolean visible) {
	}

	@Override
	public void setGroupEnabled(int group, boolean enabled) {
	}

	@Override
	public boolean hasVisibleItems() {
		return menuItems.size() > 0;
	}

	@Override
	public MenuItem findItem(int id) {
		for (MenuItem menuItem : menuItems) {
			if (id == menuItem.getItemId()) {
				return menuItem;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return menuItems.size();
	}

	@Override
	public MenuItem getItem(int index) {
		return menuItems.get(index);
	}

	@Override
	public void close() {
	}

	@Override
	public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
		return false;
	}

	@Override
	public boolean isShortcutKey(int keyCode, KeyEvent event) {
		return false;
	}

	@Override
	public boolean performIdentifierAction(int id, int flags) {
		return false;
	}

	@Override
	public void setQwertyMode(boolean isQwerty) {
	}

	private static int getOrdering(int categoryOrder) {
		return 0;
	}

	public Context getContext() {
		return context;
	}

	public Resources getResources() {
		return resources;
	}

	private static int findInsertIndex(List<MenuItem> menuItems, int ordering) {
		for (int i = menuItems.size() - 1; i >= 0; i--) {
			MenuItem menuItem = menuItems.get(i);
			if (menuItem.getOrder() <= ordering) {
				return i + 1;
			}
		}
		return 0;
	}

}
