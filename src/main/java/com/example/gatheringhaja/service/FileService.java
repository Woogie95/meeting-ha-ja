package com.example.gatheringhaja.service;

import com.example.gatheringhaja.repository.MemberRepository;
import com.example.gatheringhaja.service.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileService {

    private final S3Uploader s3Uploader;
    private final MemberRepository memberRepository;

    public void uploadProfileImage(Long memberId, MultipartFile multipartFile) throws IOException {
        String imagePath = s3Uploader.upload(multipartFile, "profile");
        memberRepository.findById(memberId)
                .map(member -> {
                    member.setProfileImagePath(imagePath);
                    return memberRepository.save(member);
                })
                .orElseThrow(() -> new IllegalArgumentException("해당하는 회원이 없습니다."));
    }

}
