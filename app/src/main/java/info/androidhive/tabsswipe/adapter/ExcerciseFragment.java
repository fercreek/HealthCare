package info.androidhive.tabsswipe.adapter;

import info.androidhive.tabsswipe.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExcerciseFragment extends Fragment {
    private ListView lista;
    ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();

    @Override
    public void onStart() {
        super.onStart();
        datos.clear();

        if (MainActivity.asma && MainActivity.cardiov && MainActivity.diabetes && MainActivity.hipertension && MainActivity.arritmia){
            datos.add(new Lista_entrada(R.drawable.caminar, "Caminar a paso ligero","Tratar de mantener el paso 5 a 10 minutos a una intensidad de entre 4-5 al principio y aumentaremos cada semana en 1 minuto hasta llegar a unos 15 minutos a esa misma intensidad."));

        }else{
            if (MainActivity.asma || MainActivity.cardiov || MainActivity.diabetes || MainActivity.hipertension || MainActivity.arritmia){
                datos.add(new Lista_entrada(R.drawable.caminar, "Caminar a paso ligero","Tratar de mantener el paso 5 a 10 minutos a una intensidad de entre 4-5 al principio y aumentaremos cada semana en 1 minuto hasta llegar a unos 15 minutos a esa misma intensidad."));
                if (MainActivity.asma){
                    if (MainActivity.pesonormal){
                        datos.add(new Lista_entrada(R.drawable.bailar, "Bailar","Bailar en un tiempo de 15 minutos a una intensidad baja ir aumentando 5 minutos el tiempo cada semana"));
                        datos.add(new Lista_entrada(R.drawable.bici, "Andar en bicicleta","Practicar ciclismo a una intensidad moderada durante 15 min, ir aumentando 5 minutos el tiempo cada semana"));
                    }
                }
                if (MainActivity.hipertension){
                    if (MainActivity.sobrepeso || MainActivity.pesonormal){
                        datos.add(new Lista_entrada(R.drawable.bici_estacionaria, "Bicicleta estacionaria", "Realizar 3 secuencias de 5 minutos cada una a una velocidad baja."));
                    }
                }

                if (MainActivity.arritmia || MainActivity.diabetes){
                    datos.add(new Lista_entrada(R.drawable.bici_estacionaria, "Bicicleta estacionaria","Tratar de mantener el paso 5 a 10 minutos a una intensidad de entre 4-5 al principio y aumentaremos cada semana en 1 minuto hasta llegar a unos 15 minutos a esa misma intensidad."));
                    datos.add(new Lista_entrada(R.drawable.eliptica, "elíptica","Realizar 5 secuencias de 5 minutos cada una a una velocidad baja, ir aumentando la velocidad cada 10 dias.."));
                    datos.add(new Lista_entrada(R.drawable.trotar, "Trotar","Trotar a una velocidad baja durante 15 minutos, ir aumentando el tiempo cada semana.."));
                    datos.add(new Lista_entrada(R.drawable.nadar, "Nadar","Nadar durante 15 minutos e ir aumentando cada semana."));
                    datos.add(new Lista_entrada(R.drawable.paloma, "Palomas","Realizar 3 secuencias de 10 palomas."));
                    if (MainActivity.diabetes){
                        datos.add(new Lista_entrada(R.drawable.abdominales, "abdominales","Realizar 3 secuencias de 20 abdominales."));
                    }
                }
            }else{
                datos.add(new Lista_entrada(R.drawable.caminar, "Caminar a paso ligero","Tratar de mantener el paso 5 a 10 minutos a una intensidad de entre 4-5 al principio y aumentaremos cada semana en 1 minuto hasta llegar a unos 15 minutos a esa misma intensidad."));
                if (MainActivity.pesonormal || MainActivity.sobrepeso ){
                    datos.add(new Lista_entrada(R.drawable.bici_estacionaria, "Bicicleta estacionaria","Tratar de mantener el paso 5 a 10 minutos a una intensidad de entre 4-5 al principio y aumentaremos cada semana en 1 minuto hasta llegar a unos 15 minutos a esa misma intensidad."));
                    datos.add(new Lista_entrada(R.drawable.eliptica, "elíptica","Realizar 5 secuencias de 5 minutos cada una a una velocidad baja, ir aumentando la velocidad cada 10 dias.."));
                    datos.add(new Lista_entrada(R.drawable.trotar, "Trotar","Trotar a una velocidad baja durante 15 minutos, ir aumentando el tiempo cada semana.."));
                    datos.add(new Lista_entrada(R.drawable.nadar, "Nadar","Nadar durante 15 minutos e ir aumentando cada semana."));
                }
                if (MainActivity.pesonormal){
                    datos.add(new Lista_entrada(R.drawable.paloma, "Palomas","Realizar 3 secuencias de 10 palomas."));
                    datos.add(new Lista_entrada(R.drawable.caminar, "correr en el lugar","Realizar 5 secuencias de 20 levantamientos de rodillas."));
                    datos.add(new Lista_entrada(R.drawable.lagartijas, "Lagartija","Realizar 3 secuencias de 15 lagartijas."));
                    datos.add(new Lista_entrada(R.drawable.abdominales, "abdominales","Realizar 3 secuencias de 20 abdominales."));
                }

            }
        }

        lista = (ListView)getActivity().findViewById(R.id.listView);
        lista.setAdapter(new Lista_adaptador(this.getActivity(), R.layout.entrada, datos) {
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

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion);

                CharSequence texto = elegido.get_textoDebajo();
                Toast toast = Toast.makeText(ExcerciseFragment.this.getActivity(), texto, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }




    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_exer, container, false);

		return rootView;
	}
}
