package com.example.gestlocationdvd;


import data.locdvd.DatabaseFilm;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Searchable extends Activity implements OnClickListener {
	
	private Button searchbt;
	private EditText searched;
	private DatabaseFilm database;
	private SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchable);
		
		searchbt=(Button) findViewById(R.id.searchbt);
		searched=(EditText) findViewById(R.id.search);
	
		searchbt.setOnClickListener(this);
		
	
	}

	@Override
	public void onClick(View v) {
		
		String filmrechercher=searched.getText().toString();
		//Toast.makeText(this, "Film rechercher : "+filmrechercher, Toast.LENGTH_LONG).show();
		
		database = new DatabaseFilm(getBaseContext(),"GestLoc.db", null, 1);
		
		db=database.getReadableDatabase();
		
		String [] listcol ={"id","categorie","titre", "realisateur", "acteur","nbreExemplaire", "dateSortie", "description", "limitAge", "recompense"};
		String whereCond="titre=?";
		String [] whereArg={filmrechercher};
		
		Cursor result= db.query("tab_film", listcol, whereCond, whereArg, null,null, null, null);
		
		int nbRec= result.getCount();
		Log.i("ENI", "Nbr Data = "+ String.valueOf(nbRec));
		result.moveToFirst();
		
		if(nbRec>0){
				
			Intent intent=new Intent(Searchable.this, VuDetail.class);
			intent.putExtra("titre", filmrechercher);
			intent.putExtra("id_film", result.getInt(0));
			startActivity(intent);
			
			
		}else{
			
			Toast.makeText(this, "Le Film : "+filmrechercher+" n'existe pas", Toast.LENGTH_LONG).show();
		}
		
	}
	


}
