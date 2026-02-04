package com.example.admin.authGroupMenu;

import java.io.Serializable;

import org.hibernate.annotations.Comment;

import com.example.admin.com.BaseEntity;
import com.example.admin.program.Program;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "auth_group_menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthGroupMenu extends BaseEntity {

	@Id
	@Column(name = "GRP_AUTH_CD", length = 50)
    @Comment(value = "권한그룹코드")
    private String grpAuthCd;

    @Id
    @Column(name = "MENU_CD", length = 50)
    @Comment(value = "메뉴 코드")
    private String menuCd;    

    @Column(name = "SCH_AH", length = 1)
    @Comment(value = "조회권한")
    private String schAh;

    @Column(name = "SAV_AH", length = 1)
    @Comment(value = "저장권한")
    private String savAh;

    @Column(name = "EXL_AH", length = 1)
    @Comment(value = "엑셀권한")
    private String exlAh;

    @Column(name = "DEL_AH", length = 1)
    @Comment(value = "삭제권한")
    private String delAh;

    @Column(name = "FN1_AH", length = 1)
    @Comment(value = "기능키1권한")
    private String fn1Ah;

    @Column(name = "FN2_AH", length = 1)
    @Comment(value = "기능키2권한")
    private String fn2Ah;

    @Column(name = "FN3_AH", length = 1)
    @Comment(value = "기능키3권한")
    private String fn3Ah;

    @Column(name = "FN4_AH", length = 1)
    @Comment(value = "기능키4권한") 
    private String fn4Ah;

    @Column(name = "FN5_AH", length = 1)
    @Comment(value = "기능키5권한")
    private String fn5Ah;

    @Transient
    private String useYn;

    public void updateAuthorization(AuthGroupMenu authGroupMenu) {
        this.schAh = positive(this.schAh, authGroupMenu.getSchAh());
        this.savAh = positive(this.savAh, authGroupMenu.getSavAh());
        this.exlAh = positive(this.exlAh, authGroupMenu.getExlAh());
        this.delAh = positive(this.delAh, authGroupMenu.getDelAh());
        this.fn1Ah = positive(this.fn1Ah, authGroupMenu.getFn1Ah());
        this.fn2Ah = positive(this.fn2Ah, authGroupMenu.getFn2Ah());
        this.fn3Ah = positive(this.fn3Ah, authGroupMenu.getFn3Ah());
        this.fn4Ah = positive(this.fn4Ah, authGroupMenu.getFn4Ah());
        this.fn5Ah = positive(this.fn5Ah, authGroupMenu.getFn5Ah());
    }

    public void updateAuthorization(Program program) {
        this.schAh = negative(this.schAh, program.getSchAh());
        this.savAh = negative(this.savAh, program.getSavAh());
        this.exlAh = negative(this.exlAh, program.getExlAh());
        this.delAh = negative(this.delAh, program.getDelAh());
        this.fn1Ah = negative(this.fn1Ah, program.getFn1Ah());
        this.fn2Ah = negative(this.fn2Ah, program.getFn2Ah());
        this.fn3Ah = negative(this.fn3Ah, program.getFn3Ah());
        this.fn4Ah = negative(this.fn4Ah, program.getFn4Ah());
        this.fn5Ah = negative(this.fn5Ah, program.getFn5Ah());
    }

    public String positive(String originValue, String newValue) {
        if (originValue != null && originValue.equals("Y"))
            return originValue;

        if (newValue != null && newValue.equals("Y"))
            return newValue;

        return "N";
    }

    public String negative(String originValue, String newValue) {
        if (originValue != null && originValue.equals("Y"))
            return newValue;

        return "N";
    }


    @Embeddable
    @Data
    @NoArgsConstructor
    @RequiredArgsConstructor(staticName = "of")
    public static class AuthGroupMenuId implements Serializable {
        @NonNull
        private String company;
        @NonNull
        private String grpAuthCd;
        @NonNull
        private String menuCd;
    }

    public static AuthGroupMenu of(String company, String grpAuthCd, String menuCd, String schAh, String savAh, String exlAh, String delAh, String fn1Ah, String fn2Ah, String fn3Ah, String fn4Ah, String fn5Ah) {
        AuthGroupMenu authGroupMenu = new AuthGroupMenu();
        authGroupMenu.setGrpAuthCd(grpAuthCd);
        authGroupMenu.setMenuCd(menuCd);
        authGroupMenu.setSchAh(schAh);
        authGroupMenu.setSavAh(savAh);
        authGroupMenu.setExlAh(exlAh);
        authGroupMenu.setDelAh(delAh);
        authGroupMenu.setFn1Ah(fn1Ah);
        authGroupMenu.setFn2Ah(fn2Ah);
        authGroupMenu.setFn3Ah(fn3Ah);
        authGroupMenu.setFn4Ah(fn4Ah);
        authGroupMenu.setFn5Ah(fn5Ah);
        return authGroupMenu;
    }
}
