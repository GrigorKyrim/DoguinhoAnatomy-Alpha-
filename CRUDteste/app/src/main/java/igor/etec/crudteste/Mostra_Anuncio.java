package igor.etec.crudteste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Mostra_Anuncio extends Activity {

    private ListView lvShow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_show_anuncio);

        FloatingActionButton btnFA = (FloatingActionButton) findViewById(R.id.btnFloat);
        lvShow = (ListView) findViewById(R.id.lvMostra);

        btnFA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Mostra_Anuncio.this, Cadastro_Anuncios.class);

                startActivity(it);

            }
        });
    }
        protected void onResume(){
            super.onResume();

            DbHelper dbhelper = new DbHelper(getApplicationContext(), "dbzinho", null, 1);
            List<Anuncio> ListaAnuncio = dbhelper.selectAnuncios();

            ArrayAdapter<Anuncio> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListaAnuncio);
            lvShow.setAdapter(adp);



    }
}
