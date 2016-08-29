package in.codingninjas.itsmovietime2;

/**
 * Created by LALIT GULIA on 7/5/2016.
 */
public class MovieListDetails {
    String poster_path;
    String id;
    String title;

    public MovieListDetails(String poster_path, String id, String title) {
        this.poster_path = poster_path;
        this.id = id;
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
