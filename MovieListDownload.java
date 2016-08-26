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
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by LALIT GULIA on 7/5/2016.
 */
public class MovieListDownload extends AsyncTask<String,Void,MovieListDetails[]> {
    MainActivity listener;
    public MovieListDownload(MainActivity listener){
        this.listener = listener;
    }

    @Override
    protected MovieListDetails[] doInBackground(String... params) {
        if(params.length == 0){
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try{
            URL url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream == null)
                return null;
            Scanner s = new Scanner(inputStream);
            while (s.hasNext()){
                stringBuffer.append(s.nextLine());
            }
            Log.i("json",stringBuffer.toString());
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }


        return parsejson(stringBuffer.toString());
    }

    private MovieListDetails[] parsejson(String json){
        try{
            JSONObject obj = new JSONObject(json);
            JSONArray results = obj.getJSONArray("results");
            MovieListDetails[] movies = new MovieListDetails[results.length()];
            for(int i = 0;i<results.length();i++){
                JSONObject details = results.getJSONObject(i);
                String poster = details.getString("poster_path");
                String iddetails = details.getString("id");
                movies[i] = new MovieListDetails(poster,iddetails);
            }
            return movies;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(MovieListDetails[] movie) {
        listener.processResults(movie);
    }
}


