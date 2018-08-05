package igor.etec.crudteste;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro_Anuncios extends Activity implements View.OnClickListener{
    private EditText edtNome;
    private EditText edtAssunto;
    private EditText edtMensagem;
    private Button btnEnviar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_new_anuncio);

        edtAssunto = (EditText)findViewById(R.id.edtAssunto);
        edtMensagem=(EditText)findViewById(R.id.edtMensagem);
        edtNome=(EditText)findViewById(R.id.edtNome);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Anuncio anuncio = new Anuncio();
        anuncio.setAssunto(edtAssunto.getText().toString());
        anuncio.setNome(edtNome.getText().toString());
        anuncio.setMensagem(edtMensagem.getText().toString());

        DbHelper dbhelper = new DbHelper(getApplicationContext(), "dbzinho", null, 1);
        dbhelper.insertAnuncio(anuncio);
        finish();
    }
}
