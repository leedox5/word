package kr.leedox.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class DemoController {

    @Autowired
    UserService userService;

    @Autowired
    WordService wordService;

    @GetMapping("/demo")
    public ResponseEntity<String> hello(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user.getName());
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

    @GetMapping("/words")
    public ResponseEntity<?> words() {
        List<Word> words = wordService.getWords();
        return ResponseEntity.ok(words);
    }

    @PutMapping("/user")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest req) {
        User user = userService.update(req);
        UserResponse res = UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName()).build();
        return ResponseEntity.ok(res);
    }
}


