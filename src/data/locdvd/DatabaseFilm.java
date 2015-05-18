package data.locdvd;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseFilm extends SQLiteOpenHelper{
	
	private SQLiteDatabase bdd;

	public DatabaseFilm(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String streq = "CREATE TABLE tab_film (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, categorie TEXT, titre TEXT, realisateur TEXT, acteur TEXT, nbreExemplaire INTEGER, dateSortie TEXT, description TEXT, limitAge INTEGER, recompense TEXT, img INTEGER);";
		String streq1 = "CREATE TABLE tab_client (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, numero INTEGER, mdp TEXT);";
		String streq2 = "CREATE TABLE tab_memo (id INTEGER PRIMARY KEY AUTOINCREMENT, commentaire TEXT, id_client INTEGER, id_film INTEGER);";
		String streq3 = "CREATE TABLE tab_louer (id INTEGER PRIMARY KEY AUTOINCREMENT, id_film INTEGER, id_client INTEGER, date TEXT, etat INTEGER);";
		String streq4 = "CREATE TABLE tab_categorie (id INTEGER PRIMARY KEY AUTOINCREMENT, categorie TEXT);";
		String streq5 = "CREATE TABLE tab_entreprise (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, adresse TEXT, numero TEXT, mail TEXT, contact TEXT, site TEXT);";
		
		db.execSQL(streq);
		db.execSQL(streq1);
		db.execSQL(streq2);
		db.execSQL(streq3);
		db.execSQL(streq4);
		db.execSQL(streq5);
	}
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		db.execSQL("DROP TABLE IF EXISTS tab_film");
		db.execSQL("DROP TABLE IF EXISTS tab_client");
		db.execSQL("DROP TABLE IF EXISTS tab_memo");
		db.execSQL("DROP TABLE IF EXISTS tab_louer");
		db.execSQL("DROP TABLE IF EXISTS tab_categorie");
		db.execSQL("DROP TABLE IF EXISTS tab_entreprise");
		onCreate(db);
		
	}
	

	

	
	

}
