package com.example.restuarant.wishlist.repository;

import org.springframework.stereotype.Repository;

import com.example.restuarant.db.MemoryDbRepositoryAbstract;
import com.example.restuarant.wishlist.entity.WishListEntity;

/* MemoryDbRepositoryAbstract의 상속받는 메서드상의 T는 WishListEntity가 된다.
 * */
@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}
