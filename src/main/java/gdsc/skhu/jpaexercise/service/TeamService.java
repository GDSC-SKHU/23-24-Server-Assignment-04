package gdsc.skhu.jpaexercise.service;

import gdsc.skhu.jpaexercise.domain.Team;
import gdsc.skhu.jpaexercise.dto.TeamDto;
import gdsc.skhu.jpaexercise.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    @Transactional
    public String createTeam(TeamDto teamDto) {
        Team team = Team.builder()
                .name(teamDto.getName())
                .build();
        teamRepository.save(team);
        return "저장 성공";
    }

    public Team findTeamByName(String name) {
        return teamRepository.findTeamByName(name)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 팀 이름입니다."));
    }

    @Transactional
    public String updateTeam(TeamDto teamDto) {
        Team team = teamRepository.findById(teamDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 팀 ID입니다."));
        team.update(Team.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .build());
        return "수정 성공";
    }

    @Transactional
    public String deleteTeam(TeamDto teamDto) {
        Team team = findTeamByName(teamDto.getName());
        teamRepository.delete(team);
        return "삭제 성공";
    }
}
