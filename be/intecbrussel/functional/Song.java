package be.intecbrussel.functional;

import java.util.stream.Stream;

public class Song {

    private Stream<String> lyrics = Stream.of(
            "Who let the dogs out??",
            "WHOOO HUU HUU",
            "HOO HOO HOO"
    );

    public Stream<String> getLyrics() {
        return lyrics;
    }

    public void setLyrics(Stream<String> lyrics) {
        this.lyrics = lyrics;
    }
}
