package com.example.orderitem.member.dto;

import com.example.orderitem.domain.Address;
import com.example.orderitem.domain.Member;

public record MemberResponse(
        Long memberId,
        String name,
        Address address
) {
    public static MemberResponse createInstance(Member member) {
        return new MemberResponse(member.getId(), member.getName(), member.getAddress());
    }
}
