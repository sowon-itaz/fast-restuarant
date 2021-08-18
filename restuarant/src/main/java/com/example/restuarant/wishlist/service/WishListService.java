package com.example.restuarant.wishlist.service;

import org.springframework.stereotype.Service;

import com.example.restuarant.naver.NaverClient;
import com.example.restuarant.wishlist.dto.WishListDto;
import com.example.restuarant.wishlist.repository.WishListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishListService {
    
	// private final NaverClient naverClient;
    private final WishListRepository wishListRepository;
    
	public WishListDto search(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	public WishListDto add(WishListDto wishListDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
