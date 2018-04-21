package com.amucss.mx.amucss;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button Registro; // Registro
    Button Acces; // Acces con clave
    Button Español; // Español
    Button Nahuatl; // Nahuatl
    Button Otomi; // Otomi
    Button Mixteco; // Mixteco
    Button Zapoteco; // Zapoteco
    FloatingActionButton fl_salir; // Boton salir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mantiene la pantalla Full
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Rotacion de pantalla y bloqueo
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // Rota horizontal
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Rota Vertical

        setContentView(R.layout.activity_main);

        // Tendra un evento de intent
        Registro = (Button)findViewById(R.id.button1);
        Acces = (Button)findViewById(R.id.button2);
        // Estos botones controlan el Idioma
            Español = (Button)findViewById(R.id.button3);
            Nahuatl = (Button)findViewById(R.id.button4);
            Otomi = (Button)findViewById(R.id.button5);
            Mixteco = (Button)findViewById(R.id.button6);
            Zapoteco = (Button)findViewById(R.id.button7);
        // Simplemente Cierra la pantalla
        fl_salir = (FloatingActionButton)findViewById(R.id.fl_salir);

        // Envia un intent a la pantalla de Registro
        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Registro_Activity.class);
                startActivity(intent);
            }
        });

            // Agregar aqui los demas eventos en orden Salir hasta abajo
        Acces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("CLAVE");
                builder.setMessage("Ingrese su Clave");

                final EditText input = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                builder.setView(input);
                builder.setIcon(R.drawable.key);



                builder.setPositiveButton("ACEPTAR",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                if(input.getText().toString().equals("") || input.getText().toString().equals(null)) {
                                    Toast.makeText(MainActivity.this, "Error Campo Clave Vacia", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, input.getText(), Toast.LENGTH_SHORT).show();
                                }

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

        fl_salir.setOnClickListener(new View.OnClickListener() { // Boton Salir
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }



}
