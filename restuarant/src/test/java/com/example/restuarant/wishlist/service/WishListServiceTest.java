package com.example.restuarant.wishlist.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListServiceTest {
	
	@Autowired
	private WishListService wishlistService;
	
	@Test 
	public void searchTest() {
		var result = wishlistService.search("갈비");
		System.out.println("@ searchTest: "+result);
		
		Assertions.assertNotNull(result);
	}
}
