package be.intecbrussel.functional;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSandoxApp {

    public static void main(String[] args) {

        String[] classicalMusicArray = new String[]{
                "Mozart - Serenade No. 13 for strings in G Major",
                // "Mozart" - "Serenade No. 13 for strings in G Major" String[]
                "Beethoven - Für Elise",
                "Puccini - O mio babbino caro",
                "J.S. Bach - Toccata and Fugue in D Minor",
                "Beethoven - Symphony No.5 in C minor"
        };

        //   "Mozart - Serenade No. 13 for strings in G Major" # "Beethoven - Für Elise" # "Puccini - O mio babbino caro" # "J.S. Bach - Toccata and Fugue in D Minor" # "Beethoven - Symphony No.5 in C minor"

        // TODO:


        System.out.println("--------------------------------- TASK 1 ------------------------------------------------------");

        // 1- use streams: convert array to stream
        Stream<String> classicalMusicStream = Arrays.stream(classicalMusicArray);

        System.out.println("--------------------------------- TASK 2 ------------------------------------------------------");

        // 2- map: convert every music string to music + index of the music
        /** "1) Mozart - Serenade No. 13 for strings in G Major",
         "2) Beethoven - Für Elise",
         "3) Puccini - O mio babbino caro",
         "4) J.S. Bach - Toccata and Fugue in D Minor",
         "5) Beethoven - Symphony No.5 in C minor" */


        AtomicInteger counter = new AtomicInteger(0);
        Stream<String> musicStreamWithOrderNo = classicalMusicStream.map(music -> {
            System.out.println("Music numbers are added to the stream..");
            return counter.incrementAndGet() + ": " + music;
        });

        System.out.println("--------------------------------- TASK 3 ------------------------------------------------------");

        // 3- map one more convert string to String[][3] with 2D ..
        /**  "1:", "Mozart", "Serenade No. 13 for strings in G Major",
         "2:", "Beethoven", "Für Elise",
         "3:", "Puccini", "O mio babbino caro",
         "4:", "J.S. Bach", "Toccata and Fugue in D Minor",
         "5:", "Beethoven", "Symphony No.5 in C minor" */

        Stream<String[]> splittedMusicStream = musicStreamWithOrderNo.map(music -> {
            // "1) Mozart "  ,   " Serenade No. 13 for strings in G Major"

            String[] splittedArray = music.split("-");
            String firstPart = splittedArray[0];
            String third = splittedArray[1];

            String[] splittedFirstPartArray = firstPart.split(":");
            String first = splittedFirstPartArray[0];
            String second = splittedFirstPartArray[1];

            String[] fullSplit = {first, second, third};

            System.out.println("Music stream are splitted into String arrays..");

            return fullSplit;

        });

        System.out.println("--------------------------------- TASK 4 ------------------------------------------------------");

        // 4- print every music in the stream
        splittedMusicStream.forEach(splittedMusic -> System.out.println(Arrays.toString(splittedMusic)));

//        splittedMusicStream.forEach(splittedMusic -> System.out.println(Arrays.toString(splittedMusic)));


        System.out.println("--------------------------------- ALL TASKS IN ONE INSTRUCTION ------------------------------------------------------");

        Arrays
                .stream(classicalMusicArray)
                .map(music -> {
                    System.out.println("Music numbers are added to the stream..");
                    return counter.incrementAndGet() + ": " + music;
                })
                .map(music -> {
                    // "1) Mozart "  ,   " Serenade No. 13 for strings in G Major"

                    String[] splittedArray = music.split("-");
                    String firstPart = splittedArray[0];
                    String third = splittedArray[1];

                    String[] splittedFirstPartArray = firstPart.split(":");
                    String first = splittedFirstPartArray[0];
                    String second = splittedFirstPartArray[1];

                    String[] fullSplit = {first, second, third};

                    System.out.println("Music stream are splitted into String arrays..");

                    return fullSplit;

                })
                .forEach(splittedMusic -> System.out.println(Arrays.toString(splittedMusic)));



//        String allMusicArray = "";
//        for (int musicIndex = 0; musicIndex < classicalMusicArray.length; musicIndex++) {
//            allMusicArray += classicalMusicArray[musicIndex];
//            if (musicIndex != classicalMusicArray.length - 1) {
//                allMusicArray += " # ";
//            }
//        }
//
//        System.out.println(allMusicArray);
////        System.out.println(Arrays.toString(classicalMusicArray));
//
//        System.out.println("------------------------------------------------");
//
//        Stream<String> clasicalMusicStream = Arrays.stream(classicalMusicArray);
//        String allMusicStream = clasicalMusicStream.collect(Collectors.joining(" # "));
//        System.out.println(allMusicStream);
//
//
//        System.out.println("------------------------------------------------");
//
//        System.out.println(Arrays.stream(classicalMusicArray).collect(Collectors.joining(" # ")));
//        //  System.out.println("The number of music in the stream: " + Arrays.stream(classicalMusicArray).count());
//
//
//        System.out.println("------------------------------------------------");
//
//        Arrays
//                .stream(classicalMusicArray) // make a stream from an array ..
//                .filter(music -> music.contains("Beethoven")) // filter music which has 'Beethoven' as composer..
//                .map(music -> music.split("-")) // split every (String) music as String[] to Composer and Music..
//                // for each composer and music print information ..
//                .forEach(composerAndMusic -> System.out.println("Composer:\t" + composerAndMusic[0] + ",\tMusic: " + composerAndMusic[1] + "."));


//        Stream<String> filteredMusicStream = clasicalMusicStream.filter(music -> music.contains("Beethoven"));
//        filteredMusicStream.forEach(music -> System.out.println(music));


//        for (String music : classicalMusicArray) {
//            if (music.contains("Beethoven")) {
//                System.out.println(music);
//            }
//        }


//        System.out.println("No of music in the array: " + classicalMusicArray.length);
//        System.out.println("No of music in the array: " + clasicalMusicStream.count());


//        String[][] classicalComposerAndMusic2DArray = new String[classicalMusicArray.length][2];
//        for (int musicIndex = 0; musicIndex < classicalMusicArray.length; musicIndex++) {
//            String[] composerAndMusic = classicalMusicArray[musicIndex].split("-");
//            classicalComposerAndMusic2DArray[musicIndex] = composerAndMusic;
//        }

//        System.out.println(Arrays.deepToString(classicalComposerAndMusic2DArray));

//        for (String[] composerAndMusic : classicalComposerAndMusic2DArray) {
//            System.out.println("Composer:\t" + composerAndMusic[0] + ",\tMusic: " + composerAndMusic[1] + ".");
//        }

        // PRINTS :
        // Composer: Mozart, Music: Serenade No. 13 for strings in G Major.


//        System.out.println("------------------------------------------------");
//
//        Stream<String> clasicalMusicStream = Arrays.stream(classicalMusicArray);

        // .map() convert from one object to another and return the new object..
//        Stream<String[]> classicalComposerAndMusicStream = clasicalMusicStream.map( music -> music.split("-"));
//        classicalComposerAndMusicStream.forEach(composerAndMusic ->
//                System.out.println("Composer:\t" + composerAndMusic[0] + ",\tMusic: " + composerAndMusic[1] + "."));


        // TODO: I want to split Composer name and the music.

        //        Stream<String> musicStreamWithOrderV2 = classicalMusicStream.map(music -> {
//
//            String result = "";
//
//            for (int arrayIndex = 0; arrayIndex < classicalMusicArray.length; arrayIndex++) {
//                if (classicalMusicArray[arrayIndex].equals(music)) {
//                    result = arrayIndex + ":" + music;
//                }
//            }
//
//            return result;
//
//        });


    }

}
