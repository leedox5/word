package kr.leedox.word;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    public Word getWord(String str) {
        Word word = Word.builder()
                .word("10010")
                .meaning("INTRO")
                .build();

        Meaning meaning = Meaning.builder()
                .meaning("Hello! \n Welcome to wordbook service")
                .build();

        word.setMeanings(List.of(meaning));

        return word;
    }
}
