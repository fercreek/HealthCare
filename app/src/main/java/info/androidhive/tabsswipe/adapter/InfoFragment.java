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

import java.text.DecimalFormat;

public class InfoFragment extends Fragment {

    private EditText pesoActInfoFrag;
    private EditText EstatActInfoFrag;

    private TextView pesoActIdealFrag;
    private TextView EstatActIdealaFrag;
    private TextView IMCActIdealaFrag;
    private TextView comentIMC;
    private TextView pesoIdeal;

    private Double imc;
    private Double ideal;
    private Double pesoIdealText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_info, container, false);

        return rootView;
    }


    public Double CalcPesoIdeal(Double imc, Double estat){
        if(imc>=40){
            pesoIdealText = imc * Math.pow(estat,2);
        }else if(imc>=30){
            pesoIdealText = imc * Math.pow(estat,2);
        }else if(imc>=27){
            pesoIdealText = imc * Math.pow(estat,2);
        }else if(imc>=25){
            pesoIdealText = imc * Math.pow(estat,2);
        }else if(imc>=18){
            pesoIdealText = imc * Math.pow(estat,2);
        }else if(imc<18){
            pesoIdealText = imc * Math.pow(estat,2);
        }
        return pesoIdealText;
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

                //Busca el contenido de los EditText
                pesoActInfoFrag = (EditText)getActivity().findViewById(R.id.peso);
                EstatActInfoFrag =(EditText)getActivity().findViewById(R.id.edtestatura);

                String pesoActInfoFragInt = pesoActInfoFrag.getText().toString();
                String EstatActInfoFragInt = EstatActInfoFrag.getText().toString();

                Integer peso = new Integer(pesoActInfoFragInt).intValue();
                Double estat = new Double(EstatActInfoFragInt).doubleValue();

                //Formula
                imc = (peso/Math.pow(estat,2));
                pesoIdealText = CalcPesoIdeal(21.0,estat);

                //Calcular IMC
                DecimalFormat df = new DecimalFormat("#.###");
                DecimalFormat pf = new DecimalFormat("#.###");
                imc = Double.valueOf(df.format(imc));
                pesoIdealText = Double.valueOf(df.format(pesoIdealText));
                String IMC = String.valueOf(imc);
                String PIT = String.valueOf(pesoIdealText);

                //Calcular Peso Ideal

                //Busca el contenido de los TextView para settear
                pesoActIdealFrag = (TextView)getActivity().findViewById(R.id.pesoAct);
                IMCActIdealaFrag = (TextView)getActivity().findViewById(R.id.IMC);
                comentIMC = (TextView)getActivity().findViewById(R.id.infoIMC);
                pesoIdeal = (TextView)getActivity().findViewById(R.id.pesoIdeal);

                if(imc>=40){
                    comentIMC.setText("Obesidad grado III Extrema o Mórbida. " +
                            "Riesgo relativo extremadamente alto para el desarrollo " +
                            "de enfermedades cardiovasculares");
                    pesoIdeal.setText(PIT);
                }else if(imc>=30){
                    comentIMC.setText("Obesidad grado II. Riesgo relativo muy alto para " +
                            "el desarrollo de enfermedades cardiovasculares");
                    pesoIdeal.setText(PIT);
                }else if(imc>=27){
                    comentIMC.setText("Obesidad grado I. Riesgo relativo alto para desarrollar " +
                            "enfermedades cardiovasculares");
                    pesoIdeal.setText(PIT);
                }else if(imc>=25){
                    comentIMC.setText("Sobrepeso");
                    pesoIdeal.setText(PIT);
                }else if(imc>=18){
                    comentIMC.setText("Normal");
                    pesoIdeal.setText(PIT);
                }else if(imc<=17){
                    comentIMC.setText("Peso bajo. Necesario valorar signos de desnutrición");
                    pesoIdeal.setText(PIT);
                }


                //Settea los contenidos en sus respectivos campos

                pesoActIdealFrag.setText(pesoActInfoFrag.getText());
                IMCActIdealaFrag.setText(IMC);
            }
        });
    }
}
