package kr.leedox.word;

import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.Base64;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class WordApplicationTests {

	@Value("${custom.jwt.secretKey}")
	private String secretKeyPlain;

	@Test
	void contextLoads() {

	}

	@Test
	void secretKeyTest() {
		assertThat(secretKeyPlain).isNotNull();
	}

	@Test
	void encodingTest() {
		String keyBase64Encoded = Base64.getEncoder().encodeToString(secretKeyPlain.getBytes());
		SecretKey secretKey = Keys.hmacShaKeyFor(keyBase64Encoded.getBytes());

		assertThat(secretKey).isNotNull();
	}
}
