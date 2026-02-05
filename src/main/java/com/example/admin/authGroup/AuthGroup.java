package com.example.admin.authGroup;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Comment;

import com.example.admin.authGroupUser.AuthGroupUser;
import com.example.admin.com.BaseEntity;
import com.example.admin.userAuth.UserAuth;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "auth_group")
@Data
@IdClass(AuthGroup.AuthGroupId.class)
@NoArgsConstructor
@AllArgsConstructor
public class AuthGroup extends BaseEntity {

	
    @Id
	@Column(name = "GRP_AUTH_CD", length = 50)
    @Comment(value = "권한그룹코드")
    private String grpAuthCd;

	@Column(name = "GRP_AUTH_NM", length = 200)
    @Comment(value = "권한그룹명")
    private String grpAuthNm;

	@Column(name = "REMARK", length = 4000)
	@Comment(value = "비고")
	private String remark;

	@Column(name = "DEFAULT_YN", length = 20)
	@Comment(value = "DEFAULT권한여부")
	private String defaultYn;

	@Column(name = "SCM_YN", length = 20)
	@Comment(value = "SCM여부")
	private String scmYn;

	@Column(name = "SYSTEM_YN", length = 20)
	@Comment(value = "SYSTEM권한여부")
	private String systemYn;

	@Column(name = "USE_YN", length = 20)
	@Comment(value = "사용여부")
	private String useYn;
	
    @Transient
	private List<AuthGroupUser> itemDetail;

    @Transient
	private List<UserAuth> userAuthList;
    
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class AuthGroupId implements Serializable {
		@NonNull
		private String grpAuthCd;
	}
}
