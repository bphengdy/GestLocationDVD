package com.example.gestlocationdvd;

import java.util.Calendar;
import java.util.Date;

import com.example.gestlocationdvd.R;
import com.example.gestlocationdvd.R.id;
import com.example.gestlocationdvd.R.layout;

import data.locdvd.DatabaseFilm;
import data.locdvd.Film;
import data.locdvd.FilmAdapter;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class VuDetail extends Activity {
	
	private TextView titre,realisateur, datesortie,limitage,description, acteur, nbrexmplaire;
	private EditText memo;
	private Button memoButton;
	private SQLiteDatabase db, db1;
	private DatabaseFilm databaseFilm;
	private Boolean drapeau;
	private ImageView Img;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vudetail);
		
		
		

		//Récupération des id des TextView De Fiche.xml
		titre= (TextView) findViewById(R.id.titreFiche);
		realisateur= (TextView) findViewById(R.id.realisateurFiche);
		datesortie=(TextView) findViewById(R.id.dateSortie);
		limitage=(TextView) findViewById(R.id.limitFiche);
		nbrexmplaire=(TextView) findViewById(R.id.nbrExemplaire);
		description=(TextView) findViewById(R.id.descriptionFiche);
		acteur= (TextView) findViewById(R.id.acteurFiche);
		Img = (ImageView) findViewById(R.id.imageView1);
						
		//Récupération des données via la liste dans ActionActiviy ou autre et insertion 
		//des data dans les TextView correspondant
				
				
		//Récupérer les valeurs string
		Intent intent = getIntent();
				
		//Récupérer les valeurs INT 
		Bundle test=getIntent().getExtras();
						
		//Utiliser lors de location du film
		final int id_film=test.getInt("id_film");
		
		databaseFilm= new DatabaseFilm(getBaseContext(), "GestLoc.db", null, 1);
		db= databaseFilm.getWritableDatabase();
			
		
		//exécuter une requete Select avec comme condition categorie=aventure
		String [] listcol ={"id","categorie","titre", "realisateur", "acteur","nbreExemplaire", "dateSortie", "description", "limitAge", "recompense","img"};
		String whereCond="titre=?";
		String [] whereArg={intent.getStringExtra("titre")};
		
		Cursor result= db.query("tab_film", listcol, whereCond, whereArg, null,null, null, null);
		
		int nbRec= result.getCount();
		Log.i("ENI", "Nbr Data = "+ String.valueOf(nbRec));
		
		if(nbRec>0){
			
			result.moveToFirst();
			while(!result.isAfterLast()){
				
				titre.setText(result.getString(2));
				realisateur.setText("Realisateur : \n" + result.getString(3)+"\n");
				datesortie.setText("Date Sortie : \n" + result.getString(6)+"\n");
				description.setText("Description : \n" +result.getString(7)+"\n"); 
				acteur.setText("Acteur : \n"+result.getString(4)+"\n");
				limitage.setText("Limite age : "+result.getInt(8)+"\n");
				nbrexmplaire.setText("Nombre d'exemplaire \n: "+result.getInt(5)+"\n");
				Img.setImageResource(result.getInt(10));
	
				result.moveToNext();
			
			}
			
				
		//Récupére la position du film
		final int position=test.getInt("position");
				
				
		//Variable utiliser si le client louer le film;
		final int nbrExemplaire=test.getInt("nbrExemplaire");
		//____________________________________________________________________________
		//Memo
		memo=(EditText)findViewById(R.id.memo);
		memoButton=(Button)findViewById(R.id.memoButton);
		
		//SQLiteDatabase db1= databaseFilm.getReadableDatabase();
		
		//exécuter une requete Select 
		
		String [] listcol1 ={"id", "commentaire", "id_client", "id_film"};
		String whereCond1="id_film=?";
		final String [] whereArg1={String.valueOf(id_film)};
		final Bundle test22=getIntent().getExtras();
		Cursor result1= db.query("tab_memo", listcol1, whereCond1, whereArg1, null,null, null, null);
						
						final int nbRec1= result1.getCount();
						
						if(nbRec1>0){
							result1.moveToFirst();
							memo.setText(result1.getString(1));
						}
				
				memoButton.setOnClickListener(new OnClickListener(){ 
		            public void onClick(View view){
		            	
		            	ContentValues contentValues5=new ContentValues();
						if(String.valueOf(memo.getText()).equals("") == false)
						{
							contentValues5.put("commentaire",String.valueOf(memo.getText()));
		            		contentValues5.put("id_client", test22.getInt("id_client"));
							contentValues5.put("id_film", id_film);
							if(nbRec1<=0)
							{
								db.insert("tab_memo", null, contentValues5);
							}
							else
							{
								db.update("tab_memo", contentValues5, "id_film=?",whereArg1);
							}
							
							Toast.makeText(getApplicationContext(), "Enregistré", Toast.LENGTH_SHORT).show();
						}
						else
						{
							memo.setText("");
							contentValues5.put("commentaire",String.valueOf(memo.getText()));
		            		contentValues5.put("id_client", test22.getInt("id_client"));
							contentValues5.put("id_film", id_film);
							if(nbRec1<=0)
							{
								db.insert("tab_memo", null, contentValues5);
							}
							else
							{
								db.update("tab_memo", contentValues5, "id_film=?",whereArg1);
							}
							Toast.makeText(getApplicationContext(), "Enregistré", Toast.LENGTH_SHORT).show();
						}
						Intent intent2 = new Intent(VuDetail.this, Action.class);
						intent2.putExtra("id_client", test22.getInt("id_client"));
						startActivity(intent2);
		            }
		                  	
		        });
			
		
		
		
				
				
		
		/*titre.setText("Titre : " + intent.getStringExtra("titre"));
		realisateur.setText("Realisateur : " + intent.getStringExtra("realisateur"));
		datesortie.setText("Date Sortie : " + intent.getStringExtra("dateSortie"));
		description.setText("Description : \n" +intent.getStringExtra("description")); 
		acteur.setText(intent.getStringExtra("acteur"));
		limitage.setText("Limite age : "+test.getInt("limitage"));
		nbrexmplaire.setText("Nombre d'exemplaire : "+nbrExemplaire);*/
				
		//final int id_film_cond=id_film;
		//final int nbrExemplaire1=nbrExemplaire-1;
				
		//Log.i("ENI", "Valeur de nbre Exmpalaire = "+id_film);
		
		
		
		
//______________________________________________________________________________
		
		
		
		//Louer film
		final CheckBox louer= (CheckBox) findViewById(R.id.louerfilm);
				
		
		//Enregistrer les préférences 
		SharedPreferences pref= getSharedPreferences("Action"+String.valueOf(test.getInt("id_film")),0);
		final SharedPreferences.Editor editeur=pref.edit();
				
		
		//Savoir si la préférence est coché
		boolean strDvd=pref.getBoolean("Action", false);
		int strDvdid=pref.getInt("ID", -1);
		//int strposition=pref.getInt("position", -1);
			
		if((strDvd != false)& (strDvdid==id_film) /*& (strposition==position*/) {
			louer.setChecked(true);
			louer.refreshDrawableState();
							
		}
		
		
		louer.setOnClickListener(new OnClickListener() {					
			public void onClick(View v) {
				//Récupération de la date d'aujourd'hui
				final Calendar c = Calendar.getInstance();
				int mYear = c.get(Calendar.YEAR);
				int mMonth = c.get(Calendar.MONTH);
				int mDay = c.get(Calendar.DAY_OF_MONTH);
				int nbr1,nbr;
				Date date = new Date(mYear - 1900, mMonth, mDay);
				String dateFacDB = DateFormat.format("yyyy.MM.dd", date).toString();
				
				if(louer.isChecked()){
					//drapeau=true;
					Toast toast = Toast.makeText(getApplicationContext(),"Film Loué", Toast.LENGTH_LONG);
					toast.show();
					editeur.putBoolean("Action", true);
					//editeur.putInt("position", position);
					editeur.putInt("ID", id_film);
					editeur.commit();

					//databaseFilm= new DatabaseFilm(getApplicationContext(), "dbFilm.db", null, 1);
					//db=databaseFilm.getWritableDatabase();
					ContentValues contentValues=new ContentValues();
					contentValues.put("id_film", id_film);
					contentValues.put("id_client", 1);
					contentValues.put("date", dateFacDB);
					contentValues.put("etat",1);
					db.insert("tab_louer", null, contentValues);


					//Baisse du nombre d'exemplaire disponible

					nbr1=nbrExemplaire-1;


					ContentValues args1 = new ContentValues();
					args1.put("nbreExemplaire", nbr1);
					db.update("tab_film", args1, "id="+id_film, null);

				}else{ // RENDRE UN FILM

					//Bundle test1=getIntent().getExtras();

					//databaseFilm= new DatabaseFilm(getApplicationContext(), "dbFilm.db", null, 1);
					//db=databaseFilm.getWritableDatabase();
					Toast toast = Toast.makeText(getApplicationContext(),"Film Rendu", Toast.LENGTH_LONG);
					toast.show();
					nbr=nbrExemplaire+1;
					//drapeau=false;
					editeur.putBoolean("Action", false);
					//editeur.putInt("position", position);
					editeur.putInt("ID", id_film);
					editeur.commit();


					//UPDATE DU NOMBRE DE FILM MAXIMUM EMPRUNTER
					ContentValues args2 = new ContentValues();
					args2.put("nbreExemplaire", nbr);
					db.update("tab_film", args2, "id="+id_film, null);

					//SUPPRESION DU FILM DANS LA table louer
					ContentValues args3 = new ContentValues();
					args3.put("etat", 0);
					db.update("tab_louer", args3, "id_film="+id_film, null);
					
					//db.delete("tab_louer", "id_film=?",new String[] {String.valueOf(id_film)});



				}

			}
		});
	}
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.item1 : 
			Intent intent = new Intent(VuDetail.this, Accueil.class);
			Bundle test22=getIntent().getExtras();
			intent.putExtra("id_client", test22.getInt("id_client"));
			startActivity(intent);
		case R.id.item2 :
			Log.i("ENI", "Croissance");
			return true;
		}
		return true;
	}
}
	

