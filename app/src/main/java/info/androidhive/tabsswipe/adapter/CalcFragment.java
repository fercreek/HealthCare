package info.androidhive.tabsswipe.adapter;

import info.androidhive.tabsswipe.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class CalcFragment extends Fragment {
    public Integer sum = 0;

    @Override
    public void onStart() {
        super.onStart();
        final CheckBox agua = (CheckBox)getActivity().findViewById(R.id.agua);
        final CheckBox coca = (CheckBox)getActivity().findViewById(R.id.coca);
        final CheckBox leche = (CheckBox)getActivity().findViewById(R.id.leche);
        final CheckBox huevo = (CheckBox)getActivity().findViewById(R.id.huevo);
        final CheckBox manzana = (CheckBox)getActivity().findViewById(R.id.manzana);
        final CheckBox platano = (CheckBox)getActivity().findViewById(R.id.platano);
        final CheckBox hotcackes = (CheckBox)getActivity().findViewById(R.id.hotcake);
        final CheckBox atun = (CheckBox)getActivity().findViewById(R.id.atun);
        final CheckBox spaguetti = (CheckBox)getActivity().findViewById(R.id.spaguetti);
        final CheckBox bistec = (CheckBox)getActivity().findViewById(R.id.bistec);
        final CheckBox pollo = (CheckBox)getActivity().findViewById(R.id.pollo);
        final CheckBox jamon = (CheckBox)getActivity().findViewById(R.id.jamon);
        final EditText display = (EditText)getActivity().findViewById(R.id.calcu);
        Button boton = (Button)getActivity().findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agua.setChecked(false);
                coca.setChecked(false);
                leche.setChecked(false);
                huevo.setChecked(false);
                manzana.setChecked(false);
                platano.setChecked(false);
                hotcackes.setChecked(false);
                atun.setChecked(false);
                spaguetti.setChecked(false);
                bistec.setChecked(false);
                pollo.setChecked(false);
                jamon.setChecked(false);
            }
        });

        agua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    sum+=0;
                display.setText(String.valueOf(sum));
            }
        });
        coca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (coca.isChecked()){
                    sum += 210;
                }else{
                    sum -=210;
                }
                display.setText(String.valueOf(sum));

            }
        });
        leche.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (leche.isChecked()){
                    sum+=300;
                }else{
                    sum-=300;
                }
                display.setText(String.valueOf(sum));

            }
        });
        atun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (atun.isChecked()){
                    sum+=56;
                }else{
                    sum-=56;
                }
                display.setText(String.valueOf(sum));

            }
        });
        spaguetti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (spaguetti.isChecked()){
                    sum+=233;
                }else{
                    sum-=233;
                }
                display.setText(String.valueOf(sum));

            }
        });
        bistec.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (bistec.isChecked()){
                    sum+=360;
                }else{
                    sum-=360;
                }
                display.setText(String.valueOf(sum));
            }
        });

        pollo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (pollo.isChecked()){
                    sum+=144;
                }else{
                    sum-=144;
                }
                display.setText(String.valueOf(sum));

            }
        });

        jamon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (jamon.isChecked()){
                    sum+=393;
                }else{
                    sum-=393;
                }
                display.setText(String.valueOf(sum));

            }
        });
        huevo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (huevo.isChecked()){
                    sum+=108;
                }else{
                    sum-=108;
                }
                display.setText(String.valueOf(sum));

            }
        });
        manzana.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (manzana.isChecked()){
                    sum+=58;
                }else{
                    sum-=58;
                }
                display.setText(String.valueOf(sum));

            }
        });
        platano.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (platano.isChecked()){
                    sum+=52;
                }else{
                    sum-=52;
                }
                display.setText(String.valueOf(sum));

            }
        });
        hotcackes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (hotcackes.isChecked()){
                    sum+=800;
                }else{
                    sum-=800;
                }
                display.setText(String.valueOf(sum));

            }
        });
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_calc, container, false);

        return rootView;
    }
}
