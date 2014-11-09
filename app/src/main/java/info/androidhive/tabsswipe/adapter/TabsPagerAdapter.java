package info.androidhive.tabsswipe.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
            return new InfoFragment();
        case 1:
            return new IdealFragment();
        case 2:
            return new ExcerciseFragment();
        case 3:
            return new TipFragment();
        case 4:
            return new CalcFragment();
        }
        return null;
	}

	@Override
	public int getCount() {
		return 5;
	}

}
