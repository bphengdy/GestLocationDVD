package com.example.gestlocationdvd;

import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import data.locdvd.DatabaseFilm;

public class Connexion extends Activity implements OnClickListener {

		private Intent intent; private Toast toast;
		private SQLiteDatabase db; private boolean test;
		private DatabaseFilm databaseFilm;
		private Button btConnexion;
		private EditText Id,Mdp;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.connexion);
			
			btConnexion = (Button) findViewById(R.id.button1);
			btConnexion.setOnClickListener(this);
			Id = (EditText) findViewById(R.id.editText1);
			Mdp = (EditText) findViewById(R.id.editText2);
			
			//_____________________________________________
			
			databaseFilm= new DatabaseFilm(getApplicationContext(), "GestLoc.db", null, 1);
	        db=databaseFilm.getWritableDatabase();
	        
			Cursor result = db.rawQuery("SELECT * FROM tab_film", null);
		      int nbrCol= result.getCount();
		      Log.i("ENI", "FILM="+nbrCol);
		      result.close();
		      
		//      if(nbrCol<=0){  //A METTRE EN COM POUR RECREER LA BDD
		        db.execSQL("DROP TABLE IF EXISTS tab_film");
		        db.execSQL("DROP TABLE IF EXISTS tab_client");
		        db.execSQL("DROP TABLE IF EXISTS tab_memo");
		        db.execSQL("DROP TABLE IF EXISTS tab_louer");
		        db.execSQL("DROP TABLE IF EXISTS tab_categorie");
		        db.execSQL("DROP TABLE IF EXISTS tab_entreprise");
		        databaseFilm.onCreate(db);
		        db.execSQL("INSERT INTO tab_client ('nom','numero','mdp') VALUES('Billy',93400,'123')");
		        db.execSQL("INSERT INTO tab_client ('nom','numero','mdp') VALUES('John',93400,'123')");
		        db.execSQL("INSERT INTO tab_client ('nom','numero','mdp') VALUES('Jean',93400,'123')");
	        //______________________________________________
	        
	        try{
	        	XmlPullParser xmlPullParser=getResources().getXml(R.xml.action);
	        	while(xmlPullParser.getEventType()!=XmlPullParser.END_DOCUMENT){
	        		if(xmlPullParser.getEventType()==XmlPullParser.START_TAG){
	        			if(xmlPullParser.getName().equals("dvd")){	
	        			ContentValues contentValues=new ContentValues();
	        			contentValues.put("categorie", xmlPullParser.getAttributeValue(0));
	        			contentValues.put("titre", xmlPullParser.getAttributeValue(1));
	        			contentValues.put("realisateur", xmlPullParser.getAttributeValue(2));
	        			contentValues.put("acteur", xmlPullParser.getAttributeValue(3));
	        			contentValues.put("nbreExemplaire", Integer.parseInt(xmlPullParser.getAttributeValue(4)));
	        			contentValues.put("dateSortie", xmlPullParser.getAttributeValue(5));
	        			contentValues.put("description", xmlPullParser.getAttributeValue(6));
	        			contentValues.put("limitAge", Integer.parseInt(xmlPullParser.getAttributeValue(7)));
	        			contentValues.put("recompense", xmlPullParser.getAttributeValue(8));
	        			contentValues.put("img", xmlPullParser.getAttributeValue(9));
	        			db.insert("tab_film", null, contentValues);
	        			}
	        		}
	        		xmlPullParser.next();
	        	}
	        }catch(Exception e){
	        	Log.i("ENI", "Erreur " + e.getMessage());
	        	e.printStackTrace();
	        }
		      }
	        
	        
	//	} //LIMITER CREATION BDD

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Cursor result = db.rawQuery("SELECT * FROM tab_client", null);
			result.moveToFirst(); int LeId =0; String LeMdp=""; String LeIdentifiant="";
			int nbRec= result.getCount();
			while(!result.isAfterLast())
			{
				if(String.valueOf(Id.getText()).equals(result.getString(1)) &&
						String.valueOf(Mdp.getText()).equals(result.getString(3)))
				{
					LeId=result.getInt(0);
					 LeIdentifiant = result.getString(1);
					 LeMdp = result.getString(3);
				}
				result.moveToNext();
			}
			
			if(String.valueOf(Id.getText()).equals(LeIdentifiant) &&
						String.valueOf(Mdp.getText()).equals(LeMdp))
			{
				Toast.makeText(getApplicationContext(), "Connexion réussie", Toast.LENGTH_SHORT).show();
				intent = new Intent(this, Accueil.class);
				intent.putExtra("id_client", LeId);
				startActivity(intent);
			}
			else
			{
				Toast.makeText(getApplicationContext(), "Identifiants incorrect", Toast.LENGTH_SHORT).show();	
			}
			
		}
}
