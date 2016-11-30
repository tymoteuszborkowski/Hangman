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

public class WordGenerator {

    private static final String DICTIONARY_PATH = "resources/dictionary.txt";
    private static final Charset CHARSET = Charset.forName("ISO-8859-1");

    private final Random random;
    private final Path path;
    private final List<String> words = new ArrayList<>();

    public WordGenerator() {
        path = Paths.get(DICTIONARY_PATH);
        random = new Random(47);

        fillDictionaryList();
    }


    public String generateWord(){
        String word = "";

        if(!words.isEmpty()){
            word = words.get(random.nextInt(words.size()-1));
        }
        return word;
    }



    private void fillDictionaryList() {

        try {
            Stream<String> stream = Files.lines(path, CHARSET);
            stream.forEach(words::add);
        } catch (IOException e) {
            //todo add friendly message
            e.printStackTrace();
        }
    }


}

