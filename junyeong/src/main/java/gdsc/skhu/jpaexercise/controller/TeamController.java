package gdsc.skhu.jpaexercise.controller;

import gdsc.skhu.jpaexercise.dto.TeamDto;
import gdsc.skhu.jpaexercise.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/team/new")
    public String createTeam(@RequestBody TeamDto teamDto) {
        return teamService.createTeam(teamDto);
    }

    @GetMapping("/team/{name}")
    public TeamDto findTeamByName(@PathVariable("name") String name) {
        return teamService.findTeamByName(name).toDto();
    }

    @PutMapping("/team")
    public String updateTeam(@RequestBody TeamDto teamDto) {
        return teamService.updateTeam(teamDto);
    }

    @DeleteMapping("/team")
    public String deleteTeam(@RequestBody TeamDto teamDto) {
        return teamService.deleteTeam(teamDto);
    }
}
