package sistemas.unc.edu.pe.myapplicationwwww;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Declaramos los objetos de ingreso de datos
    EditText etRadio, etAltura;
    TextView tvVolumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
      ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
           Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Inicilizar los objetos de tipo visuales
        etRadio =findViewById(R.id.et_radio);
        etAltura = findViewById(R.id.et_altura);
        tvVolumen= findViewById(R.id.tvRespuesta);
        tvVolumen.setText("");

    }

    public void CalcularVolumen (View boton){
        if(Validar()) //Si validar retorna true
            return;
        //leer los datos en los ediText
        double radio = Double.valueOf(etRadio.getText().toString());
        double altura = Double.valueOf(etAltura.getText().toString());
        double volumen = Math.PI * Math.pow(radio, 2) * altura;

                tvVolumen.setText(volumen + "");

    }

    private boolean Validar() {
        if(etRadio.getText().toString().trim().isEmpty()){
            etRadio.setError("Campo obligatorio para el radio de la base");
            etRadio.requestFocus();
            return  true;
        }

        if(etAltura.getText().toString().trim().isEmpty()){
            etAltura.setError("Campo obligatorio para el volumen del cilindro");
            etAltura.requestFocus();
            return  true;
        }

        return false;
    }
}