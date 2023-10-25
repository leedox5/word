package kr.leedox.word;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WordsResponse {
    private List<Word> words;
    private PageInfo pageInfo;
}
