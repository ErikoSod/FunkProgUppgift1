package org.example;

import java.util.ArrayList;
import java.util.List;

public class MoveDataBaseTest {

    private final List<Movie> movies = new ArrayList<>();
    private final List<Movie> moviesDouble = new ArrayList<>();
    private final List<Movie> moviesSingle = new ArrayList<>();

    public MoveDataBaseTest (){

        List<String> genre1 = new ArrayList<>();
        genre1.add("Short");
        genre1.add("Western");
        List<String> cast1 = new ArrayList<>();
        cast1.add("A.C. Abadie");
        cast1.add("Gilbert M. 'Broncho Billy' Anderson");
        cast1.add("George Barnes");
        cast1.add("Justus D. Barnes");
        List<String> lang1 = new ArrayList<>();
        lang1.add("English");
        Movie m1 = new Movie("573a1390f29313caabcd42e8",
                "The Great Train Robbery",
                1903,
                genre1,
                "Edwin S. Porter",
                cast1,
                7.4,
                lang1,
                11);
        movies.add(m1);
        moviesDouble.add(m1);
        moviesDouble.add(m1);
        moviesSingle.add(m1);

        List<String> genre2 = new ArrayList<>();
        genre2.add("Short");
        genre2.add("Drama");
        List<String> cast2 = new ArrayList<>();
        cast2.add("Frank Powell");
        cast2.add("Grace Henderson");
        cast2.add("James Kirkwood");
        cast2.add("Linda Arvidson");
        List<String> lang2 = new ArrayList<>();
        lang2.add("English");
        Movie m2 = new Movie("573a1390f29313caabcd446f",
                "A Corner in Wheat",
                1909,
                genre2,
                "Edwin S. Porter",
                cast2,
                6.6,
                lang2,
                14);
        movies.add(m2);
        moviesDouble.add(m2);
        moviesDouble.add(m2);

        List<String> genre3 = new ArrayList<>();
        genre3.add("Short");
        genre3.add("Animation");
        genre3.add("Drama");
        List<String> cast3 = new ArrayList<>();
        cast3.add("Winsor McCay");
        List<String> lang3 = new ArrayList<>();
        lang3.add("English");
        lang3.add("Swedish");
        //lang.add("English");
        Movie m3 = new Movie("573a1390f29313caabcd4803",
                "A Corner in Wheat",
                1911,
                genre3,
                "J. Stuart Blackton",
                cast3,
                6.6,
                lang3,
                7);
        movies.add(m3);
        moviesDouble.add(m3);
        moviesDouble.add(m3);

        List<String> genre4 = new ArrayList<>();
        genre4.add("Crime");
        genre4.add("Drama");
        List<String> cast4 = new ArrayList<>();
        cast4.add("Jane Gail");
        cast4.add("Winsor McCay");
        cast4.add("Ethel Grandin");
        cast4.add("Matt Moore");
        List<String> lang4 = new ArrayList<>();
        lang4.add("English");
        lang4.add("Dannish");
        Movie m4 = new Movie("573a1390f29313caabcd4803",
                "Traffic in Souls",
                1911,
                genre4,
                "J. Stuart Blackton",
                cast4,
                9.1,
                lang4,
                20);
        movies.add(m4);
        moviesDouble.add(m4);
        moviesDouble.add(m4);

        List<String> genre5 = new ArrayList<>();
        genre5.add("Crime");
        genre5.add("Science Fiction");
        List<String> cast5 = new ArrayList<>();
        cast5.add("Jim Carry");
        cast5.add("Winsor McCay");
        cast5.add("Clint Eastwood");
        cast5.add("Matt Moore");
        List<String> lang5 = new ArrayList<>();
        lang5.add("English");
        lang5.add("Finnish");
        Movie m5 = new Movie("573a1390f29313caabcd4eaf",
                "Made-up-Movie",
                1975,
                genre5,
                "Big Erik",
                cast5,
                7.1,
                lang5,
                25);
        movies.add(m5);
        moviesDouble.add(m5);
        moviesDouble.add(m5);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Movie> getMoviesDouble(){
        return moviesDouble;
    }

    public List<Movie> getMoviesSingle() {
        return moviesSingle;
    }
}
