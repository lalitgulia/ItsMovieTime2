package in.codingninjas.itsmovietime2;

/**
 * Created by LALIT GULIA on 6/30/2016.
 */
public class moviedetails {

    String poster_path;
    String overview;
    String release_date;
    String id;
    String title;
    String backdrop_path;
    String popularity;
    String vote_count;
    String status;

    public moviedetails(String poster_path, String overview, String release_date, String id, String title, String backdrop_path, String popularity, String vote_count, String status) {
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
        this.id = id;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.status = status;
    }


    public String getPoster_path() {
        return poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getVote_count() {
        return vote_count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

}
