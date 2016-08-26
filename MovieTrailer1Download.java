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
public class MovieTrailer1Download extends AsyncTask<String,Void,String[]>{
    SecondActivity listener;

    public MovieTrailer1Download(SecondActivity listener) {
        this.listener = listener;
    }

    @Override
    protected String[] doInBackground(String... params) {
        if (params.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream == null)
                return null;
            Scanner s = new Scanner(inputStream);
            while (s.hasNext()) {
                stringBuffer.append(s.nextLine());
            }
            Log.i("json", stringBuffer.toString());

        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        return parseJson(stringBuffer.toString());
    }

    private String[] parseJson(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray course = obj.getJSONArray("results");
            String[] output = new String[course.length()];
            for (int i = 0; i < output.length; i++) {
                JSONObject batchesJson = course.getJSONObject(i);
                String courses = batchesJson.getString("key");
                output[i] = courses;
            }
            return output;
        } catch (JSONException e) {
            return null;
        }

    }
    @Override
    protected void onPostExecute(String[] batch) {
        listener.processhelper(batch);
    }
}
