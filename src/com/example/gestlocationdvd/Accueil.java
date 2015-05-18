package com.example.gestlocationdvd;

import org.xmlpull.v1.XmlPullParser;

import com.example.gestlocationdvd.R;

import data.locdvd.Client;
import data.locdvd.DatabaseFilm;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Accueil extends Activity implements OnClickListener {

	private Intent intent; private Toast toast;
	private SQLiteDatabase db; private boolean test;
	private DatabaseFilm databaseFilm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		
		Button btAction = (Button) findViewById(R.id.Action);
		btAction.setOnClickListener(this);
		Button btAventure = (Button) findViewById(R.id.Aventure);
		btAventure.setOnClickListener(this);
		Button btComedie = (Button) findViewById(R.id.Comedie);
		btComedie.setOnClickListener(this);
		Button btDrame = (Button) findViewById(R.id.Drame);
		btDrame.setOnClickListener(this);
		Button btFantastique = (Button) findViewById(R.id.Fantastique);
		btFantastique.setOnClickListener(this);
		Button btDocumentaire = (Button) findViewById(R.id.Documentaire);
		btDocumentaire.setOnClickListener(this);
		Button btJeunesse = (Button) findViewById(R.id.Jeunesse);
		btJeunesse.setOnClickListener(this);
		//_____________________________________________
//		
//		databaseFilm= new DatabaseFilm(getApplicationContext(), "GestLoc.db", null, 1);
//        db=databaseFilm.getWritableDatabase();
//        
//		Cursor result = db.rawQuery("SELECT * FROM tab_film", null);
//	      int nbrCol= result.getCount();
//	      Log.i("ENI", "FILM="+nbrCol);
//	      result.close();
//	      
//	      if(nbrCol<=0){  //A METTRE EN COM POUR RECREER LA BDD
//	        db.execSQL("DROP TABLE IF EXISTS tab_film");
//	        db.execSQL("DROP TABLE IF EXISTS tab_client");
//	        db.execSQL("DROP TABLE IF EXISTS tab_memo");
//	        db.execSQL("DROP TABLE IF EXISTS tab_louer");
//	        db.execSQL("DROP TABLE IF EXISTS tab_categorie");
//	        db.execSQL("DROP TABLE IF EXISTS tab_entreprise");
//	        databaseFilm.onCreate(db);
//	        db.execSQL("INSERT INTO tab_client VALUES('Billy',93400)");
//	        db.execSQL("INSERT INTO tab_client VALUES('Jean',75000)");
//	        db.execSQL("INSERT INTO tab_client VALUES('Marcel',94000)");
//	        db.execSQL("INSERT INTO tab_client VALUES('Rebecca',96000)");
//	        
//        //______________________________________________
//        
//        try{
//        	XmlPullParser xmlPullParser=getResources().getXml(R.xml.action);
//        	while(xmlPullParser.getEventType()!=XmlPullParser.END_DOCUMENT){
//        		if(xmlPullParser.getEventType()==XmlPullParser.START_TAG){
//        			if(xmlPullParser.getName().equals("dvd")){	
//        			ContentValues contentValues=new ContentValues();
//        			contentValues.put("categorie", xmlPullParser.getAttributeValue(0));
//        			contentValues.put("titre", xmlPullParser.getAttributeValue(1));
//        			contentValues.put("realisateur", xmlPullParser.getAttributeValue(2));
//        			contentValues.put("acteur", xmlPullParser.getAttributeValue(3));
//        			contentValues.put("nbreExemplaire", Integer.parseInt(xmlPullParser.getAttributeValue(4)));
//        			contentValues.put("dateSortie", xmlPullParser.getAttributeValue(5));
//        			contentValues.put("description", xmlPullParser.getAttributeValue(6));
//        			contentValues.put("limitAge", Integer.parseInt(xmlPullParser.getAttributeValue(7)));
//        			contentValues.put("recompense", xmlPullParser.getAttributeValue(8));
//        			contentValues.put("img", xmlPullParser.getAttributeValue(9));
//        			db.insert("tab_film", null, contentValues);
//        			}
//        		}
//        		xmlPullParser.next();
//        	}
//        }catch(Exception e){
//        	Log.i("ENI", "Erreur " + e.getMessage());
//        	e.printStackTrace();
//        }
//	      }
	} //LIMITER CREATION BDD
	
	public void onClick(View arg0)
	{
		switch (arg0.getId()) {
		case R.id.Action:
			intent = new Intent(this, Action.class);
			Bundle test=getIntent().getExtras();
			intent.putExtra("id_client", test.getInt("id_client"));
//			intent.putExtra("nom", client.getNom());
			startActivity(intent);
			break;
		case R.id.Aventure:
			intent = new Intent(this, Fiction.class);
			startActivity(intent);
			break;
		case R.id.Comedie:
			intent = new Intent(this, Action.class);
			startActivity(intent);
			break;
		case R.id.Drame:
			intent = new Intent(this, Fiction.class);
			startActivity(intent);
			break;
		case R.id.Fantastique:
			intent = new Intent(this, Fiction.class);
			startActivity(intent);
			break;
		case R.id.Documentaire:
			intent = new Intent(this, Fiction.class);
			startActivity(intent);
			break;
		case R.id.Jeunesse:
			intent = new Intent(this, Fiction.class);
			startActivity(intent);
			break;
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.item1 : 
			Intent intent = new Intent(Accueil.this, Accueil.class);
			startActivity(intent);
		case R.id.item2 :
			Log.i("ENI", "Croissance");
			return true;
		}
		return true;
	}
}
