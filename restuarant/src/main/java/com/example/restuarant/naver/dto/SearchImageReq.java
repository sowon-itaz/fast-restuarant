package com.example.restuarant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchImageReq {
	
	private String query = "";

    private int display = 1;

    private int start = 1;

    private String sort = "sim";

    private String filter = "all";

}
