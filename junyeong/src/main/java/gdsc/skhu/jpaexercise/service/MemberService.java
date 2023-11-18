package gdsc.skhu.jpaexercise.service;

import gdsc.skhu.jpaexercise.domain.Member;
import gdsc.skhu.jpaexercise.domain.Team;
import gdsc.skhu.jpaexercise.dto.MemberDto;
import gdsc.skhu.jpaexercise.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final TeamService teamService;

    @Transactional
    public String createMember(MemberDto memberDto) {
        if (memberDto.getTeamName() == null) {
            Member member = createMemberWithoutTeam(memberDto);
            memberRepository.save(member);
            return "저장 성공";
        }
        Member member = createMemberWithTeam(memberDto);
        memberRepository.save(member);
        return "저장 성공";
    }

    private Member createMemberWithoutTeam(MemberDto memberDto) {
        return Member.builder()
                .name(memberDto.getName())
                .age(memberDto.getAge())
                .build();
    }

    private Member createMemberWithTeam(MemberDto memberDto) {
        Team team = findTeamByName(memberDto.getTeamName());
        return Member.builder()
                .name(memberDto.getName())
                .age(memberDto.getAge())
                .team(team)
                .build();
    }

    public MemberDto findMemberByNameAsDto(String username) {
        return findMemberByName(username).toDto();
    }


    @Transactional
    public String updateMember(MemberDto memberDto) {
        Member member = findMemberByName(memberDto.getName());
        if (memberDto.getTeamName() != null) {
            updateMemberWithTeam(memberDto, member);
            memberRepository.save(member);
            return "수정 성공";
        }
        updateMemberWithoutTeam(memberDto, member);
        memberRepository.save(member);
        return "수정 성공";
    }

    private void updateMemberWithTeam(MemberDto memberDto, Member member) {
        Team team = teamService.findTeamByName(memberDto.getTeamName());
        member.update(Member.builder()
                .id(memberDto.getId())
                .name(memberDto.getName())
                .age(memberDto.getAge())
                .team(team)
                .build());
    }

    private void updateMemberWithoutTeam(MemberDto memberDto, Member member) {
        member.update(Member.builder()
                .id(memberDto.getId())
                .name(memberDto.getName())
                .age(memberDto.getAge())
                .build());
    }

    @Transactional
    public String deleteMember(String username) {
        Member member = findMemberByName(username);
        memberRepository.delete(member);
        return "삭제 성공";
    }

    private Member findMemberByName(String username) {
        return memberRepository.findMemberByName(username)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 사용자 이름입니다."));
    }

    private Team findTeamByName(String teamName) {
        return teamService.findTeamByName(teamName);
    }
}
