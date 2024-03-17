package entrega1.das;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import entrega1.das.R;

public class QuestionsNumber extends AppCompatActivity {
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_preguntas);

        Bundle datos = this.getIntent().getExtras();
        email = datos.getString("email");
    }

    public void jugar (View view) {
        TextView textnumPreg = findViewById(R.id.textnumPreg);
        String numP = textnumPreg.getText().toString();
        /*Recuperación de datos de la actividad anterior*/
        Bundle datos = this.getIntent().getExtras();
        String tipo = datos.getString("tipo");

        if(numP.equals("")) {
            Toast.makeText(getApplicationContext(), getString(R.string.numpregvacio), Toast.LENGTH_SHORT).show();
            textnumPreg.setText("");
        }  else {
            int numPreg = Integer.parseInt(textnumPreg.getText().toString());

            if(numPreg < 1 || numPreg>20) {
                Toast.makeText(getApplicationContext(), getString(R.string.minmaxpreg), Toast.LENGTH_SHORT).show();
                textnumPreg.setText("");
            } else {
                if(tipo.equals("noAleatorio")) {
                    Log.d("Play", "jugarrrrrrrrrr no Aleatorio ");
                    /*Recuperación de datos de la actividad anterior*/
                    String categoria = datos.getString("categoria");
                    Log.d("Datos: ", categoria + " " + numPreg );
                    Intent intent = new Intent(this, Play.class);
                    intent.putExtra("categoria",categoria);
                    intent.putExtra("QuestionsNumber",numPreg);
                    intent.putExtra("tipo", tipo);
                    intent.putExtra("email", email);
                    startActivity(intent);
                } else {
                    Log.d("Play", "jugarrrrrrrr Aleatorio ");
                    Intent intent = new Intent(this, Play.class);
                    intent.putExtra("QuestionsNumber",numPreg);
                    intent.putExtra("tipo", tipo);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }
            }
        }
    }
}