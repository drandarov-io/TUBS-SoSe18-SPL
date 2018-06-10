package de.tubs.hirakanaji;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.core.RomajiDataSet.*;
import static de.tubs.hirakanaji.core.HiraganaDataSet.*;
import static de.tubs.hirakanaji.core.KatakanaDataSet.*;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
@SuppressWarnings("Duplicates")
public class HirakanajiApplication {

    private static List<String> properties;

    public static void main(String[] args) {
        properties = Arrays.asList(args);

        /* Scrambler */
        String[][] dataSet;

        // Romaji
        dataSet = Stream.of(romajiChars)
            .flatMap(Stream::of).toArray(String[][]::new);
        // Romaji - Gojuuon
        dataSet = Stream.of(dataSet, romajiGojuuon)
                .flatMap(Stream::of).toArray(String[][]::new);
        // Romaji - GojuuonWithDakuten
        dataSet = Stream.of(dataSet, romajiGojuuonDakuten)
                .flatMap(Stream::of).toArray(String[][]::new);
        // Romaji - Youon
        dataSet = Stream.of(dataSet, romajiYouon)
                .flatMap(Stream::of).toArray(String[][]::new);
        // Romaji - YouonWithDakuten
        dataSet = Stream.of(dataSet, romajiYouonDakuten)
                .flatMap(Stream::of).toArray(String[][]::new);
        printSyllables(dataSet);

        // Hiragana
        dataSet = Stream.of(hiraganaChars)
                .flatMap(Stream::of).toArray(String[][]::new);
        // Hiragana - Gojuuon
        dataSet = Stream.of(dataSet, hiraganaGojuuon)
                .flatMap(Stream::of).toArray(String[][]::new);
        // Hiragana - GojuuonWithDakuten
        dataSet = Stream.of(dataSet, hiraganaGojuuonDakuten)
                .flatMap(Stream::of).toArray(String[][]::new);
        // Hiragana - Youon
        dataSet = Stream.of(dataSet, hiraganaYouon)
                .flatMap(Stream::of).toArray(String[][]::new);
        // Hiragana - YouonWithDakuten
            dataSet = Stream.of(dataSet, hiraganaYouonDakuten)
                    .flatMap(Stream::of).toArray(String[][]::new);
        printSyllables(dataSet);

        // Katakana
        dataSet = Stream.of(katakanaChars)
                .flatMap(Stream::of).toArray(String[][]::new);
        // Katakana - Gojuuon
        dataSet = Stream.of(dataSet, katakanaGojuuon)
                .flatMap(Stream::of).toArray(String[][]::new);
        // Katakana - GojuuonWithDakuten
        dataSet = Stream.of(dataSet, katakanaGojuuonDakuten)
                .flatMap(Stream::of).toArray(String[][]::new);
        // Katakana - Youon
        dataSet = Stream.of(dataSet, katakanaYouon)
                .flatMap(Stream::of).toArray(String[][]::new);
        // Katakana - YouonWithDakuten
        dataSet = Stream.of(dataSet, katakanaYouonDakuten)
                .flatMap(Stream::of).toArray(String[][]::new);
        printSyllables(dataSet);
    }

    public static List<String> getProperties() {
        return properties;
    }

    private static void printSyllables(String[][] dataSet) {
        int minSyllableCount = 2;   // Min. number of syllables per line (e.g. "ba ka")
        int maxSyllableCount = 5;   // Max. number of syllables per line (e.g. "ha hi fu he ho")
        int wordCount = 20;         // Amount of generated lines
        int syllable;               // Variable syllable of dataSet

        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < wordCount; i++) {
            for (int j = 0; j < random.nextInt(minSyllableCount, maxSyllableCount + 1); j++) {
                System.out.print(dataSet[syllable = random.nextInt(0, dataSet.length)]
                        [random.nextInt(0, dataSet[syllable].length)]);
            }
            System.out.println(/*"\n"*/);
        }
    }

}
