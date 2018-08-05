package igor.etec.crudteste;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String NOME_BASE = "dbzinho";
    private static final int VERSAO = 1;


    public DbHelper(Context context, java.lang.String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NOME_BASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTabela = "CREATE TABLE anuncio(" +
                                                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        "nome TEXT," +
                                                        "assunto TEXT," +
                                                        "mensagem TEXT)";
        db.execSQL(sqlCreateTabela);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sqlDropTabela = "DROP TABLE anuncio";
        db.execSQL(sqlDropTabela);

        onCreate(db);
    }

    public void insertAnuncio(Anuncio anuncio){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nome", anuncio.getNome());
        cv.put("assunto", anuncio.getAssunto());
        cv.put("mensagem", anuncio.getMensagem());
        db.insert("anuncio", null, cv);
        db.close();
    }

    public List<Anuncio> selectAnuncios(){
        List<Anuncio> listAnuncio = new ArrayList<Anuncio>();

        SQLiteDatabase db = getReadableDatabase();
        String sqlSelectAnuncios = "SELECT * FROM anuncio";
        Cursor c = db.rawQuery(sqlSelectAnuncios, null);
        if(c.moveToFirst()){
            do {


                Anuncio anuncio = new Anuncio();
                anuncio.setId(c.getInt(0));
                anuncio.setNome(c.getString(1));
                anuncio.setAssunto((c.getString(2)));
                anuncio.setMensagem((c.getString(3)));

                listAnuncio.add(anuncio);
            }while (c.moveToNext());
        }
        db.close();
        return listAnuncio;

    }

}
