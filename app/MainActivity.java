package com.kagami.merusuto;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;

public class MainActivity extends Activity {

  private UnitListFragment mUnitListFragment;
  private MenuItem mSearchMenu;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    ActionBar actionBar = getActionBar();
    actionBar.setDisplayShowHomeEnabled(true);
    actionBar.setDisplayShowTitleEnabled(false);
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setIcon(R.drawable.ic_logo);

    if (savedInstanceState == null) {
      mUnitListFragment = new UnitListFragment();
      getFragmentManager().beginTransaction()
        .add(R.id.container, mUnitListFragment, "UnitListFragment")
        .commit();
    } else {
      mUnitListFragment = (UnitListFragment) getFragmentManager()
        .findFragmentByTag("UnitListFragment");
    }
  }

  @Override
  public boolean onCreateOptionsMenu(final Menu menu) {
    switch (mUnitListFragment.getTemplate()) {
    case UnitListFragment.TEMPLATE_UNIT:
      getMenuInflater().inflate(R.menu.options_unit, menu);
      break;
    case UnitListFragment.TEMPLATE_MONSTER:
      getMenuInflater().inflate(R.menu.options_monster, menu);
      break;
    }

    mSearchMenu = menu.findItem(R.id.menu_search);
    mSearchMenu.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {

      public void setMenuItemVisible(boolean visible) {
        MenuItem menuItem;
        menuItem = menu.findItem(R.id.menu_template);
        menuItem.setVisible(visible);
        menuItem = menu.findItem(R.id.menu_level_mode);
        if (menuItem != null) menuItem.setVisible(visible);
        menuItem = menu.findItem(R.id.menu_sort_mode);
        menuItem.setVisible(visible);
        menuItem = menu.findItem(R.id.menu_filters);
        menuItem.setVisible(visible);
        menuItem = menu.findItem(R.id.menu_close_search);
        menuItem.setVisible(!visible);
      }

      @Override
      public boolean onMenuItemActionCollapse(MenuItem item) {
        mUnitListFragment.setSearchQuery(null);
        setMenuItemVisible(true);
        return true;
      }

      @Override
      public boolean onMenuItemActionExpand(MenuItem item) {
        setMenuItemVisible(false);
        return true;
      }
    });

    SearchView searchView = (SearchView) mSearchMenu.getActionView();
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextChange(String query) {
        if (query.isEmpty()) query = null;
        mUnitListFragment.setSearchQuery(query);
        return true;
      }

      @Override
      public boolean  onQueryTextSubmit(String query) {
        mUnitListFragment.setSearchQuery(query);
        return true;
      }
    });

    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
      mUnitListFragment.scrollToTop();
      break;
    case R.id.menu_close_search:
      mSearchMenu.collapseActionView();
      break;
    case R.id.menu_template_unit:
      mUnitListFragment.setTemplate(UnitListFragment.TEMPLATE_UNIT);
      invalidateOptionsMenu();
      break;
    case R.id.menu_template_monster:
      mUnitListFragment.setTemplate(UnitListFragment.TEMPLATE_MONSTER);
      invalidateOptionsMenu();
      break;
    case R.id.menu_rare_0:
      mUnitListFragment.setRare(0);
      break;
    case R.id.menu_rare_1:
      mUnitListFragment.setRare(1);
      break;
    case R.id.menu_rare_2:
      mUnitListFragment.setRare(2);
      break;
    case R.id.menu_rare_3:
      mUnitListFragment.setRare(3);
      break;
    case R.id.menu_rare_4:
      mUnitListFragment.setRare(4);
      break;
    case R.id.menu_rare_5:
      mUnitListFragment.setRare(5);
      break;
    case R.id.menu_element_0:
      mUnitListFragment.setElement(0);
      break;
    case R.id.menu_element_1:
      mUnitListFragment.setElement(1);
      break;
    case R.id.menu_element_2:
      mUnitListFragment.setElement(2);
      break;
    case R.id.menu_element_3:
      mUnitListFragment.setElement(3);
      break;
    case R.id.menu_element_4:
      mUnitListFragment.setElement(4);
      break;
    case R.id.menu_element_5:
      mUnitListFragment.setElement(5);
      break;
    case R.id.menu_weapon_0:
      mUnitListFragment.setWeapon(0);
      break;
    case R.id.menu_weapon_1:
      mUnitListFragment.setWeapon(1);
      break;
    case R.id.menu_weapon_2:
      mUnitListFragment.setWeapon(2);
      break;
    case R.id.menu_weapon_3:
      mUnitListFragment.setWeapon(3);
      break;
    case R.id.menu_weapon_4:
      mUnitListFragment.setWeapon(4);
      break;
    case R.id.menu_weapon_5:
      mUnitListFragment.setWeapon(5);
      break;
    case R.id.menu_weapon_6:
      mUnitListFragment.setWeapon(6);
      break;
    case R.id.menu_weapon_7:
      mUnitListFragment.setWeapon(7);
      break;
    case R.id.menu_type_0:
      mUnitListFragment.setType(0);
      break;
    case R.id.menu_type_1:
      mUnitListFragment.setType(1);
      break;
    case R.id.menu_type_2:
      mUnitListFragment.setType(2);
      break;
    case R.id.menu_type_3:
      mUnitListFragment.setType(3);
      break;
    case R.id.menu_skin_0:
      mUnitListFragment.setSkin(0);
      break;
    case R.id.menu_skin_1:
      mUnitListFragment.setSkin(1);
      break;
    case R.id.menu_skin_2:
      mUnitListFragment.setSkin(2);
      break;
    case R.id.menu_skin_3:
      mUnitListFragment.setSkin(3);
      break;
    case R.id.menu_sort_rare:
      mUnitListFragment.setSortMode(UnitListFragment.SORT_RARE);
      break;
    case R.id.menu_sort_dps:
      mUnitListFragment.setSortMode(UnitListFragment.SORT_DPS);
      break;
    case R.id.menu_sort_mult_dps:
      mUnitListFragment.setSortMode(UnitListFragment.SORT_MULT_DPS);
      break;
    case R.id.menu_sort_life:
      mUnitListFragment.setSortMode(UnitListFragment.SORT_LIFE);
      break;
    case R.id.menu_sort_atk:
      mUnitListFragment.setSortMode(UnitListFragment.SORT_ATK);
      break;
    case R.id.menu_sort_aarea:
      mUnitListFragment.setSortMode(UnitListFragment.SORT_AAREA);
      break;
    case R.id.menu_sort_anum:
      mUnitListFragment.setSortMode(UnitListFragment.SORT_ANUM);
      break;
    case R.id.menu_sort_aspd:
      mUnitListFragment.setSortMode(UnitListFragment.SORT_ASPD);
      break;
    case R.id.menu_sort_tenacity:
      mUnitListFragment.setSortMode(UnitListFragment.SORT_TENACITY);
      break;
    case R.id.menu_sort_mspd:
      mUnitListFragment.setSortMode(UnitListFragment.SORT_MSPD);
      break;
    case R.id.menu_level_zero:
      mUnitListFragment.setLevelMode(UnitListFragment.LEVEL_ZERO);
      break;
    case R.id.menu_level_max_lv:
      mUnitListFragment.setLevelMode(UnitListFragment.LEVEL_MAX_LV);
      break;
    case R.id.menu_level_max_lv_gr:
      mUnitListFragment.setLevelMode(UnitListFragment.LEVEL_MAX_LV_GR);
      break;
    case R.id.menu_reset:
      mUnitListFragment.reset();
      break;
    }

    return super.onOptionsItemSelected(item);
  }

}
