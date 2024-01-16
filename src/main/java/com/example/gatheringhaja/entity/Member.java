package com.example.gatheringhaja.entity;

import com.example.gatheringhaja.entity.enumerations.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String email;

    private String password;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phoneNumber;

    private String profileImagePath;

    private String introduction;

    private boolean deleted;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Meeting> meetings = new ArrayList<>();

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateMemberInfo(String nickname, String phoneNumber, String introduction) {
        if (nickname != null) {
            this.nickname = nickname;
        }
        if (phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        }
        if (introduction != null) {
            this.introduction = introduction;
        }
    }

    public void deleteMember() {
        this.deleted = true;
    }

}
