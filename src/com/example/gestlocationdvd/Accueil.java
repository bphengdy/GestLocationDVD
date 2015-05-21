package com.example.gestlocationdvd;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import data.locdvd.DatabaseFilm;

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
		Bundle test=getIntent().getExtras();
		switch (arg0.getId()) {
		case R.id.Action:
			intent = new Intent(this, Action.class);
			intent.putExtra("id_client", test.getInt("id_client"));
//			intent.putExtra("nom", client.getNom());
			startActivity(intent);
			break;
		case R.id.Aventure:
			intent = new Intent(this, Aventure.class);
			intent.putExtra("id_client", test.getInt("id_client"));
			startActivity(intent);
			break;
		case R.id.Comedie:
			intent = new Intent(this, Comedie.class);
			intent.putExtra("id_client", test.getInt("id_client"));
			startActivity(intent);
			break;
		case R.id.Drame:
			intent = new Intent(this, Drame.class);
			intent.putExtra("id_client", test.getInt("id_client"));
			startActivity(intent);
			break;
		case R.id.Fantastique:
			intent = new Intent(this, Fantastique.class);
			intent.putExtra("id_client", test.getInt("id_client"));
			startActivity(intent);
			break;
		case R.id.Documentaire:
			intent = new Intent(this, Documentaire.class);
			intent.putExtra("id_client", test.getInt("id_client"));
			startActivity(intent);
			break;
		case R.id.Jeunesse:
			intent = new Intent(this, Jeunesse.class);
			intent.putExtra("id_client", test.getInt("id_client"));
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
		Bundle test2=getIntent().getExtras();
		switch(item.getItemId())
		{
		case R.id.item1 : 
			Intent intent = new Intent(Accueil.this, Accueil.class);
			startActivity(intent);
			break;
		case R.id.item2:
			Intent intent2 = new Intent(Accueil.this, About.class);
			intent2.putExtra("id_client", test2.getInt("id_client"));
			startActivity(intent2);
			break;
		case R.id.item3:
			Intent intent3 = new Intent(Accueil.this, Connexion.class);
			startActivity(intent3);
			break;
		case R.id.item4:
			Intent intent4 = new Intent(Accueil.this, Searchable.class);
			intent4.putExtra("id_client", test2.getInt("id_client"));
			startActivity(intent4);
			break;
		case R.id.item5:
			Intent intent5 = new Intent(Accueil.this, AndroidVideoView.class);
			startActivity(intent5);
			break;
		case R.id.item6:
			Intent intent6 = new Intent(Accueil.this, GalleryView.class);
			startActivity(intent6);
			break;
		}
		return true;
	}
}
