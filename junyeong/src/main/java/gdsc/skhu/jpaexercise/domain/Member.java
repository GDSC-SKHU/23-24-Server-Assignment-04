package gdsc.skhu.jpaexercise.domain;

import gdsc.skhu.jpaexercise.dto.MemberDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Integer id;

    @Column(name = "MEMBER_NAME", nullable = false)
    private String name;

    @Column(name = "MEMBER_AGE", nullable = false)
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public MemberDto toDto() {
        if (team != null) {
            return MemberDto.builder()
                    .id(this.id)
                    .name(this.name)
                    .age(this.age)
                    .teamName(team.getName())
                    .build();
        }
        return MemberDto.builder()
                .id(this.id)
                .name(this.name)
                .age(this.age)
                .build();
    }

    public void update(Member member) {
        this.id = member.id;
        this.name = member.name;
        this.age = member.age;
        if (team != null) {
            changeTeam(member.team);
            return;
        }
        this.team = member.team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
