package kr.leedox.word;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Meaning {
    private Long id;
    private String meaning;
}
