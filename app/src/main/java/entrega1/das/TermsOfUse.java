package entrega1.das;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import entrega1.das.R;

public class TermsOfUse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condiciones_uso);
    }
    public void volver(View view) {
        finish();
    }
}