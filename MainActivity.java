package in.codingninjas.itsmovietime2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mylist;
    ArrayList<MovieListDetails> al;
    MovieListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = (ListView)findViewById(R.id.listview);

        String url = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=7450a37e8c295dc1b11d1ac6bdef70b9";
        MovieListDownload task = new MovieListDownload(MainActivity.this);
        task.execute(url);

        al = new ArrayList<>();
        adapter = new MovieListAdapter(MainActivity.this,al);
        mylist.setAdapter(adapter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,SecondActivity.class);
                i.putExtra("id",al.get(position).getId());
                i.putExtra("title",al.get(position).getTitle());
                startActivity(i);
            }
        });

    }



    public void processResults(MovieListDetails[] movieListDetailses) {
        if(movieListDetailses == null || movieListDetailses.length ==0)
            return;
        al.clear();
        for (MovieListDetails m:movieListDetailses){
            al.add(m);
        }
        adapter.notifyDataSetChanged();

    }
}
