package kr.leedox.word;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WordResponse {
    private String word;
    private List<Meaning> meanings;
}
