package com.example.orderitem.controller;

import com.example.orderitem.domain.Item;
import com.example.orderitem.domain.Member;
import com.example.orderitem.item.dto.AddItemRequest;
import com.example.orderitem.item.dto.ItemResponse;
import com.example.orderitem.item.dto.UpdateItemRequest;
import com.example.orderitem.item.service.ItemService;
import com.example.orderitem.member.dto.AddMemberRequest;
import com.example.orderitem.member.dto.MemberResponse;
import com.example.orderitem.member.dto.UpdateMemberRequest;
import com.example.orderitem.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponse> join(@RequestBody @Validated AddMemberRequest addMemberRequest) {
        Member member = memberService.join(addMemberRequest);
        return ResponseEntity.ok(MemberResponse.createInstance(member));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> findById(@PathVariable Long memberId) {
        Member findMember = memberService.findById(memberId);
        return ResponseEntity.ok(MemberResponse.createInstance(findMember));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Member> members = memberService.findMembers();
        List<MemberResponse> collect = members.stream().map(MemberResponse::createInstance).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> memberUpdate(@PathVariable(name = "memberId") Long memberId, @RequestBody @Validated UpdateMemberRequest updateMemberRequest) {
        memberService.update(updateMemberRequest, memberId);
        Member findMember = memberService.findById(memberId);
        return ResponseEntity.ok(MemberResponse.createInstance(findMember));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> memberDelete(@PathVariable(name = "memberId") Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
