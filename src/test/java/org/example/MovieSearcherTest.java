package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class MovieSearcherTest {

    MovieSearcher movieSearcher = new MovieSearcher();
    MoveDataBaseTest moveDataBaseTest = new MoveDataBaseTest();
    List<Movie> moviesTest = moveDataBaseTest.getMovies();
    List<Movie> moviesDoubleTest = moveDataBaseTest.getMoviesDouble();
    List<Movie> moviesSingleTest = moveDataBaseTest.getMoviesSingle();



    @Test
    void listHaveTwoOfTheSameTitle(){
        assertTrue(movieSearcher.multipleTitles(moviesTest));
    }

    @Test
    void listHaveFourOfTheSameTitle(){
        assertTrue(movieSearcher.multipleTitles(moviesDoubleTest));
    }

    @Test
    void listHaveZeroOfTheSameTitle(){
        assertFalse(movieSearcher.multipleTitles(moviesSingleTest));
    }

    @Test
    void oneMovieYearNineteenSeventyFive(){
        assertEquals(1,movieSearcher.movieMadeYear(moviesTest,1975));
        assertEquals(2,movieSearcher.movieMadeYear(moviesDoubleTest,1975));
    }

    @Test
    void sixUniqGenre(){
        assertEquals(6,movieSearcher.movieAmountOfUniqGenre(moviesTest));
        assertEquals(6,movieSearcher.movieAmountOfUniqGenre(moviesDoubleTest));
        assertNotEquals(12,movieSearcher.movieAmountOfUniqGenre(moviesDoubleTest));
    }
    @Test
    void highRatedCast(){
        List<String> highRatedCast = new ArrayList<>();
        highRatedCast.add("Jane Gail");
        highRatedCast.add("Winsor McCay");
        highRatedCast.add("Ethel Grandin");
        highRatedCast.add("Matt Moore");
        highRatedCast.sort(String.CASE_INSENSITIVE_ORDER);
        assertEquals(highRatedCast,movieSearcher.highestRatedActors(moviesTest));
    }

    @Test
    void doubleListHighRatedCast(){
        List<String> highRatedCastDouble = new ArrayList<>();
        highRatedCastDouble.add("Jane Gail");
        highRatedCastDouble.add("Winsor McCay");
        highRatedCastDouble.add("Ethel Grandin");
        highRatedCastDouble.add("Matt Moore");
        highRatedCastDouble.add("Jane Gail");
        highRatedCastDouble.add("Winsor McCay");
        highRatedCastDouble.add("Ethel Grandin");
        highRatedCastDouble.add("Matt Moore");
        highRatedCastDouble.sort(String.CASE_INSENSITIVE_ORDER);
        assertEquals(highRatedCastDouble,movieSearcher.highestRatedActors(moviesDoubleTest));
    }

    @Test
    void singleListHighRatedCast(){
        List<String> highRatedCastDouble = new ArrayList<>();
        highRatedCastDouble.add("A.C. Abadie");
        highRatedCastDouble.add("Gilbert M. 'Broncho Billy' Anderson");
        highRatedCastDouble.add("George Barnes");
        highRatedCastDouble.add("Justus D. Barnes");
        highRatedCastDouble.sort(String.CASE_INSENSITIVE_ORDER);
        assertEquals(highRatedCastDouble,movieSearcher.highestRatedActors(moviesSingleTest));
    }

    @Test
    void twentyFiveMaxRuntime (){
        assertEquals(25,movieSearcher.movieMaxRuntimeSearch(moviesTest));
        assertEquals(25,movieSearcher.movieMaxRuntimeSearch(moviesDoubleTest));
        assertNotEquals(50,movieSearcher.movieMaxRuntimeSearch(moviesDoubleTest));
    }

    @Test
    void resultIsACornerInWheat(){
        assertEquals("A Corner in Wheat",movieSearcher.movieWithLowestAmountOfActors(moviesTest));
        assertEquals("A Corner in Wheat, A Corner in Wheat",movieSearcher.movieWithLowestAmountOfActors(moviesDoubleTest));
    }

    @Test
    void twoActorsInMoreThenOneMovie (){
        assertEquals(2,movieSearcher.moreThenOneMovieActorsAmount(moviesTest));
    }

    @Test
    void fourTeenActorsInMoreThenOneMovieDoubleList (){
        assertEquals(14,movieSearcher.moreThenOneMovieActorsAmount(moviesDoubleTest));
        assertNotEquals(4,movieSearcher.moreThenOneMovieActorsAmount(moviesDoubleTest));
    }

    @Test
    void actorInMostMoviesIsWinsorMcCay(){
        assertEquals("Winsor McCay",movieSearcher.actorInMostFilms(moviesTest));
        assertEquals("Winsor McCay",movieSearcher.actorInMostFilms(moviesDoubleTest));
        assertNotEquals("Winsor McCay, Winsor McCay",movieSearcher.actorInMostFilms(moviesDoubleTest));
    }

    @Test
    void fourDifferentLanguages(){
        assertEquals(4,movieSearcher.numberOfLanguages(moviesTest));
        assertEquals(4,movieSearcher.numberOfLanguages(moviesDoubleTest));
        assertNotEquals(8,movieSearcher.numberOfLanguages(moviesDoubleTest));
    }
}