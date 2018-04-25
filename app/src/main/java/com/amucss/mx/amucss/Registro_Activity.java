package com.amucss.mx.amucss;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.amucss.mx.amucss.entities.Registro;

public class Registro_Activity extends AppCompatActivity {

    Button bt_aviso;
    Button btn_registra;
    TextInputEditText var_usuario;
    TextInputEditText var_apat;
    TextInputEditText var_amat;
    TextInputEditText var_edad;
    TextInputEditText var_tel;
    TextInputEditText var_email;
    TextInputEditText var_clave;
    TextInputEditText var_cclave;
    RadioGroup radios;
    RadioButton hombre;
    RadioButton mujer;
    RadioButton si;
    RadioButton no;
    ImageView imageView;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // Rota horizontal
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Rota Vertical
        setContentView(R.layout.activity_registro_);

        context = this;
        bt_aviso = (Button)findViewById(R.id.bt_aviso);
        btn_registra = (Button)findViewById(R.id.btn_registra);
        var_usuario = (TextInputEditText)findViewById(R.id.var_usuario);
        var_apat = (TextInputEditText)findViewById(R.id.var_apat);
        var_amat = (TextInputEditText)findViewById(R.id.var_amat);
        var_edad = (TextInputEditText)findViewById(R.id.var_edad);
        var_tel = (TextInputEditText)findViewById(R.id.var_tel);
        var_email = (TextInputEditText)findViewById(R.id.var_email);
        var_clave = (TextInputEditText)findViewById(R.id.var_clave);
        var_cclave = (TextInputEditText)findViewById(R.id.var_cclave);
        radios = (RadioGroup)findViewById(R.id.radios);
        hombre = (RadioButton)findViewById(R.id.hombre);
        mujer = (RadioButton)findViewById(R.id.mujer);
        si = (RadioButton)findViewById(R.id.si);
        no = (RadioButton)findViewById(R.id.no);
        imageView = (ImageView)findViewById(R.id.imageView);

        //Evento de Radios Cambiar imagen
        radios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int Id) {
                switch (Id){
                    case R.id.hombre:
                        imageView.setImageResource(R.drawable.hombre);
                        break;
                    case R.id.mujer:
                        imageView.setImageResource(R.drawable.mujer);
                        break;
                }
            }
        });

        // Acepta el Aviso de Privacidad
        bt_aviso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Registro_Activity.this);
                builder.setTitle("Aviso de Privacidad");
                builder.setMessage("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");
                builder.setIcon(R.drawable.block);
                builder.setPositiveButton("ACEPTAR",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Debe Guardar Que Acepta el Aviso de Privacidad
                            }
                        });

                builder.setNegativeButton("CANCELAR",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                builder.show();


            }
        });



        // Guarda toda la Informacion
        btn_registra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(var_usuario.getText().toString().equals("") || var_usuario.getText().toString().equals(null)) {
                    Toast.makeText(Registro_Activity.this, "El Campo Nombre No Puede ir Vacío", Toast.LENGTH_SHORT).show();
                } else
                if(var_apat.getText().toString().equals("") || var_apat.getText().toString().equals(null)) {
                    Toast.makeText(Registro_Activity.this, "El Campo Apellido Paterno No Puede ir Vacío", Toast.LENGTH_SHORT).show();
                } else
                if(var_edad.getText().toString().equals("") || var_edad.getText().toString().equals(null)) {
                    Toast.makeText(Registro_Activity.this, "El Campo Edad No Puede ir Vacío", Toast.LENGTH_SHORT).show();
                } else
                if(var_clave.getText().toString().equals("") || var_clave.getText().toString().equals(null)) {
                    Toast.makeText(Registro_Activity.this, "El Campo Clave No Puede ir Vacío", Toast.LENGTH_SHORT).show();
                } else
                if(var_cclave.getText().toString().equals("") || var_cclave.getText().toString().equals(null)) {
                    Toast.makeText(Registro_Activity.this, "El Campo Confirmar No Puede ir Vacío", Toast.LENGTH_SHORT).show();
                } else {


                    try {
                        com.amucss.mx.amucss.entities.Registro registro = new Registro();
                        registro.setNombre(var_usuario.getText().toString());
                        registro.setApat(var_apat.getText().toString());
                        registro.setAmat(var_amat.getText().toString());
                        if (hombre.isChecked()) {
                            registro.setSexo(1); // Hombre
                        } else if (mujer.isChecked()) {
                            registro.setSexo(0); // Mujer
                        }
                        int edad = Integer.parseInt(var_edad.getText().toString());
                        registro.setEdad(edad);
                        //int tel = Integer.parseInt();
                        registro.setTelefono(var_tel.getText().toString());
                        registro.setEmail(var_email.getText().toString());
                        if (si.isChecked()) {
                            registro.setSocio(1); // Si
                        } else if (no.isChecked()) {
                            registro.setSocio(0); // No
                        }

                        if (var_clave.getText().toString().equals(var_cclave.getText().toString())) {
                            registro.setClave(var_clave.getText().toString());
                            com.amucss.mx.amucss.business.Registro.Insert(context, registro);
                            Toast.makeText(context, "Registro Correcto", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(Registro_Activity.this, "Las Claves Escritas No Son Iguales", Toast.LENGTH_SHORT).show();
                        }

                     } catch (Exception e) {
                        e.getMessage();
                    }


                }
            }
        });

    }

}
