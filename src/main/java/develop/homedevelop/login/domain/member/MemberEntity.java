package develop.homedevelop.login.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "member")
public class MemberEntity {

	@Id
	@Column(nullable = false, unique = true)
	private int id;
	private String loginId;
	private String name;
	private String password;
	
	
}
