package com.example.restuarant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.restuarant.wishlist.dto.WishListDto;
import com.example.restuarant.wishlist.service.WishListService;

@Slf4j
@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController {
	
	/* 1. 필드주입
	 * @Autowired
	 * private WishListService wishlistService;
	 * 
	 * 2. 롬복을 활용한 생성자주입
	 * 클래스단에 @RequiredArgsConstructor 설정 후 클래스안에서 상수로 정의
	 * private final WishListService service;
	 * */
	
	private final WishListService service;
	
	@GetMapping("/search")
    public WishListDto search(@RequestParam String query){
        return service.search(query);
    }
	
	@PostMapping("")
	public WishListDto add(@RequestBody WishListDto wishListDto) {
		log.info("@ add {}", wishListDto);
		return service.add(wishListDto);
	}
	
	@GetMapping("/all")
    public List<WishListDto> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){
        service.delete(index);
    }

    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
        service.addVisit(index);
    }
	
}
