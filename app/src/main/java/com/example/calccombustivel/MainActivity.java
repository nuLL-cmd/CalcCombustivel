package com.example.calccombustivel;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String menu[] = {"KM/ LITRO","LITROS ABASTECIDOS","CALC RESERVA"};
    ArrayAdapter<String> adaptador;
    ListView listaMenu ;
    AlertDialog.Builder alerta;
    Intent objIntent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaMenu = findViewById(R.id.listaMenu);

        adaptador = new ArrayAdapter<>(
                MainActivity.this,
                R.layout.personalizado,
                R.id.txtum,
                menu
        );
        listaMenu.setAdapter(adaptador);

        listaMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Toast.makeText(MainActivity.this,menu[position], Toast.LENGTH_SHORT).show();
                        objIntent = new Intent(getApplicationContext(),frmCalculos.class);
                        startActivity(objIntent);
                        break;
                    case 1:
                        objIntent = new Intent(getApplicationContext(),Calculos2.class);
                        startActivity(objIntent);
                        Toast.makeText(MainActivity.this,menu[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        objIntent = new Intent(getApplicationContext(),frmCalculos3.class);
                        startActivity(objIntent);
                        Toast.makeText(MainActivity.this,menu[position], Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void btnSobre(View v){
        alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setTitle("Sobre a Aplicação").setMessage("App Android Studio by nuLL...").setPositiveButton("Ok",null).show();
    }
}
