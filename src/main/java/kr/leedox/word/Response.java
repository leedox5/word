package kr.leedox.word;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private int status;
    private String message;
}
