package info.androidhive.tabsswipe.adapter;

import info.androidhive.tabsswipe.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {

    private EditText pesoActInfoFrag;
    private EditText EstatActInfoFrag;

    private TextView pesoActIdealFrag;
    private TextView IMCActIdealaFrag;
    private TextView comentIMC;
    private TextView pesoIdeal;

    private Double imc;
    private Double pesoIdealText;

    private String PIT;
    private String IMC;

    private ListView lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_info, container, false);

        return rootView;
    }


    public Double CalcPesoIdeal(Double imc, Double estat){
        pesoIdealText = imc * Math.pow(estat,2);
        return pesoIdealText;
    }

    public void setts(String PIT, Double imc){
        if(imc>=40){
            comentIMC.setText("Obesidad grado III Extrema o Mórbida. " +
                    "Riesgo relativo extremadamente alto para el desarrollo " +
                    "de enfermedades cardiovasculares");
            pesoIdeal.setText(PIT);
            MainActivity.setPesobajo(false);
            MainActivity.setPesonormal(false);
            MainActivity.setSobrepeso(false);
            MainActivity.setObesidad1(false);
            MainActivity.setObesidad2(false);
            MainActivity.setObesidad3(true);

        }else if(imc>=30){
            comentIMC.setText("Obesidad grado II. Riesgo relativo muy alto para " +
                    "el desarrollo de enfermedades cardiovasculares");
            pesoIdeal.setText(PIT);
            MainActivity.setPesobajo(false);
            MainActivity.setPesonormal(false);
            MainActivity.setSobrepeso(false);
            MainActivity.setObesidad1(false);
            MainActivity.setObesidad2(true);
            MainActivity.setObesidad3(false);
        }else if(imc>=27){
            comentIMC.setText("Obesidad grado I. Riesgo relativo alto para desarrollar " +
                    "enfermedades cardiovasculares");
            pesoIdeal.setText(PIT);
            MainActivity.setPesobajo(false);
            MainActivity.setPesonormal(false);
            MainActivity.setSobrepeso(false);
            MainActivity.setObesidad1(true);
            MainActivity.setObesidad2(false);
            MainActivity.setObesidad3(false);
        }else if(imc>=25){
            comentIMC.setText("Sobrepeso");
            pesoIdeal.setText(PIT);
            MainActivity.setPesobajo(false);
            MainActivity.setPesonormal(false);
            MainActivity.setSobrepeso(true);
            MainActivity.setObesidad1(false);
            MainActivity.setObesidad2(false);
            MainActivity.setObesidad3(false);
        }else if(imc>=18){
            comentIMC.setText("Normal");
            pesoIdeal.setText(PIT);
            MainActivity.setPesobajo(false);
            MainActivity.setPesonormal(true);
            MainActivity.setSobrepeso(false);
            MainActivity.setObesidad1(false);
            MainActivity.setObesidad2(false);
            MainActivity.setObesidad3(false);
        }else if(imc<=17){
            comentIMC.setText("Peso bajo. Necesario valorar signos de desnutrición");
            pesoIdeal.setText(PIT);
            MainActivity.setPesobajo(true);
            MainActivity.setPesonormal(false);
            MainActivity.setSobrepeso(false);
            MainActivity.setObesidad1(false);
            MainActivity.setObesidad2(false);
            MainActivity.setObesidad3(false);
        }
    }

    private void validacionPesos() {
        if(MainActivity.pesobajo){
            Toast.makeText(getActivity(), "true peso bajo", Toast.LENGTH_SHORT).show();
            MainActivity.setPesonormal(false);
            MainActivity.setSobrepeso(false);
            MainActivity.setObesidad1(false);
            MainActivity.setObesidad2(false);
            MainActivity.setObesidad3(false);
        }else if(MainActivity.pesonormal){
            Toast.makeText(getActivity(), "true peso normal", Toast.LENGTH_SHORT).show();
            MainActivity.setPesobajo(false);
            MainActivity.setSobrepeso(false);
            MainActivity.setObesidad1(false);
            MainActivity.setObesidad2(false);
            MainActivity.setObesidad3(false);
        }else if(MainActivity.sobrepeso){
            Toast.makeText(getActivity(), "true peso sobrepeso", Toast.LENGTH_SHORT).show();
            MainActivity.setPesobajo(false);
            MainActivity.setPesonormal(false);
            MainActivity.setObesidad1(false);
            MainActivity.setObesidad2(false);
            MainActivity.setObesidad3(false);
        }else if(MainActivity.obesidad1){
            Toast.makeText(getActivity(), "true peso ob1", Toast.LENGTH_SHORT).show();
            MainActivity.setPesobajo(false);
            MainActivity.setPesonormal(false);
            MainActivity.setSobrepeso(false);
            MainActivity.setObesidad2(false);
            MainActivity.setObesidad3(false);
        }else if(MainActivity.obesidad2){
            Toast.makeText(getActivity(), "true peso ob2", Toast.LENGTH_SHORT).show();MainActivity.setPesobajo(false);
            MainActivity.setPesobajo(false);
            MainActivity.setPesonormal(false);
            MainActivity.setSobrepeso(false);
            MainActivity.setObesidad1(false);
            MainActivity.setObesidad3(false);
        } else if(MainActivity.obesidad3){
            Toast.makeText(getActivity(), "true peso ob3", Toast.LENGTH_SHORT).show();
            MainActivity.setPesobajo(false);
            MainActivity.setPesonormal(false);
            MainActivity.setSobrepeso(false);
            MainActivity.setObesidad1(false);
            MainActivity.setObesidad2(false);

        }
    }

    @Override
    public void onStart() {
        super.onStart();

        CheckBox boxasma = (CheckBox)getActivity().findViewById(R.id.checkasma);
        boxasma.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    MainActivity.setAsma(true);
                } else {
                    MainActivity.setAsma(false);
                }
            }
        });
        CheckBox boxarrit = (CheckBox)getActivity().findViewById(R.id.checkarritmia);
        boxarrit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    MainActivity.setArritmia(true);
                } else {
                    MainActivity.setArritmia(false);
                }
            }
        });
        CheckBox boxdiab = (CheckBox)getActivity().findViewById(R.id.checkdiabetes);
        boxdiab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    MainActivity.setDiabetes(true);
                } else {
                    MainActivity.setDiabetes(false);
                }
            }
        });
        CheckBox boxhiper = (CheckBox)getActivity().findViewById(R.id.checkhipertension);
        boxhiper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    MainActivity.setHipertension(true);
                } else {
                    MainActivity.setHipertension(false);
                }
            }
        });
        CheckBox boxcard = (CheckBox)getActivity().findViewById(R.id.checkcardio);
        boxcard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    MainActivity.setCardiov(true);
                } else {
                    MainActivity.setCardiov(false);
                }
            }
        });

        Button update = (Button)getActivity().findViewById(R.id.infoButton);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Busca el contenido de los EditText
                pesoActInfoFrag  = (EditText)getActivity().findViewById(R.id.peso);
                EstatActInfoFrag = (EditText)getActivity().findViewById(R.id.edtestatura);

//Paso de EditText a String
                String pesoActInfoFragInt = pesoActInfoFrag.getText().toString();
                String EstatActInfoFragInt = EstatActInfoFrag.getText().toString();

//Cambio de String a Double
                Integer peso = Integer.valueOf(pesoActInfoFragInt);
                Double estat = Double.valueOf(EstatActInfoFragInt);

                //Formula
                imc = (peso/Math.pow(estat,2));
                pesoIdealText = CalcPesoIdeal(21.0,estat);

                //Calcular IMC
                DecimalFormat df = new DecimalFormat("#.###");
                DecimalFormat pf = new DecimalFormat("#.###");
                imc = Double.valueOf(df.format(imc));
                pesoIdealText = Double.valueOf(df.format(pesoIdealText));
                IMC = String.valueOf(imc);
                PIT = String.valueOf(pesoIdealText);

                //Busca el contenido de los TextView para settear
                pesoActIdealFrag = (TextView)getActivity().findViewById(R.id.pesoAct);
                IMCActIdealaFrag = (TextView)getActivity().findViewById(R.id.IMC);
                comentIMC = (TextView)getActivity().findViewById(R.id.infoIMC);
                pesoIdeal = (TextView)getActivity().findViewById(R.id.pesoIdeal);

                setts(PIT,imc);

                //Settea los contenidos en sus respectivos campos
                pesoActIdealFrag.setText(pesoActInfoFrag.getText());
                IMCActIdealaFrag.setText(IMC);

//            Creo que ya no es necesario, se utilizo antes para verificar unas cosas
//                validacionPesos();

                //Notificacion
                TextView msg = (TextView)getActivity().findViewById(R.id.updateNot);
                Toast.makeText(getActivity(), msg.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
