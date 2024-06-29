
package br.edu.utfpr.calculaimc;
import br.edu.utfpr.calculoimc.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private TextView tvResultado;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById( R.id.etPeso );
        etAltura = findViewById( R.id.etAltura );
        tvResultado = findViewById( R.id.tvResultado );
        btLimpar = findViewById( R.id.btLimpar );

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btLimparOnClick();
            }
        });

    } //fim do onCreate()

    public void btCalcularOnClick( View v ) {

        //entrada
        if ( etPeso.getText().toString().isEmpty() ) {
            etPeso.setError( "Campo peso deve ser preenchido." );
            etPeso.requestFocus();
            return;
        }

        if ( etAltura.getText().toString().isEmpty() ) {
            etAltura.setError( "Campo altura deve ser preenchido." );
            etAltura.requestFocus();
            return;
        }

        double resultado = Double.parseDouble( etPeso.getText().toString() ) / Math.pow( Double.parseDouble( etAltura.getText().toString() ), 2 );

        DecimalFormat df = new DecimalFormat( "0.00" );
        tvResultado.setText( df.format( resultado ) );
    }

    private void btLimparOnClick() {
        etPeso.setText( "" );
        etAltura.setText( "" );
        tvResultado.setText( "0.0" );
        etPeso.requestFocus();
    }


} //fim da MainActivity