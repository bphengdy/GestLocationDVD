package com.example.gestlocationdvd;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Policier extends Activity {

	private String filmPolicier[] = {
							"Kill Bill - vol 1",
							"Kill Bill - vol 2",
							"Otage",
							"Da Vinci Code",
							"36 quai des Orfèvres",
							"Mystic River"};
	
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.policier);
		final ArrayAdapter<String> adapterList= new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_single_choice ,filmPolicier);
		
		ListView listPolicier = (ListView) findViewById(R.id.ListView01);
		listPolicier.setAdapter(adapterList);
		listPolicier.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					String titre = adapterList.getItem(position);
					Toast toast = Toast.makeText(getApplicationContext(),titre, Toast.LENGTH_LONG);
					toast.show();
					
				}
				
		});

	}
	

}
