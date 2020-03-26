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

public class frmCalculos3 extends AppCompatActivity {
    //criação dos objetos de classe para utilitarios na aplicação
    DecimalFormat df = new DecimalFormat("0.00");
    TodosOSCalculos objCalculos = new TodosOSCalculos();
    AlertDialog.Builder alerta;
    //-----------------------------------
    double localCapTanque;
    double localLitrosAbastecidos;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alerta = new AlertDialog.Builder(frmCalculos3.this);
        setContentView(R.layout.activity_frm_calculos3);
        //criação dos objetos graficos no formulario
        final Button btnCalcular3 = findViewById(R.id.btnCalcular3);
        final TextView txtSaida2 = findViewById(R.id.txtSaida2);
        final EditText edtEntrada5 = findViewById(R.id.edtEntrada5);
        final EditText edtEntrada6 = findViewById(R.id.edtEntrada6);
        final Button btnLimpar3 = findViewById(R.id.btnLimpar3);
        //-----------
        //Evento click no botao calcular
        btnCalcular3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                if ((edtEntrada5.getText().toString().isEmpty() == true)||(edtEntrada6.getText().toString().isEmpty() == true)){
                    alerta.setTitle("Informação!").setMessage("É necessário que os dois campos estejam preenchidos!").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(edtEntrada5.getText().toString().isEmpty() != true)
                                edtEntrada6.requestFocus();
                            else
                                edtEntrada5.requestFocus();
                        }
                    }).show();
                }
                else{
                    localCapTanque = Float.parseFloat(String.valueOf(edtEntrada5.getText().toString()));
                    localLitrosAbastecidos = Float.parseFloat(String.valueOf(edtEntrada6.getText().toString()));

                    objCalculos.setReserva(localCapTanque,localLitrosAbastecidos);
                    txtSaida2.setText(df.format(objCalculos.getTotal())+" lts");
                }
            }
        });
        //evento click no botao limpar
        btnLimpar3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                localCapTanque = 0;
                localLitrosAbastecidos = 0;
                edtEntrada5.setText("");
                edtEntrada6.setText("");
                txtSaida2.setText(df.format(0)+" lts");
            }
        });
    }
}
