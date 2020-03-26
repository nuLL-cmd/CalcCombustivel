package com.example.calccombustivel;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class frmCalculos extends AppCompatActivity {
    TodosOSCalculos objCalculos = new TodosOSCalculos();
    DecimalFormat df = new DecimalFormat("0.00");
    AlertDialog.Builder alerta;
    double localRodado;
    double localAbastecido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alerta = new AlertDialog.Builder(this);
        setContentView(R.layout.activity_frm_calculos);
        final Button btnCalcular = findViewById(R.id.btnCalcular);
        final EditText edtEntrada1 = findViewById(R.id.edtEntrada1);
        final EditText edtEntrada2 = findViewById(R.id.edtEntrada2);
        final Button btnLimpar = findViewById(R.id.btnLimpar);
        final TextView txtSaida = findViewById(R.id.txtSaida);

        btnCalcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if((edtEntrada1.getText().toString().isEmpty() == true)||(edtEntrada2.getText().toString().isEmpty() == true)){
                    alerta.setTitle("Informação!").setMessage("É necessário que os dois campos estejam preenchidos!").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(edtEntrada1.getText().toString().isEmpty() != true)
                                edtEntrada2.requestFocus();
                            else
                                edtEntrada1.requestFocus();
                        }
                    }).show();
                }
                else {
                    localRodado = Float.parseFloat(String.valueOf(edtEntrada1.getText().toString()));
                    localAbastecido = Float.parseFloat(String.valueOf(edtEntrada2.getText().toString()));
                    objCalculos.setKmLitro(localRodado,localAbastecido);
                    txtSaida.setText(df.format(objCalculos.getTotal())+" Km/L");
                }
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                localAbastecido = 0;
                localRodado = 0;
                edtEntrada1.setText("");
                edtEntrada2.setText("");
                txtSaida.setText(df.format(0)+" Km/L");
            }
        });

    }
}
