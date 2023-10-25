package kr.leedox.word;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageInfo {
    private Long totalElements;
    private int totalPages;
}
