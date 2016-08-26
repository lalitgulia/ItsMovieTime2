package in.codingninjas.itsmovietime2;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by LALIT GULIA on 7/5/2016.
 */
public class SingleMovieDetailsDownload extends AsyncTask<String,Void,moviedetails> {

    public interface SingleMovieDetailsInterface{
        void processresults(moviedetails detail);
    }

    SingleMovieDetailsInterface listener;
    public SingleMovieDetailsDownload(SingleMovieDetailsInterface secondActivity) {
        listener = secondActivity;
    }

    @Override
    protected moviedetails doInBackground(String... params) {
        if(params.length == 0)
            return null;

        StringBuffer buffer = new StringBuffer();

        try{
            URL url = new URL(params[0]);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();;
            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream == null)
                return null;
            Scanner s = new Scanner(inputStream);
            while (s.hasNext())
                buffer.append(s.nextLine());
            Log.i("jsondata",buffer.toString());


        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return  null;
        }
        return parseJson(buffer.toString());
    }
    private moviedetails parseJson(String json) {
        try{
            JSONObject obj = new JSONObject(json);

            String poster_path = obj.getString("poster_path");
            String id = obj.getString("id");
            String overview = obj.getString("overview");
            String release_date = obj.getString("release_date");
            String title = obj.getString("title");
            String backdrop_path = obj.getString("backdrop_path");
            String popularity = obj.getString("popularity");
            String vote_count = obj.getString("vote_count");
            String status = obj.getString("status");
            moviedetails movi = new moviedetails(poster_path,overview,release_date,id,title,backdrop_path,popularity,vote_count,status);
            return movi;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(moviedetails moviedetails) {
        listener.processresults(moviedetails);
    }
}
