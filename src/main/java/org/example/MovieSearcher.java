package org.example;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class MovieSearcher {

    private final boolean MAX = true;
    private final boolean MIN = false;

    private final MovieSearchInterface<Double> runtimeSearch = m-> (double)m.getRuntime();
    private final MovieSearchInterface<Double> imdbRatingSearch = Movie::getImdbRating;
    private final MovieSearchInterface<List<String>> castSearch = Movie::getCast;
    private final MovieSearchInterface<List<String>> genreSearch = Movie::getGenres;
    private final MovieSearchInterface<List<String>> languageSearch = Movie::getLanguages;


    public double movieSearchMaxOrMinCount(List<Movie> movies, MovieSearchInterface<Double> msi, boolean max) {

        if(max){
            return movies.stream().mapToDouble(msi::search).max().orElse(0);
        }else {
            return movies.stream().mapToDouble(msi::search).min().orElse(0);
        }
    }

    public long movieSearchFlatMapUniqCount(List<Movie> movies, MovieSearchInterface<List<String>> msi){

        return movies.stream().flatMap(m -> msi.search(m).stream()).distinct().count();
    }

    public Set<Map.Entry<String,Long>> movieSearchFlatMapGroupCount(List<Movie> movies, MovieSearchInterface<List<String>> msi){

        return movies.stream().flatMap(m -> msi.search(m).stream())
                .collect(groupingBy(c -> c, Collectors.counting()))
                .entrySet();
    }

    public long movieMade1975(List<Movie> movies,int year){
        return movies.stream().filter(m->m.getYear()==year).count(); //ändra
    }

    public double movieMaxRuntimeSearch (List<Movie> movies){
        return movieSearchMaxOrMinCount(movies,runtimeSearch, MAX);
    }

    public long movieAmountOfUniqGenre(List<Movie> movies){
        return movieSearchFlatMapUniqCount(movies,genreSearch);
    }

    public List<String> highestRatedActors(List<Movie> movies){
        return movies.stream()
                .filter(m -> imdbRatingSearch.search(m) == movieSearchMaxOrMinCount(movies,imdbRatingSearch, MAX))
                .flatMap(m -> m.getCast().stream()).sorted()
                .toList();
    }

    public String movieWithLowestAmountOfActors(List<Movie> movies){
        return movies.stream()
                .filter(m -> castSearch.search(m).size() == movieSearchMaxOrMinCount(movies, mo -> (double)castSearch.search(mo).size(), MIN))
                .toList().stream().map(Movie::getTitle)
                .collect(Collectors.joining(", "));
    }

    public long moreThenOneMovieActorsAmount(List<Movie> movies){
        return movieSearchFlatMapGroupCount(movies,castSearch)
                .stream().filter(c -> c.getValue() > 1).count();
    }

    public String actorInMostFilms(List<Movie> movies){
        return movieSearchFlatMapGroupCount(movies,castSearch)
                .stream().max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    public long numberOfLanguages(List<Movie> movies){
        return movieSearchFlatMapUniqCount(movies,languageSearch);
    }

    public boolean multipleTitles(List<Movie> movies) {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getTitle, Collectors.counting())).entrySet()
                .stream().anyMatch(c ->c.getValue() >1);
    }
}
