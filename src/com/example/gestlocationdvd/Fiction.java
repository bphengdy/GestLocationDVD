package com.example.gestlocationdvd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Fiction extends Activity {

	private ArrayList<String> listFiction;
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fiction);
		listFiction = new ArrayList<String>();
		try
		{
			AssetManager assetManager = getAssets();
			BufferedReader data = new BufferedReader (new
					InputStreamReader(assetManager.open("fiction.txt")));
			String ligne ="";
			while( (ligne = data.readLine() )!=null){
				listFiction.add(ligne);
			}
			data.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		final ArrayAdapter<String> adapterList = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_single_choice, listFiction);
		ListView ListFiction = (ListView) findViewById(R.id.ListView02);
		ListFiction.setAdapter(adapterList);
		ListFiction.setOnItemClickListener(new OnItemClickListener() {
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
