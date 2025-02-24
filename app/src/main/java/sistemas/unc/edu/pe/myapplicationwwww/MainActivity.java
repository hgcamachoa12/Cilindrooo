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

import Modelo.Cilindro;

public class MainActivity extends AppCompatActivity {
    EditText etRadio, etAltura;
    TextView tvRespuesta;


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

        //inicializamos los objetos et, tv.
        etRadio=findViewById(R.id.et_radio);
        etAltura=findViewById(R.id.et_altura);
        tvRespuesta=findViewById(R.id.tvRespuesta);
        tvRespuesta.setText("");


    }
    //si validar retorna true, entonces el metodo calcular termina.
    public void CalcularVolumen(View boton) {
        if (validar())
            return;
        //Leer los datos de los editext
        Double radio = Double.valueOf(etRadio.getText().toString());
        Double altura = Double.valueOf(etAltura.getText().toString());
        double volumen = Math.PI * Math.pow(radio, 2) * altura;

        Cilindro oC=new Cilindro(radio,altura);
        tvRespuesta.setText(oC.toString());
    }

    private boolean validar() {
        //TRIM SUPRIME LOS ESPACIOS EN AMBOS LADOS
        if (etRadio.getText().toString().trim().isEmpty()) {

            etRadio.setError("Campo obligatorio para Radio");
            etRadio.requestFocus();// el parpadeo estara en el radio
            return true;
        }
        if (etAltura.getText().toString().trim().isEmpty()) {

            etAltura.setError("Campo obligatorio para Altura");
            etAltura.requestFocus();// el parpadeo estara en el radio
            return true;
        }
        return false;



    }
}