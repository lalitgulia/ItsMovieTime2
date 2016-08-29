package in.codingninjas.itsmovietime2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
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
    Button imdb;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Second Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://in.codingninjas.itsmovietime2/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Second Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://in.codingninjas.itsmovietime2/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
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
        imdb = (Button) findViewById(R.id.imdb);
        String id = getIntent().getStringExtra("id");
        final String title = getIntent().getStringExtra("title");
        imdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.co.in/#q="+title); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        trailer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query="+title)));
            }
        });
        trailer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query="+title)));
            }
        });
        trailer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query="+title)));
            }
        });
        String url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=7450a37e8c295dc1b11d1ac6bdef70b9";
        SingleMovieDetailsDownload task2 = new SingleMovieDetailsDownload(this);
        task2.execute(url);
        //     al = new ArrayList<>();

        String url2 = "https://api.themoviedb.org/3/movie/" + id + "/videos?api_key=7450a37e8c295dc1b11d1ac6bdef70b9";
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


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
        if (moviedetails == null)
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
        if (batch == null || batch.length == 0)
            return;
        for (String a : batch) {
            al.add(a);
        }
        if (batch[0].length() != 0 || batch[0] != null)
            Picasso.with(SecondActivity.this).load("http://img.youtube.com/vi/" + batch[0] + "/hqdefault.jpg").into(trailer1);
        if (batch.length >= 2) {
            Picasso.with(SecondActivity.this).load("http://img.youtube.com/vi/" + batch[1] + "/hqdefault.jpg").into(trailer2);
        }
        if (batch.length >= 3) {
            Picasso.with(SecondActivity.this).load("http://img.youtube.com/vi/" + batch[2] + "/hqdefault.jpg").into(trailer3);
        }

    }
}
