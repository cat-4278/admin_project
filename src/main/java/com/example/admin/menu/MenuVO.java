package com.example.admin.menu;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
 
@Data
public class MenuVO {
	
    protected Instant updatedAt;
    protected String updatedBy;
    private String menuCd;
	private String menuNm;
	private String iconNm;
	private String parentCd;
	private String progCd;
	private Long sort;
	private String sortPath;
	private String lv;
}