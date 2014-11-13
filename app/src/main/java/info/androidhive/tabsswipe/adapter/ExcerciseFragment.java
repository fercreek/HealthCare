package info.androidhive.tabsswipe.adapter;

import info.androidhive.tabsswipe.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ExcerciseFragment extends Fragment {
    MainActivity main = new MainActivity();

    @Override
    public void onResume() {
//        EditText edit = (EditText)getActivity().findViewById(R.id.olakaset);
//        if (main.isAsma()){
//            edit.setText("meh");
//        }
        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_exer, container, false);
		
		return rootView;
	}
}
