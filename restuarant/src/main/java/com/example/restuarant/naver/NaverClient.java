package com.example.restuarant.naver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* env와 같이 스프링에서 yaml파일의 내용을 @Value로 들고올수있다.
 * */
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
    
    public void localSearch() {
    	
    }

    public void imageSearch() {
    	
    }
}
