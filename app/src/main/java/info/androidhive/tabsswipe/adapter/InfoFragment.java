package info.androidhive.tabsswipe.adapter;

import info.androidhive.tabsswipe.R;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class InfoFragment extends Fragment {

    private TextView pesoActIdealFrag;
    private EditText pesoActInfoFrag;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_info, container, false);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();



        Button update = (Button)getActivity().findViewById(R.id.infoButton);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView msg = (TextView)getActivity().findViewById(R.id.updateNot);
                Toast.makeText(getActivity(), msg.getText(), Toast.LENGTH_SHORT).show();

                pesoActInfoFrag = (EditText)getActivity().findViewById(R.id.peso);

                pesoActIdealFrag = (TextView)getActivity().findViewById(R.id.pesoAct);
                pesoActIdealFrag.setText(pesoActInfoFrag.getText());
            }
        });
    }
}
