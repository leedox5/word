package kr.leedox.word;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Word word1 = Word.builder().id(1L).word("10010").meaning("소개").build();
        Word word2 = Word.builder().id(2L).word("10020").meaning("축하").build();
        Word word3 = Word.builder().id(3L).word("10030").meaning("redirect:/book/").build();
        return List.of(word1, word2, word3);
    }

    public Word getWordById(Long id) {
        String [] arr = {
           "[2022.09.21] 단어장 오픈",
           "[2023.08.21] 페이징 처리",
           "[2023.09.13] 오픈단어장 추가",
           "[2023.09.19] 단어장 생성 기능",
        };

        Word word = Word.builder().id(id).word("10010").meaning("소개").build();
        Meaning meaning1 = Meaning.builder().id(100L).meaning("Hello! \n Welcome to wordbook service").build();
        Meaning meaning2 = Meaning.builder().id(101L).meaning(String.join("\n", arr)).build();
        word.setMeanings(List.of(meaning1, meaning2));
        return word;
    }

    public Page<Word> getWords(String opt, String key, int page) {
        List<Word> words = new ArrayList<>();
        if("*".equals(key)) {
            words = getStubWords();
        } else {
            if("eng".equals(opt)) {
                words = getStubWords().stream().filter(word -> word.getWord().contains(key))
                        .collect(Collectors.toList());
            } else {
                words = getStubWords().stream().filter(word -> word.getMeaning().contains(key))
                        .collect(Collectors.toList());
            }
        }

        PageRequest pageRequest = PageRequest.of(page, 10);
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), words.size());
        return new PageImpl<>(words.subList(start, end), pageRequest, words.size());
    }

    private List<Word> getStubWords() {
        List<Word> words = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            words.add(buildWord(i));
        }
        return words;
    }

    private Word buildWord(int i) {
        return Word.builder().id((long) i).word(String.format("WORD %d", i)).meaning(String.format("MEANING %d", i)).build();
    }

}
