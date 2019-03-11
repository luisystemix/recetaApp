package josedlujan.app.recetas.com.recetasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrarActivity extends AppCompatActivity {
    EditText name, user,password,passwordv;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        name = (EditText) findViewById(R.id.name);
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        passwordv = (EditText) findViewById(R.id.passwordv);

        registrar = (Button) findViewById(R.id.registrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
