package josedlujan.app.recetas.com.recetasapp;

import android.content.Intent;
import android.nfc.TagLostException;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView user,password;
    Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (TextView) findViewById(R.id.user);
        password = (TextView) findViewById(R.id.password);
        iniciar = (Button) findViewById( R.id.iniciar);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RecetasActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       outState.putString("userS","Se salvo");
        outState.putString("passS","Se salvo");

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        user.setText("Hola");
        password.setText("Hola");
    }
}
