package com.example.admin.authGroupUser;

import java.io.Serializable;

import org.hibernate.annotations.Comment;

import com.example.admin.authGroupMenu.AuthGroupMenu;
import com.example.admin.com.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "auth_group_user")
@Data
@IdClass(AuthGroupUser.AuthGroupUserId.class)
@NoArgsConstructor
@AllArgsConstructor
public class AuthGroupUser extends BaseEntity {

    @Id
	@Column(name = "GRP_AUTH_CD", length = 100)
    @Comment(value = "권한그룹코드")
    private String grpAuthCd;

    @Id
	@Column(name = "USER_CD", length = 255)
    @Comment(value = "사용자")
    private String userCd;

	@Column(name = "REMARK", length = 4000)
	@Comment(value = "비고")
	private String remark;

	@Column(name = "USE_YN", length = 20)
	@Comment(value = "사용여부")
	private String useYn;
    
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class AuthGroupUserId implements Serializable {
		@NonNull
		private String grpAuthCd;
		@NonNull
	    private String userCd;
	}
}
