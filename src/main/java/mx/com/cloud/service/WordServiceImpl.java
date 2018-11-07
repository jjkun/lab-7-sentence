package mx.com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import mx.com.cloud.dao.AdjectiveClient;
import mx.com.cloud.dao.ArticleClient;
import mx.com.cloud.dao.NounClient;
import mx.com.cloud.dao.SubjectClient;
import mx.com.cloud.dao.VerbClient;
import mx.com.cloud.domain.Word;

@Service
public class WordServiceImpl implements WordService {

	@Autowired private VerbClient verbClient;
	@Autowired private SubjectClient subjectClient;
	@Autowired private ArticleClient articleClient;
	@Autowired private AdjectiveClient adjectiveClient;
	@Autowired private NounClient nounClient;
	
	
	@Override
	@HystrixCommand(fallbackMethod="getSubjectFallBack")
	public Word getSubject() {
		
		return subjectClient.getWord();
	}
	
	public Word getSubjectFallBack() {
		return new Word("Someone");
	}
	
	@Override
	public Word getVerb() {
		return verbClient.getWord();
	}
	
	@Override
	public Word getArticle() {
		return articleClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getAdjectiveFallBack")
	public Word getAdjective() {
		return adjectiveClient.getWord();
	}
	
	public Word getAdjectiveFallBack() {
		return new Word("");
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getNounFallBack")
	public Word getNoun() {
		return nounClient.getWord();
	}	
	
	public Word getNounFallBack() {
		return new Word("something");
	}

}
