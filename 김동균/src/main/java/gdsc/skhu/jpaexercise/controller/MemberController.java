package gdsc.skhu.jpaexercise.controller;

import gdsc.skhu.jpaexercise.dto.MemberDto;
import gdsc.skhu.jpaexercise.service.MemberService;
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
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member/new")
    public String createMember(@RequestBody MemberDto memberDto) {
        return memberService.createMember(memberDto);
    }

    @GetMapping("/member/{name}")
    public MemberDto findMember(@PathVariable("name") String name) {
        return memberService.findMemberByNameAsDto(name);
    }

    @PutMapping("/member")
    public String updateMember(@RequestBody MemberDto memberDto) {
        return memberService.updateMember(memberDto);
    }

    @DeleteMapping("/member")
    public String deleteMember(@RequestBody MemberDto memberDto) {
        return memberService.deleteMember(memberDto.getName());
    }
}
