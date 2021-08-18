package com.example.restuarant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// T는 MemoryDbEntity를 상속받음
public abstract class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {

	private final List<T> db = new ArrayList<>();
	private int index = 0; 
	
	@Override
	public Optional<T> findById(int index) {
		/* filter()는 MemoryDbEntity에서 상속받은 index를 의미함
		 * findFirst()는 있을수도 있고 없을수도 있는 첫번째 값을 리턴함 -> 없으면 empty리턴
		 * */ 
		System.out.println("@ 앱스트랙트: "+db.stream().filter(it -> it.getIndex() == index).findFirst());
		return db.stream().filter(it -> it.getIndex() == index).findFirst();
	}

	@Override
	public T save(T entity) {
		
		var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

		// db에 데이터가 존재하지않는 경우 -> 저장
		if(optionalEntity.isEmpty()) {
			index++;
			entity.setIndex(index);
			db.add(entity);
			return entity;
		} 
		// db에 데이터가 존재하는 경우 -> 정보 업데이트
		else {
			var preIndex = optionalEntity.get().getIndex();
			entity.setIndex(preIndex);
			deleteById(preIndex);
			db.add(entity);
			return entity;
		}
	}

	@Override
	public void deleteById(int index) {
		
		var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();
		
		if(optionalEntity.isPresent()) {
			db.remove(optionalEntity.get());
		}
		
	}

	// DB의 모든 내용을 출력
	@Override
	public List<T> findAll() {
		return db;
	}
	
}
