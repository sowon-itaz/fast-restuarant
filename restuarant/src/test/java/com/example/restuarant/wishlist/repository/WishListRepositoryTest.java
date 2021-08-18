package com.example.restuarant.wishlist.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restuarant.wishlist.entity.WishListEntity;

@SpringBootTest
public class WishListRepositoryTest {
	
	@Autowired
	private WishListRepository wishlistRepo;
	
	// 자주 사용하는 건 전역 메서드로 생성
	private WishListEntity create() {
		var wishList = new WishListEntity();
        wishList.setTitle("맛집");
        wishList.setCategory("한식");
        wishList.setAddress("부산광역시");
        wishList.setRoadAddress("readAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);

        return wishList;
		
	}
	
	@Test
	public void saveTest() {
		var wishListEntity = create();
        var expected = wishlistRepo.save(wishListEntity);

        // expected가 null이면 안됨
        Assertions.assertNotNull(expected);
        // expected가 1이면 됨
        Assertions.assertEquals(1, expected.getIndex());
	}

	@Test
	public void updateTest() {
		var wishListEntity = create();
		var expected = wishlistRepo.save(wishListEntity);
		System.out.println("@ wishListEntity: "+expected);
		
		expected.setTitle("수정 맛집");
		var saveEntity = wishlistRepo.save(expected);
		
		// title변경되었는지 확인
		System.out.println("@ saveEntity: "+saveEntity);
		Assertions.assertEquals("수정 맛집", saveEntity.getTitle());
		// 수정이기때문에 index가 증가하면 안됨
		Assertions.assertEquals(1, wishlistRepo.findAll().size());
	}

	@Test
	public void listAllTest() {
        var wishListEntity1 = create();
        wishlistRepo.save(wishListEntity1);

        var wishListEntity2 = create();
        wishlistRepo.save(wishListEntity2);

        int count = wishlistRepo.findAll().size();
        Assertions.assertEquals(2, count);
		
	}

	@Test
	public void findByIdTest() {
		var wishListEntity = create();
		wishlistRepo.save(wishListEntity);
		
		var expected = wishlistRepo.findById(1);
		
		System.out.println("@ expected.isPresent(): "+expected.isPresent());
		Assertions.assertEquals(true, expected.isPresent());
		
		// 데이터가 1이어야 함
		System.out.println("@ findByIdTest메서드 expected.get().getIndex(): "+expected.get().getIndex());
		Assertions.assertEquals(1, expected.get().getIndex());
	}
	
	@Test
	public void deleteByIdTest() {
		var wishListEntity = create();
		
		wishlistRepo.save(wishListEntity);
		int cnt = wishlistRepo.findAll().size();
		System.out.println("@ 1 wishlistRepo.findAll().size(): "+cnt);
		
		wishlistRepo.deleteById(1);
		cnt = wishlistRepo.findAll().size();
		System.out.println("@ 2 wishlistRepo.findAll().size(): "+cnt);

		Assertions.assertEquals(0, cnt);
	}

}
