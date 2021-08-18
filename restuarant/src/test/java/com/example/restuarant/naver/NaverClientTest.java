package com.example.restuarant.naver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restuarant.naver.dto.SearchImageReq;
import com.example.restuarant.naver.dto.SearchLocalReq;

@SpringBootTest
public class NaverClientTest {
	@Autowired
	private NaverClient client;
	
	@Test
	public void localSearchTest() {
		var search = new SearchLocalReq();
		search.setQuery("갈비");
		
		var result = client.localSearch(search);
		System.out.println("@ result: "+result);
	}

	@Test
	public void imageSearchTest() {
		var search = new SearchImageReq();
		search.setQuery("갈비집");
		
		var result = client.imageSearch(search);
		System.out.println("@ result: "+result);
	}
	
	
}
