package kr.leedox.word;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Word {
    private Long id;
    private String word;
    private String meaning;
    private List<Meaning> meanings;
}
