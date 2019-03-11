package josedlujan.app.recetas.com.recetasapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecetasActivity extends AppCompatActivity {
    RecyclerView recyclerRecetas;
    ArrayList<Receta> recetas;
    RecetasAdapter adapter;
    FloatingActionButton fab;



    //SQLITE
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);
        createData();


        recyclerRecetas = (RecyclerView) findViewById(R.id.recyclerrecetas);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerRecetas.setLayoutManager(linearLayoutManager);
        //adapter = new RecetasAdapter(this,recetas);
        //recyclerRecetas.setAdapter(adapter);
       update();

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                //Toast.makeText(getApplicationContext(),"Bye",Toast.LENGTH_LONG);
                //update();
                // data.deleteItem(viewHolder.getAdapterPosition());
               // String d = (viewHolder.getAdapterPosition());
               // String value = adapter.(viewHolder.getAdapterPosition()).getNombre();
               // viewHolder.getItemId(findViewById(R.id.nombre));

                int position = viewHolder.getAdapterPosition();
                RecetasAdapter adapter = (RecetasAdapter) recyclerRecetas.getAdapter();
                String value = adapter.recetas.get(position).getNombre();
                data.deleteItem(value);
                update();
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG).show();

                //String id = data.deleteItem();
                //data.deleteItem();
                //update();
            }
        };

        ItemTouchHelper itemTouchHelper  = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerRecetas);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecetasActivity.this,AddRecetaActivity.class);
                startActivity(intent);
            }
        });

        /*NORMAL SIN SQLITE
        recyclerRecetas = (RecyclerView) findViewById(R.id.recyclerrecetas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerRecetas.setLayoutManager(linearLayoutManager);
        adapter = new RecetasAdapter(this,recetas);
        recyclerRecetas.setAdapter(adapter);
         */


    }


    public void createData(){
        recetas = new ArrayList<>();
        recetas.add(new Receta("1",
                " Empardado",
                1,
                " Es un platiloo tipico para unas personas del norte del continente",
                " Ingredientes: Tomate, Lechuga, Jamon, Mayonesa, pepinillos,etc",
                " empardado",
                1));
        recetas.add(new Receta("2",
                " Sopa de lima",
                2,
                " Es un platiloo tipico para unas personas del norte del continente",
                " Ingredientes: Tomate, Lechuga, Jamon, Mayonesa, pepinillos,etc",
                " empardado",
                1));
        recetas.add(new Receta("3",
                "Atun",
                1,
                "Es un platiloo tipico para unas personas del norte del continente",
                "Ingredientes: Tomate, Lechuga, Jamon, Mayonesa, pepinillos,etc",
                "empardado",
                0));
        recetas.add(new Receta("4",
                " Pie",
                1,
                " Es un platiloo tipico para unas personas del norte del continente",
                " Ingredientes: Tomate, Lechuga, Jamon, Mayonesa, pepinillos,etc",
                " empardado",
                0));
        recetas.add(new Receta("5",
                " Pastel",
                2,
                " Es un platiloo tipico para unas personas del norte del continente",
                " Ingredientes: Tomate, Lechuga, Jamon, Mayonesa, pepinillos,etc",
                " empardado",
                0));

        //AGREGAMOS ESTO SQLITE
        data = new Data(this);
        data.open();
        data.insertRecetas(recetas);

    }
        //ESTO ES PARA SQLITE
    public List<Receta> getData(){
        List<Receta> recetas = data.getAll();
        return recetas;
    }

    @Override
    protected void onResume() {
        super.onResume();
       update();
    }
    public void update(){
        adapter=new RecetasAdapter(this,getData());
        recyclerRecetas.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.favs:
                adapter=new RecetasAdapter(this,data.getFav());
                recyclerRecetas.setAdapter(adapter);
                return  true;
            case R.id.personas:
                adapter = new RecetasAdapter(this,data.getPer(1));
                recyclerRecetas.setAdapter(adapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
