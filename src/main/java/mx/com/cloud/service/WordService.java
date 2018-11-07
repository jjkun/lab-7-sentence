package mx.com.cloud.service;

import mx.com.cloud.domain.Word;

public interface WordService {
	public Word getSubject();
	public Word getVerb();
	public Word getArticle();
	public Word getAdjective();
	public Word getNoun();
}
