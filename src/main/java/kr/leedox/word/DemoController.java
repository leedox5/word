package kr.leedox.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class DemoController {

    @Autowired
    WordService wordService;

    @GetMapping("/demo")
    public ResponseEntity<String> hello(@AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(user.getUsername());
    }

    @GetMapping("/intro")
    public ResponseEntity<?> intro() {
        Word word = wordService.getWord("10010");
        WordResponse wordResponse = WordResponse.builder()
                .word("10010")
                .meanings(word.getMeanings())
                .build();
        return ResponseEntity.ok(wordResponse);
    }
}


