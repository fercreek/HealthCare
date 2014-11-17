package info.androidhive.tabsswipe.adapter;

import info.androidhive.tabsswipe.R;
import info.androidhive.tabsswipe.adapter.TabsPagerAdapter;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

    public static boolean asma ;
    public static boolean arritmia ;
    public static boolean diabetes ;
    public static boolean hipertension ;
    public static boolean cardiov ;

    public static boolean pesobajo;
    public static boolean pesonormal;
    public static boolean sobrepeso;
    public static boolean obesidad1;
    public static boolean obesidad2;
    public static boolean obesidad3;

    public static boolean isObesidad3() {
        return obesidad3;
    }
    public static void setObesidad3(boolean obesidad3) {
        MainActivity.obesidad3 = obesidad3;
    }
    public static boolean isPesobajo() {
        return pesobajo;
    }
    public static void setPesobajo(boolean pesobajo) {
        MainActivity.pesobajo = pesobajo;
    }
    public static boolean isPesonormal() {
        return pesonormal;
    }
    public static void setPesonormal(boolean pesonormal) {
        MainActivity.pesonormal = pesonormal;
    }
    public static boolean isSobrepeso() {
        return sobrepeso;
    }
    public static void setSobrepeso(boolean sobrepeso) {
        MainActivity.sobrepeso = sobrepeso;
    }
    public static boolean isObesidad1() {
        return obesidad1;
    }
    public static void setObesidad1(boolean obesidad1) {
        MainActivity.obesidad1 = obesidad1;
    }
    public static boolean isObesidad2() {
        return obesidad2;
    }
    public static void setObesidad2(boolean obesidad2) {
        MainActivity.obesidad2 = obesidad2;
    }
    public static boolean isAsma() {
        return asma;
    }
    public static void setAsma(boolean asmaCheck) {
        MainActivity.asma = asmaCheck;
    }
    public static boolean isCardiov() {
        return cardiov;
    }
    public static void setCardiov(boolean cardiov) {
        MainActivity.cardiov = cardiov;
    }
    public static boolean isHipertension() {
        return hipertension;
    }
    public static void setHipertension(boolean hipertension) {
        MainActivity.hipertension = hipertension;
    }
    public static boolean isDiabetes() {
        return diabetes;
    }
    public static void setDiabetes(boolean diabetes) {
        MainActivity.diabetes = diabetes;
    }
    public static boolean isArritmia() {
        return arritmia;
    }
    public static void setArritmia(boolean arritmia) {
        MainActivity.arritmia = arritmia;
    }




	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;

	private String[] tabs = { "Datos", "Ideales", "Ejercicios", "Tips", "Calculadora"};

    @Override
    protected void onStart() {
        super.onStart();

    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}

		/**
		 * on swiping the viewpager make respective tab selected
		 * */
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// on tab selected
		// show respected fragment view
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

}
