package gdsc.skhu.jpaexercise.repository;

import gdsc.skhu.jpaexercise.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findMemberByName(String username);
}
