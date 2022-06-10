package develop.homedevelop.login.domain.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
@Repository
public interface CrudMemberRepository extends JpaRepository<MemberEntity, String> {
	
	@Query(value = "select id, loginId, name, password from member where id :id", nativeQuery=true)
	List<MemberEntity> searchParamRepo(@Param("id") int id);

}