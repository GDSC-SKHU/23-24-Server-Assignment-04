package gdsc.skhu.jpaexercise.repository;

import gdsc.skhu.jpaexercise.domain.Team;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    Optional<Team> findTeamByName(String name);
}
