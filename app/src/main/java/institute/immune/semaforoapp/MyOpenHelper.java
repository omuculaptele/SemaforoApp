package institute.immune.semaforoapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyOpenHelper extends SQLiteOpenHelper {
    private static final String script = "CREATE TABLE user(id integer PRIMARY KEY AUTOINCREMENT, name text, mail text, contrasena text)";
    private SQLiteDatabase db;

    public MyOpenHelper(@Nullable Context context) {
        super(context,"user.sqlite", null, 1);
        db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(script);
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}

    public void addUsuario(String nombre, String correo, String password){
        ContentValues values = new ContentValues();
        values.put("name", nombre);
        values.put("mail",correo);
        values.put("contrasena",password);
        db.insert("user",null, values);

    }

    public void delUsuario(int id){
        String[]args = new String[]{
                String.valueOf(id)
        };
        db.delete("user", "_id=?", args);
    }

    public ArrayList<USUARIO> seeUsuario(){
        ArrayList<USUARIO> listaUsuarios = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from user", null);
        if (cursor != null && cursor.getCount() > 0) {
            do {
                @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String correo = cursor.getString(cursor.getColumnIndex("mail"));
                @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("contrasena"));
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                USUARIO usuario = new USUARIO(id, nombre, correo, password);
                listaUsuarios.add(usuario);
            } while(cursor.moveToNext());
        }
        return listaUsuarios;
    }
}