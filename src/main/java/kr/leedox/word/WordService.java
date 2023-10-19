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

    public List<Word> getWords() {
        Word word1 = Word.builder().word("10010").meaning("소개").build();
        Word word2 = Word.builder().word("10020").meaning("축하").build();
        Word word3 = Word.builder().word("10030").meaning("redirect:/book/").build();
        return List.of(word1, word2, word3);
    }
}
