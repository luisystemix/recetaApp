package josedlujan.app.recetas.com.recetasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecetaActivity extends AppCompatActivity {
    EditText id,nombre,personas,descripcion,preparacion;
    Button agregar;
    Data data;
    Receta receta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_receta);

        id = (EditText) findViewById(R.id.id);
        nombre = (EditText) findViewById(R.id.nombre);
        personas = (EditText) findViewById(R.id.personas);
        descripcion = (EditText) findViewById(R.id.descripcion);
        preparacion = (EditText) findViewById(R.id.preparacion);
        agregar = (Button) findViewById(R.id.agregar);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               receta = new Receta(
                        id.getText().toString(),
                        nombre.getText().toString(),
                        Integer.valueOf(personas.getText().toString()),
                        descripcion.getText().toString(),
                        preparacion.getText().toString(),
                        "loquesea",
                        0);





                /*receta.setId(id.getText().toString());
                receta.setNombre(nombre.getText().toString());
                receta.setPersonas(Integer.valueOf(personas.getText().toString()));
                receta.setDescripcion(descripcion.getText().toString());
                receta.setPreparacion(preparacion.getText().toString());
                receta.setImage("imagenloqusea");
                receta.setFav(0);*/
                data = new Data(getApplicationContext());
                data.open();
                data.insertReceta(receta);
                Toast.makeText(getApplicationContext(),"Se agrego correctamente",Toast.LENGTH_LONG).show();


            }
        });
    }
}
