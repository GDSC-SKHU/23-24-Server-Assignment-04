package com.example.orderitem.member.service;

import com.example.orderitem.domain.Address;
import com.example.orderitem.domain.Item;
import com.example.orderitem.domain.Member;
import com.example.orderitem.member.dto.AddMemberRequest;
import com.example.orderitem.member.dto.UpdateMemberRequest;
import com.example.orderitem.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Member join(AddMemberRequest addMemberRequest){
        Member member = addMemberRequest.toEntity();
        validateDuplicateMember(member); //중복 회원 검증
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findById(Long memberId){
        return memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("찾으려는 회원이 없습니다."));
    }

    @Transactional
    public void update(UpdateMemberRequest updateMemberRequest, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("찾으려는 회원이 없습니다."));
        member.updateMember(updateMemberRequest.name(), Address.builder().city(updateMemberRequest.city()).street(updateMemberRequest.street()).zipcode(updateMemberRequest.zipcode()).build());
    }

    @Transactional
    public void deleteMember(Long memberId){
        Member findMember = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("찾으려는 회원이 없습니다."));
        memberRepository.delete(findMember);
    }
}
