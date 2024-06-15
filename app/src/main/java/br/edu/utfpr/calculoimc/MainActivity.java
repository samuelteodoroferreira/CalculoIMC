package br.edu.utfpr.calculoimc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.utfpr.calculoimc.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAltura;
    private EditText editTextPeso;
    private Button buttonCalculate;
    private Button buttonClear; // Adicione esta linha
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAltura = findViewById(R.id.editTextAltura);
        editTextPeso = findViewById(R.id.editTextPeso);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonClear = findViewById(R.id.buttonClear); // Adicione esta linha
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateIMC();
            }
        });

        // Adicione o OnClickListener para o buttonClear dentro do onCreate
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparValues();
            }
        });
    }

    private void calculateIMC() {
        String alturaStr = editTextAltura.getText().toString();
        String pesoStr = editTextPeso.getText().toString();

        if (alturaStr.isEmpty() || pesoStr.isEmpty()) {
            Toast.makeText(this, "Por favor, insira altura e peso", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float altura = Float.parseFloat(alturaStr);
            float peso = Float.parseFloat(pesoStr);

            if (altura <= 0 || peso <= 0) {
                Toast.makeText(this, "Altura e peso devem ser maiores que zero", Toast.LENGTH_SHORT).show();
                return;
            }

            float imc = altura / (peso * peso);
            String imcResult = String.format("Seu IMC é: %.2f", imc);
            textViewResult.setText(imcResult);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparValues() {
        editTextAltura.setText("");
        editTextPeso.setText("");
        textViewResult.setText("");
    }
}
