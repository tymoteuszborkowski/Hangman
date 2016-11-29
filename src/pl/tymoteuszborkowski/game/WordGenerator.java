package pl.tymoteuszborkowski.game;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class WordGenerator implements Runnable {

    private static final String DICTIONARY_PATH = "resources/dictionary.txt";
    private static final Charset CHARSET = Charset.forName("ISO-8859-1");

    private final Random random;
    private final Path path;

    public WordGenerator() {
        path = Paths.get(DICTIONARY_PATH);
        random = new Random(47);
    }


    @Override
    public void run() {
        List<String> dictionary = getDictionary();

        // generateWord(List<String> dictionary); //todo

    }


    private List<String> getDictionary() {

        final List<String> words = new ArrayList<>();

        try {
            Stream<String> stream = Files.lines(path, CHARSET);
            stream.forEach(words::add);
        } catch (IOException e) {
            //todo add friendly message
            e.printStackTrace();
        }


        return words;

    }


}

