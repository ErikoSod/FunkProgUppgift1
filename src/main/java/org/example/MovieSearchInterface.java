package org.example;

@FunctionalInterface
public interface MovieSearchInterface <T> {

    T search(Movie m);

}
