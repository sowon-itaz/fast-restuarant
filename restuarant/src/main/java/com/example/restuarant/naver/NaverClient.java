package com.example.restuarant.naver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.restuarant.naver.dto.SearchImageReq;
import com.example.restuarant.naver.dto.SearchImageRes;
import com.example.restuarant.naver.dto.SearchLocalReq;
import com.example.restuarant.naver.dto.SearchLocalRes;

import lombok.extern.slf4j.Slf4j;

/* env와 같이 스프링에서 yaml파일의 내용을 @Value로 들고 올수있다.
 * */
@Slf4j
@Component
public class NaverClient {

	@Value("${naver.client.id}")
	private String naverClientId;

	@Value("${naver.client.secret}")
	private String naverClientSecret;

	@Value("${naver.url.search.local}")
	private String naverLocalSearchUrl;

	@Value("${naver.url.search.image}")
	private String naverImageSearchUrl;

	public SearchLocalRes localSearch(SearchLocalReq searchLocalReq) {
		var uri = UriComponentsBuilder
				.fromUriString(naverLocalSearchUrl)
				.queryParams(searchLocalReq.toMultiValueMap())
				.build()
				.encode()
				.toUri();
		log.info("localSearch uri: {}, uri");
		
		// header 셋팅하기
		var headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", naverClientId);
		headers.set("X-Naver-Client-Secret", naverClientSecret);
		headers.setContentType(MediaType.APPLICATION_JSON);

		// header 넣어주기
		var httpEntity = new HttpEntity<>(headers);
		
		// responseType를 SearchLocalRes로 정의하기
		var responseType = new ParameterizedTypeReference<SearchLocalRes>() {};
		
		// RestTemplate에 만든거 다 넣기
		var responseEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, responseType);
		return responseEntity.getBody();
		
	}

	public SearchImageRes imageSearch(SearchImageReq searchImageReq) {
		var uri = UriComponentsBuilder
				.fromUriString(naverImageSearchUrl)
				.queryParams(searchImageReq.toMultiValueMap())
				.build()
				.encode()
				.toUri();
		log.info("imageSearch uri: {}, uri");
		
		// header 셋팅하기
		var headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", naverClientId);
		headers.set("X-Naver-Client-Secret", naverClientSecret);
		headers.setContentType(MediaType.APPLICATION_JSON);

		// header 넣어주기
		var httpEntity = new HttpEntity<>(headers);
		
		// responseType을 SearchImageRes로 정의하기
		var responseType = new ParameterizedTypeReference<SearchImageRes>() {};
		
		// RestTemplate에 만든거 다 넣기
		var responseEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, responseType);
		
		return responseEntity.getBody();
	}
}
