//package com.example.gestlocationdvd;
//
//import java.util.ArrayList;
//
//import org.xmlpull.v1.XmlPullParser;
//
//import data.locdvd.Film;
//import data.locdvd.FilmAdapter;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ListView;
//
//public class Serie extends Activity {
//
//	private ListView listSerie;
//	private FilmAdapter adapterFilm;
//	
//	protected void onCreate(Bundle savedInstanceState){
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.serie);
//		listSerie = (ListView) findViewById(R.id.ListView03);
//		adapterFilm = new FilmAdapter(this,R.layout.ligne);
//		try
//		{
//			XmlPullParser xmlPullParser = getResources().getXml(R.xml.serie);
//			while(xmlPullParser.getEventType()!=XmlPullParser.END_DOCUMENT)
//			{
//				if(xmlPullParser.getEventType() == XmlPullParser.START_TAG)
//				{
//					if(xmlPullParser.getName().equals("dvd"))
//					{
//						Film film = new Film();
//						film.setStrDescription(xmlPullParser.getAttributeValue(0));
//						film.setStrRealisateur(xmlPullParser.getAttributeValue(1));
//						film.setStrTitre(xmlPullParser.getAttributeValue(2));
//						film.setStrCat(xmlPullParser.getAttributeValue(3));
//						film.setStrActeur(xmlPullParser.getAttributeValue(4));
//						film.setNbEx(xmlPullParser.getAttributeValue(5));
//						film.setStrDateSortie(xmlPullParser.getAttributeValue(6));
//						adapterFilm.add(film);
//					}
//				}
//				xmlPullParser.next();
//			}
//			
//			listSerie.setAdapter(adapterFilm);
//		}
//		catch(Exception e)
//		{
//			Log.i("ENI", "Erreur"+e.getMessage());
//		}
//	}
//}
