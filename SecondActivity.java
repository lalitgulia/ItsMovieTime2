package in.codingninjas.itsmovietime2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements SingleMovieDetailsDownload.SingleMovieDetailsInterface {
    ArrayList<String> al;
   // moviedetails moviedet;
    ImageView mainimg;
    TextView title;
    TextView overview;
    TextView votecount;
    TextView popularity;
    TextView releasedate;
    TextView status;
    ImageView trailer1;
    ImageView trailer2;
    ImageView trailer3;


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        al = new ArrayList<>();
        mainimg = (ImageView) findViewById(R.id.imageView2);
        title = (TextView) findViewById(R.id.title);
        overview = (TextView) findViewById(R.id.overview);
        votecount = (TextView) findViewById(R.id.votecount);
        popularity = (TextView) findViewById(R.id.popularity);
        releasedate = (TextView) findViewById(R.id.releasedate);
        status = (TextView) findViewById(R.id.status);
        trailer1 = (ImageView) findViewById(R.id.trailer1);
        trailer2 = (ImageView) findViewById(R.id.trailer2);
        trailer3 = (ImageView) findViewById(R.id.trailer3);

        String id = getIntent().getStringExtra("id");

        String url = "https://api.themoviedb.org/3/movie/"+id+"?api_key=7450a37e8c295dc1b11d1ac6bdef70b9";
        SingleMovieDetailsDownload task2 = new SingleMovieDetailsDownload(this);
        task2.execute(url);
   //     al = new ArrayList<>();

        String url2 = "https://api.themoviedb.org/3/movie/"+id+"/videos?api_key=7450a37e8c295dc1b11d1ac6bdef70b9";
        MovieTrailer1Download task1 = new MovieTrailer1Download(this);
        task1.execute(url2);



///        overview.setText(moviedet.getOverview());
//        votecount.setText(moviedet.getVote_count());
//        popularity.setText(moviedet.getPopularity());
//        releasedate.setText(moviedet.getRelease_date());
//        status.setText(moviedet.getStatus());
//        if(al.get(0).length()!=0)
//            Picasso.with(SecondActivity.this).load("http://img.youtube.com/vi/"+al.get(0)+"/hqdefault.jpg").into(trailer1);
//        if(al.get(1).length()!=0)
//            Picasso.with(SecondActivity.this).load("http://img.youtube.com/vi/"+al.get(1)+"/hqdefault.jpg").into(trailer2);
//        if(al.get(2).length()!=0)
//            Picasso.with(SecondActivity.this).load("http://img.youtube.com/vi/"+al.get(2)+"/hqdefault.jpg").into(trailer3);
//        title.setText(al.get(0).getTitle());
//        overview.setText(al.get(0).getOverview());
//        votecount.setText(al.get(0).getVote_count());
//        popularity.setText(al.get(0).getPopularity());
//        releasedate.setText(al.get(0).getRelease_date());
//        status.setText(al.get(0).getStatus());




    }

//    public void procesSsecondResult(moviedetails moviedetails) {
//
//        if (moviedetails == null )
//            return;
//        moviedet = new moviedetails(moviedetails.getPoster_path(),moviedetails.getOverview(),moviedetails.release_date,moviedetails.getId(),moviedetails.getTitle(),moviedetails.getBackdrop_path(),moviedetails.getPopularity(),moviedetails.getVote_count(),moviedetails.getStatus());
//        //al.clear();
//        mainimg = (ImageView) findViewById(R.id.imageView);
//        title = (TextView) findViewById(R.id.title);
//        overview = (TextView) findViewById(R.id.overview);
//        votecount = (TextView) findViewById(R.id.votecount);
//        popularity = (TextView) findViewById(R.id.popularity);
//        releasedate = (TextView) findViewById(R.id.releasedate);
//        status = (TextView) findViewById(R.id.status);
//        Picasso.with(SecondActivity.this).load("http://image.tmdb.org/t/p/w342/" + moviedetails.getPoster_path()).into(mainimg);
//        title.setText(moviedetails.getTitle());
//        overview.setText(moviedetails.getOverview());
//        votecount.setText(moviedetails.getVote_count());
//        popularity.setText(moviedetails.getPopularity());
//        releasedate.setText(moviedetails.getRelease_date());
//        status.setText(moviedetails.getStatus());
//        return;
//    }

    @Override
    public void processresults(moviedetails moviedetails) {
        if (moviedetails == null )
            return;
//        moviedet = new moviedetails(moviedetails.getPoster_path(),moviedetails.getOverview(),moviedetails.release_date,moviedetails.getId(),moviedetails.getTitle(),moviedetails.getBackdrop_path(),moviedetails.getPopularity(),moviedetails.getVote_count(),moviedetails.getStatus())//
        Picasso.with(SecondActivity.this).load("http://image.tmdb.org/t/p/w342/" + moviedetails.getPoster_path()).into(mainimg);
        title.setText(moviedetails.getTitle());
        overview.setText(moviedetails.getOverview());
        votecount.setText(moviedetails.getVote_count());
        popularity.setText(moviedetails.getPopularity());
        releasedate.setText(moviedetails.getRelease_date());
        status.setText(moviedetails.getStatus());

    }

    public void processhelper(String[] batch) {
        if(batch == null || batch.length ==0)
            return;
        for(String a:batch){
            al.add(a);
        }
        if(batch[0].length()!=0|| batch[0]!= null)
            Picasso.with(SecondActivity.this).load("http://img.youtube.com/vi/"+batch[0]+"/hqdefault.jpg").into(trailer1);
        if(batch.length>=2) {
            Picasso.with(SecondActivity.this).load("http://img.youtube.com/vi/" + batch[1] + "/hqdefault.jpg").into(trailer2);
        }
        if(batch.length>=3) {
            Picasso.with(SecondActivity.this).load("http://img.youtube.com/vi/" + batch[2] + "/hqdefault.jpg").into(trailer3);
        }

    }
}
