package com.example.admin.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.com.BaseService;
 
@Service
public class MenuService extends BaseService<Menu, String> {
	
    private MenuRepository repository;

    @Autowired private MenuMapper menuMapper;
    
    @Autowired
    public MenuService(MenuRepository repository) {
        super(repository);
        this.repository = repository;
    }

    //조회
    public List<MenuVO> getMenuList(MenuVO vo) {    
    	return menuMapper.getMenuList(vo);
    }
}