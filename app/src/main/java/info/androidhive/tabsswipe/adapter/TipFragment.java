package info.androidhive.tabsswipe.adapter;

import info.androidhive.tabsswipe.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class TipFragment extends Fragment {

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        CheckBox checkbox1 = (CheckBox)getActivity().findViewById(R.id.checkasma);
        View rootView = inflater.inflate(R.layout.fragment_tip, container, false);
        TextView tip1 = (TextView)rootView.findViewById(R.id.c1);
//        tip1.setText(c1);

        if (checkbox1.isChecked()) {
            checkbox1.setChecked(false);
        }
//        if(checkbox1.isChecked()) {
//            tip1.setText("Esfuérzate pero hasta que te sientas bien, no hagas  sobresfuerzos\n" +
//                    "Tra    ta de tener tu medicina por si pasa una emergencia.\n" +
//                    "Has poco a poco las actividades de cardiovasculares.\n" +
//                    "Come alimentos alto en energía");
//        }


		return rootView;
	}


}
