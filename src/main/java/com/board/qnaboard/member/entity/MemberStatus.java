package com.board.qnaboard.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MemberStatus {
    MEMBER_ACTIVE("활성화"),
    MEMBER_SLEEP("휴면"),
    MEMBER_QUIT("탈퇴"),
    MEMBER_ADMIN("관리자");

    @Getter
    private String status;
}
