package org.courcera.reciclerview.opciones;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.courcera.reciclerview.R;

public class ActivityContacto extends AppCompatActivity {

    EditText etContactoNombre;
    EditText etContactoCorreo;
    EditText etContactoMensaje;
    Button btnEnviarComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etContactoNombre = (EditText) findViewById(R.id.etContactoNombre);
        etContactoCorreo = (EditText) findViewById(R.id.etContactoCorreo);
        etContactoMensaje = (EditText) findViewById(R.id.etContactoMensaje);
        btnEnviarComentario = (Button) findViewById(R.id.btnEnviarComentario);
        btnEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void enviarMail(View v){
        String email = etContactoCorreo.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("text/plain");
        startActivity(Intent.createChooser(emailIntent,"Email"));
    }
}
