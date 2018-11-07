package mx.com.cloud.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import mx.com.cloud.domain.Word;

@FeignClient("VERB")
public interface VerbClient {
	
	@GetMapping("/")
	public Word getWord();

}
