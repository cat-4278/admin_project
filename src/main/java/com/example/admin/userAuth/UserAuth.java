package com.example.admin.userAuth;

import java.io.Serializable;

import org.hibernate.annotations.Comment;

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
@Table(name = "user_auth")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserAuth.UserAuthId.class)
public class UserAuth extends BaseEntity {

	@Id
    @Column(name = "USER_CD")
	@Comment(value = "사용자")
    private String userCd;

	@Id
    @Column(name = "GRP_AUTH_CD")
	@Comment(value = "권한그룹코드")
    private String grpAuthCd;

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
	public static class UserAuthId implements Serializable {
		@NonNull
		private String userCd;
		@NonNull
		private String grpAuthCd;
	}
}
