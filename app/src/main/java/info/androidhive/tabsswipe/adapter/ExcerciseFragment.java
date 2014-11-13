package info.androidhive.tabsswipe.adapter;

import info.androidhive.tabsswipe.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class ExcerciseFragment extends Fragment {
    @Override
    public void onResume() {
        EditText edit = (EditText)getActivity().findViewById(R.id.olakaset);

        Toast.makeText(getActivity(), MainActivity.isAsma()?"tru":"fals", Toast.LENGTH_SHORT).show();

        if (MainActivity.isAsma()){

//            MainActivity.asma= Boolean.parseBoolean(null);
            edit.setText("good");
        }else{
//            MainActivity.asma= Boolean.parseBoolean(null);
            edit.setText("bad");
        }
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
