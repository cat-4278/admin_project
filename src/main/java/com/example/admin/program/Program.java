package com.example.admin.program;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.example.admin.com.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "program")
@Comment(value = "프로그램관리")
public class Program extends BaseEntity {

	@Id
    @Column(name = "PROG_CD", length = 50)
	@Comment(value = "프로그램코드")
    private String progCd;

    @Column(name = "PROG_NM", length = 200)
	@Comment(value = "프로그램명")
    @NonNull
    private String progNm;

    @Column(name = "PROG_PH", length = 100)
	@Comment(value = "프로그램경로")
    @NonNull
    private String progPh;

    @Column(name = "TARGET", length = 10)
	@Comment(value = "타겟")
    private String target = "_self";

    @Column(name = "AUTH_CHECK", length = 1)
	@Comment(value = "사용권한")
    private String authCheck = "Y";

    @Column(name = "SCH_AH", length = 1)
	@Comment(value = "사용권한")
    private String schAh = "N";

    @Column(name = "SAV_AH", length = 1)
	@Comment(value = "저장권한")
    private String savAh = "N";

    @Column(name = "EXL_AH", length = 1)
	@Comment(value = "엑셀권한")
    private String exlAh = "N";

    @Column(name = "DEL_AH", length = 1)
	@Comment(value = "삭제권한")
    private String delAh = "N";

    @Column(name = "FN1_AH", length = 1)
	@Comment(value = "F1권한")
    private String fn1Ah = "N";

    @Column(name = "FN2_AH", length = 1)
	@Comment(value = "F2권한")
    private String fn2Ah = "N";

    @Column(name = "FN3_AH", length = 1)
	@Comment(value = "F3권한")
    private String fn3Ah = "N";

    @Column(name = "FN4_AH", length = 1)
	@Comment(value = "F4권한")
    private String fn4Ah = "N";

    @Column(name = "FN5_AH", length = 1)
	@Comment(value = "F5권한")
    private String fn5Ah = "N";

    @Column(name = "REMARK", length = 4000)
	@Comment(value = "비고")
    private String remark;


    public static Program of(String progCd, String progNm, String progPh, String target, String authCheck, String schAh, String savAh, String exlAh, String delAh, String fn1Ah, String fn2Ah, String fn3Ah, String fn4Ah, String fn5Ah) {
        Program program = new Program();
        program.setProgCd(progCd);
        program.setProgNm(progNm);
        program.setProgPh(progPh);
        program.setTarget(target);
        program.setAuthCheck(authCheck);
        program.setSchAh(schAh);
        program.setSavAh(savAh);
        program.setExlAh(exlAh);
        program.setDelAh(delAh);
        program.setFn1Ah(fn1Ah);
        program.setFn2Ah(fn2Ah);
        program.setFn3Ah(fn3Ah);
        program.setFn4Ah(fn4Ah);
        program.setFn5Ah(fn5Ah);
        return program;
    }
}
