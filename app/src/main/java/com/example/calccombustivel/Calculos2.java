package com.example.calccombustivel;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculos2 extends AppCompatActivity {
    double localPagobomba;
    double localPrecoBomba;
    DecimalFormat df = new DecimalFormat("0.00");
    TodosOSCalculos objCalculos = new TodosOSCalculos();
    AlertDialog.Builder alerta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alerta = new AlertDialog.Builder(Calculos2.this);
        setContentView(R.layout.activity_calculos2);
        final EditText edtEntrada3 = findViewById(R.id.edtEntrada3);
        final EditText edtEntrada4 = findViewById(R.id.edtEntrada4);
        final Button btnCalcular2 = findViewById(R.id.btnCalcular2);
        final TextView txtSaida1 = findViewById(R.id.txtSaida1);

        final Button btnLimpar2 = findViewById(R.id.btnLimpar2);

        btnCalcular2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if((edtEntrada3.getText().toString().isEmpty() == true)||(edtEntrada4.getText().toString().isEmpty())){
                    alerta.setTitle("Informação!").setMessage("É necessário que os dois campos estejam preenchidos!").setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                          if(edtEntrada3.getText().toString().isEmpty() != true)
                              edtEntrada4.requestFocus();
                          else
                              edtEntrada3.requestFocus();
                        }
                    }).show();
                }
                else{
                    localPagobomba = Float.parseFloat(String.valueOf(edtEntrada3.getText().toString()));
                    localPrecoBomba = Float.parseFloat(String.valueOf(edtEntrada4.getText().toString()));

                    objCalculos.setLitrosAbastecidos(localPagobomba,localPrecoBomba);
                    txtSaida1.setText(df.format(objCalculos.getTotal())+" lts");
                }
            }
        });
        btnLimpar2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                localPagobomba = 0;
                localPrecoBomba = 0;
                edtEntrada3.setText("");
                edtEntrada4.setText("");
                txtSaida1.setText(df.format(0)+" lts");
            }
        });


    }
}
