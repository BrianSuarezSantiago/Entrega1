package entrega1.das;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import entrega1.das.R;

public class Homepage extends AppCompatActivity {
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        // Cargamos la BD
        DBManager dbHelper = DBManager.getInstance(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }

    /** Called when the user taps the Qué Es button */
    public void whatIs(View view) {
        Intent intent = new Intent(this, FunTasticQuizInformation.class);
        startActivity(intent);
    }

    /** Called when the user taps the Iniciar Sesión button */
    public void iniciarSesion(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    /** Called when the user taps the registrase button */
    public void registrase(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);

    }

    /** Called when the user taps the Salir button */
    public void salir(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}