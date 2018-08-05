package igor.etec.crudteste;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends Activity {
    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbhelper = new DbHelper(getApplicationContext(), "dbzinho", null, 1);


        Anuncio primeiro = new Anuncio(0, "Igor", "teste", "alo alo marciano");
        dbhelper.insertAnuncio(primeiro);
        dbhelper.insertAnuncio(new Anuncio(0, "Hadma", "Mensagem dois","cala a boca"));

        List<Anuncio> ListaAnuncio = dbhelper.selectAnuncios();
        for (Iterator iterator = ListaAnuncio.iterator(); iterator.hasNext();){
            Anuncio anuncio = (Anuncio) iterator.next();

            Log.i("AppAnuncios", anuncio.toString());

        }
    }
}
