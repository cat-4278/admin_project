package com.example.admin.menu;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.example.admin.com.BaseEntity;
import com.example.admin.program.Program;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@DynamicInsert
@DynamicUpdate
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "menu")
@Comment(value = "메뉴관리")
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu extends BaseEntity {
	
	@Id
    @Column(name = "MENU_CD", length = 50)
    @Comment(value = "메뉴코드")
    private String menuCd;
	
    @Column(name = "MENU_NM", length = 200)
    @Comment(value = "메뉴명")
    private String menuNm;

    @Column(name = "PARENT_CD", length = 50)
    @Comment(value = "상위메뉴코드")
    private String parentCd;

    @Column(name = "MENU_GRP_CD", length = 100)
    @Comment(value = "메뉴그룹코드")
    private String menuGrpCd;
    
    @Column(name = "LV", length = 10)
    @Comment(value = "레벨")
    private Integer lv;

    @Column(name = "SORT", precision = 20)
    @Comment(value = "우선순위")
    private Integer sort;

    @Column(name = "PROG_CD", length = 50)
    @Comment(value = "프로그램 코드")
    private String progCd;

    @Column(name = "ICON_NM", length = 200)
    @Comment(value = "아이콘명")
    private String iconNm;
    
    @Column(name = "APP_MENU_CD", length = 50)
    @Comment(value = "APP메뉴코드")
    private String appMenuCd;

    @Column(name = "MENU_SORT", precision = 20)
    @Comment(value = "우선순위")
    private Integer menuSort;

    @Transient
    private boolean open = false;

    @Transient
    private List<Menu> children = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "PROG_CD", referencedColumnName = "PROG_CD", insertable = false, updatable = false)
    private Program program;
    

    @JsonProperty("name")
    public String label() {
        return menuNm;
    }

    @JsonProperty("code")
    public String code() {
        return menuCd;
    }

    @JsonProperty("open")
    public boolean isOpen() {
        return open;
    }

    public void addChildren(Menu menu) {
        children.add(menu);
    }

    public Menu clone() {
        try {
            Menu menu = (Menu) super.clone();
            menu.setChildren(new ArrayList<>());
            return menu;
        } catch (Exception e) {
            // ignore
        }
        return null;
    }

    public static Menu of(String code, String menuGrpCd, String menuNm, String parentCd, int lv, int sort, String progCd) {
        Menu menu = new Menu();
        menu.setMenuCd(code);
        menu.setMenuGrpCd(menuGrpCd);
        menu.setMenuNm(menuNm);
        menu.setParentCd(parentCd);
        menu.setLv(lv);
        menu.setSort(sort);
        menu.setProgCd(progCd);
        return menu;
    }

}
