package com.example.applicationimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.applicationimc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button botaoCalcular = findViewById(R.id.button_calcular);

        TextView resultadoImc = findViewById(R.id.text_resultado_calculo);
        
        TextView resultadoClassificacao = findViewById(R.id.text_resultado_classificacao);
        
        botaoCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calcular();
            }

            private void calcular() {
                EditText altura = findViewById(R.id.input_altura);
                EditText peso = findViewById(R.id.input_peso);

                double valorAltura =  (Double.parseDouble(altura.getText().toString()));
                double valorPeso =   (Double.parseDouble(peso.getText().toString()));
                double valorImc = valorPeso / (valorAltura * valorAltura);

                resultadoImc.setText(String.valueOf(valorImc));
                resultadoImc.setVisibility(View.VISIBLE);

                String text1 = "Acima do Peso";
                String text2 = "Peso Ideal";
                String text3 = "Abaixo do Peso";

                if (valorImc < 18.5){
                    resultadoClassificacao.setText(String.valueOf(text3));
                    resultadoClassificacao.setVisibility(View.VISIBLE);
                }else if(valorImc < 25){
                    resultadoClassificacao.setText(String.valueOf(text2));
                    resultadoClassificacao.setVisibility(View.VISIBLE);
                }else{
                    resultadoClassificacao.setText(String.valueOf(text1));
                    resultadoClassificacao.setVisibility(View.VISIBLE);
                }


            }
        });
    }
}