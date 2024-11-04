package com.ivanmayta.treinoparaprova;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSalario;
    private EditText editTextDeducoes;

    private Button buttonCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editTextSalario = findViewById(R.id.editTextSalario);
        editTextDeducoes = findViewById(R.id.editTextDeducoes);

        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);


        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String salario = editTextSalario.getText().toString();
                String deducoes = editTextDeducoes.getText().toString();

                if(salario.isEmpty() || deducoes.isEmpty()){
                    Toast.makeText(MainActivity.this, "Por favor, insira valores validos", Toast.LENGTH_SHORT).show();
                    return;
                }

                double salarioDouble = Double.parseDouble(salario);
                double deducoesDouble = Double.parseDouble(deducoes);

                double aliquota;
                double parcela;
                double um = 22847.76;

                if (salarioDouble <= 22847.76) {
                    aliquota = 1;
                    parcela = 0;
                } else if (salarioDouble <= 33919.80){
                    aliquota = 0.075;
                    parcela = 1713.58;
                } else if(salarioDouble <= 45012.60) {
                    aliquota = 0.15;
                    parcela = 4257.57;
                } else if(salarioDouble <= 55976.16) {
                    aliquota = 0.225;
                    parcela = 7633.51;
                } else {
                    aliquota = 0.275;
                    parcela = 10432.32;
                }

                double resultadoImposto = (salarioDouble - deducoesDouble) * aliquota - parcela;
                String resultadoImpostoStr = Double.toString(resultadoImposto);


                if (resultadoImposto > 0){
                    textViewResultado.setText("Imposto a pagar: R$" + resultadoImpostoStr);
                } else {
                    textViewResultado.setText("Voce nao tem imposto a pagar");
                }



            }
        });




    }
}