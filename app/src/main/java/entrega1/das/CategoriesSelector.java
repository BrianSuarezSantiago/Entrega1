package entrega1.das;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import entrega1.das.R;

public class CategoriesSelector extends AppCompatActivity {
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_categorias);

        DBManager dbHelper = DBManager.getInstance(this);
        String [] categorias = dbHelper.obtenerCategorias();

        Bundle datos = this.getIntent().getExtras();
        email = datos.getString("email");

        ListView catView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.textRow, categorias);
        catView.setAdapter(adapter);

        catView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String categoria = ((TextView)view.findViewById(R.id.textRow)).getText().toString();
                siguiente(categoria);
            }
        });
    }

    public void siguiente (String cat) {
        Intent intent = new Intent(this, QuestionsNumber.class);
        intent.putExtra("tipo", "noAleatorio");
        intent.putExtra("categoria", cat);
        intent.putExtra("email", email);
        startActivity(intent);
    }
}