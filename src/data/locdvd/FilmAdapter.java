package data.locdvd;

import com.example.gestlocationdvd.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FilmAdapter extends ArrayAdapter<Film>{
	

	public FilmAdapter(Context context,int textViewResourceId) {
		super(context,textViewResourceId);
	
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View result= convertView;
		
		if(convertView==null){
			result= LayoutInflater.from(getContext()).inflate(R.layout.ligne, parent, false);
		}
		
		Film film = getItem(position);
		
		TextView  titre = (TextView)  result.findViewById(R.id.Titre);
		titre.setText(film.getTitre());
		
		TextView realisateur= (TextView) result.findViewById(R.id.Realisateur);
		realisateur.setText(film.getRealisateur());
		
		
		return result;
		
	}
	
	public void updateData(){
		
		this.notifyDataSetChanged();
	}

	

}
