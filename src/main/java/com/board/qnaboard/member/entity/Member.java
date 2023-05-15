package com.board.qnaboard.member.entity;

import com.board.qnaboard.audit.Auditable;
import com.board.qnaboard.question.entity.Question;
import com.board.qnaboard.validator.password.PasswordPattern;
import com.board.qnaboard.validator.phone.PhonePattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
//@Entity
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, updatable = false, unique = true)
    @Email
    private String email;

    @Column(length = 30, nullable = false)
    private String name;

    @Range(min = 8, max = 16)
    @Column(nullable = false)
    @PasswordPattern
    private String password;

    @Column(nullable = false, unique = true)
    @PhonePattern
    private String phone;

    @Column(nullable = true)
    private String address;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private String memberStatus;

    @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Question> questions = new LinkedList<>();

    public Member(String email) {
        this.email = email;
    }

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
