package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import java.io.FileInputStream;
import java.util.*;

public class MongoDBAtlasDownloadExample {

    private final List<Movie> movieList = new ArrayList<>();

    public MongoDBAtlasDownloadExample() {

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/java/org/example/info.properties"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not found!");
        }
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String databaseString = prop.getProperty("database");
        //Skriv in rätt url!
        String uri = "mongodb+srv://"+user+":"+password+"@"+databaseString+".mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> moviesCollection = database.getCollection("movies");

            //Get all movies from 1975
            for (Document doc : moviesCollection.find(new Document("year", 1975))) {
                {
                    movieList.add(Movie.fromDocument(doc));
                }
            }

            /* //Skriver ut alla filmer
            for (Movie movie : movieList) {
                System.out.println(movie);
            }*/

            //Här gör du anrop till alla dina funktioner som ska skriva ut svaren på frågorna som
            //efterfrågas i uppgiften
            MovieSearcher ms = new MovieSearcher();

            //Hur många filmer gjordes 1975 (enligt vårt data). Returnera ett tal :107
            System.out.println("Filmer gjorda 1975: "+ms.movieMadeYear(movieList,1975));

            //Hitta längden på den film som var längst (högst runtime). Returnera ett tal. :230
            System.out.println("Längsta speltiden: "+ms.movieMaxRuntimeSearch(movieList));

            //Hur många UNIKA genrer hade filmerna från 1975. Returnera ett tal. :19
            System.out.println("Antal unika genrer: "+ms.movieAmountOfUniqGenre(movieList));

            //Vilka skådisar som spelade i den film som hade högst imdb-rating. Returnera en List<String> med deras namn.
            System.out.println("Skådespelare med i filmen med högst imdb betyg: "+ms.highestRatedActors(movieList));

            //Vad är titeln på den film som hade minst antal skådisar listade? Returnera en String.
            //:La batalla de Chile: La lucha de un pueblo sin armas - Primera parte: La insurrecièn de la burguesèa
            System.out.println("Film med minst antal skådespelare: "+ms.movieWithLowestAmountOfActors(movieList));

            //Hur många skådisar var med i mer än 1 film? Returnera ett tal. :30
            System.out.println("Antal skådespelare i fler än en film: "+ms.moreThenOneMovieActorsAmount(movieList));

            //Vad hette den skådis som var med i flest filmer? Returnera en String :Gene Hackman
            System.out.println("Skådespelare i flest antal filmer: "+ms.actorInMostFilms(movieList));

            //Hur många UNIKA språk har filmerna? Returnera ett tal. :22
            System.out.println("Antal unika språk: "+ms.numberOfLanguages(movieList));

            //Finns det någon titel som mer än en film har? Returnera en bool. :true
            System.out.println("Finns det filmer med samma title?: "+ms.multipleTitles(movieList));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        MongoDBAtlasDownloadExample m = new MongoDBAtlasDownloadExample();
    }
}