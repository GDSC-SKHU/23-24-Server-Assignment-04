package gdsc.skhu.jpaexercise.domain;

import gdsc.skhu.jpaexercise.dto.MemberDto;
import gdsc.skhu.jpaexercise.dto.TeamDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Integer id;

    @Column(name = "TEAM_NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "team")
    @Column(name = "TEAM_MEMBERS")
    private List<Member> members = new ArrayList<>();

    public TeamDto toDto() {
        List<MemberDto> memberDtos = members.stream().map(Member::toDto).toList();
        return TeamDto.builder()
                .id(this.id)
                .name(this.name)
                .members(memberDtos)
                .build();
    }

    public void update(Team team) {
        this.id = team.id;
        this.name = team.name;
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public String getName() {
        return this.name;
    }
}
