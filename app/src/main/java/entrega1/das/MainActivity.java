package entrega1.das;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import entrega1.das.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void entrar(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
        finish();

    }
}