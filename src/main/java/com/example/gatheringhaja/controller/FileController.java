package com.example.gatheringhaja.controller;

import com.example.gatheringhaja.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/files")
public class FileController {

    private final FileService fileService;

    @PostMapping("/profile/{memberId}")
    public ResponseEntity<?> uploadProfileImage(@PathVariable("memberId") Long memberId,
                                                @RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileService.uploadProfileImage(memberId, file));
    }

}
