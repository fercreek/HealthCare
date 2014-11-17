package info.androidhive.tabsswipe.adapter;

import info.androidhive.tabsswipe.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TipFragment extends Fragment {
    private ListView lista2;
    ArrayList<Lista_entrada> datos2 = new ArrayList<Lista_entrada>();

    @Override
    public void onStart() {
        super.onStart();
        datos2.clear();

        if (MainActivity.sobrepeso || MainActivity.obesidad1 ||MainActivity.obesidad2 ||MainActivity.obesidad3){
            datos2.add(new Lista_entrada(R.drawable.caminar,"Personas con sobrepeso",
                    "Controla lo que comes evita las grasas\n" +
                    "Comienza caminando siempre 15 minutos\n" +
                    "No esperes resultados al instante, tardaran pero llegaran.\n" +
                    "Vamos, Tu puedes!\n" +
                    "Intenta comer mas verduras."));
        }else if (MainActivity.pesonormal){
            datos2.add(new Lista_entrada(R.drawable.caminar,"Personas con peso regular",
                    "Se constante, haz  una actividad diaria\n" +
                    "Siempre da un esfuerzo extra\n" +
                    "Evita tomar ingerir  bebidas alcohólicas\n" +
                    "Ten una dieta balanceada"));
        }else if (MainActivity.pesobajo) {
            datos2.add(new Lista_entrada(R.drawable.caminar, "Personas delgadas",
                    "Come más carne para evitar enfermedades\n" +
                    "Toma suplementos, pero pide recomendación de un especialista\n" +
                    "Desayuna algo que te de energía.\n" +
                    "Has un poco más de repeticiones para ganar más masa muscular"));
        }
        if (MainActivity.asma) {
            datos2.add(new Lista_entrada(R.drawable.caminar, "Para personas asmáticas",
                    "Esfuérzate pero hasta que te sientas bien, no hagas  sobresfuerzos\n" +
                    "Trata de tener tu medicina por si pasa una emergencia.\n" +
                    "Has poco a poco las actividades de cardiovasculares.\n" +
                    "Come alimentos alto en energía"));
        }
        if (MainActivity.arritmia) {
            datos2.add(new Lista_entrada(R.drawable.caminar, "Para personas con reumatismo",
                    "Evita ingerir sustancias como  café, alcohol y como el tabaco.\n" +
                    " Controla tu estrés.\n" +
                    "No comas demasiado grasas y azucares.\n" +
                    "Se constante con la actividad física"));
        }
        if (MainActivity.hipertension) {
            datos2.add(new Lista_entrada(R.drawable.caminar, "Para personas asmáticas",
                    "Controle su peso\n" +
                    "Reduzca el consumo de sal y coma alimentos saludables.\n" +
                    "Evite el consumo excesivo de alcohol.\n" +
                    "Tome sus medicamentos"));
        }
        if (MainActivity.cardiov) {
            datos2.add(new Lista_entrada(R.drawable.caminar, "Para personas asmáticas",
                    "Sigue una dieta balanceada.\n" +
                    "Aumenta el consumo de frutas y verduras\n" +
                    "No abusar de las bebidas alcohólicas y dejar el tabaco por completo.\n" +
                    "Mantener controlados los niveles de colesterol y glucosa."));
        }
        if (MainActivity.diabetes) {
            datos2.add(new Lista_entrada(R.drawable.caminar, "Para personas asmáticas",
                    "No comer tantos alimentos con azúcar ni grasas\n" +
                    "Come mucho carbohidratos para tener energía\n" +
                    "Toma la insulina para mantenerte activo.\n" +
                    "Trata de comer a la misma hora todos los días"));
        }

        lista2 = (ListView)getActivity().findViewById(R.id.listView2);
        lista2.setAdapter(new Lista_adaptador(this.getActivity(), R.layout.entrada, datos2) {
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
                }
            }
        });

        lista2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion);

                CharSequence texto = elegido.get_textoDebajo();
                Toast toast = Toast.makeText(TipFragment.this.getActivity(), texto, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tip, container, false);

		return rootView;
	}


}
