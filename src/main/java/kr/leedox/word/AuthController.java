package kr.leedox.word;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    WordService wordService;

    private final AuthenticationService service;

    @GetMapping("/intro")
    public ResponseEntity<?> intro() {
        Word word = wordService.getWord("10010");
        WordResponse wordResponse = WordResponse.builder()
                .word("10010")
                .meanings(word.getMeanings())
                .build();
        return ResponseEntity.ok(wordResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody UserRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }

}
