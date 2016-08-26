package in.codingninjas.itsmovietime2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by LALIT GULIA on 7/5/2016.
 */
public class MovieListAdapter extends ArrayAdapter<MovieListDetails> {
    ArrayList<MovieListDetails> movie;
    Context context;

    public MovieListAdapter(Context context, ArrayList<MovieListDetails> objects) {
        super(context, 0, objects);
        movie = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null){
            v = LayoutInflater.from(this.context).inflate(R.layout.movielist,parent,false);
        }
        String s = movie.get(position).getPoster_path();
        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        Picasso.with(context).load("http://image.tmdb.org/t/p/w342/" + s).into(img);
        return v;
    }

    @Override
    public int getCount() {
        return movie.size();
    }
}
