package com.example.gestlocationdvd;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import data.locdvd.DatabaseFilm;
import data.locdvd.Film;
import data.locdvd.FilmAdapter;

public class Action extends Activity {
	
	private SQLiteDatabase db;
	private DatabaseFilm databaseFilm;
	private ListView listaction;
	FilmAdapter adapterfilm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.action);
		listaction=(ListView) findViewById(R.id.Action);
		adapterfilm= new FilmAdapter(this, R.layout.ligne);
		
		databaseFilm= new DatabaseFilm(getBaseContext(), "GestLoc.db", null, 1);
		SQLiteDatabase db= databaseFilm.getReadableDatabase();
			
		
		//exécuter une requete Select avec comme condition categorie=action
		String [] listcol ={"id","categorie","titre", "realisateur", "acteur","nbreExemplaire", "dateSortie", "description", "limitAge", "recompense","img"};
		String whereCond="categorie=?";
		String [] whereArg={"action"};
		
		Cursor result= db.query("tab_film", listcol, whereCond, whereArg, null,null, null, null);
		
		int nbRec= result.getCount();
		Log.i("ENI", "Nbr Data = "+ String.valueOf(nbRec));
		
		if(nbRec>0){
			
			adapterfilm = new FilmAdapter(this, R.layout.ligne);
			result.moveToFirst();
			while(!result.isAfterLast()){
				
				Film film= new Film();
				film.setId(result.getInt(0));
				film.setCategorie(result.getString(1));
				film.setTitre(result.getString(2));
				film.setRealisateur(result.getString(3));
				film.setActeur(result.getString(4));
				film.setNbreExemplaire(result.getInt(5));
				film.setDateSortie(result.getString(6));
				film.setDescription(result.getString(7));
				film.setLimitAge(result.getInt(8));
				film.setRecompense(result.getString(9));
				film.setImg(result.getInt(10));
	
				adapterfilm.add(film);
				result.moveToNext();
			
			}
			
			listaction.setAdapter(adapterfilm);
			
		}
		
		listaction.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				Film film = new Film();
				film = (Film) listaction.getItemAtPosition(position);
				
				 /*SharedPreferences prefs = getSharedPreferences("action", MODE_PRIVATE);
				 SharedPreferences.Editor editor = prefs.edit();
				 editor.putInt("action", id)
				 editor.commit(); // This line is IMPORTANT. If you miss this one its not gonna work!*/
				Bundle test=getIntent().getExtras();
				Intent intent = new Intent(Action.this, VuDetail.class);
				intent.putExtra("position", position);
				intent.putExtra("id_film", (int) film.getId());
				intent.putExtra("nbrExemplaire", (int)film.getNbreExemplaire());
				intent.putExtra("titre", film.getTitre());
				intent.putExtra("id_client",test.getInt("id_client"));
				/*intent.putExtra("realisateur", film.getRealisateur());
				intent.putExtra("limitage", (int)film.getLimitAge());
				intent.putExtra("description", film.getDescription());
				intent.putExtra("nbrExemplaire", (int)film.getNbreExemplaire());
				intent.putExtra("dateSortie", film.getDateSortie());
				intent.putExtra("acteur", film.getActeur());*/
				
				startActivity(intent);
				
			
			}

			});
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menu, menu);
//		item.setIcon(R.drawable.abc_list_divider_mtrl_alpha);
		return true;
	}
	
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.item1 : 
			Intent intent = new Intent(Action.this, Accueil.class);
			Bundle test=getIntent().getExtras();
			intent.putExtra("id_client", test.getInt("id_client"));
			startActivity(intent);
		}
		return true;
	}
	
}
