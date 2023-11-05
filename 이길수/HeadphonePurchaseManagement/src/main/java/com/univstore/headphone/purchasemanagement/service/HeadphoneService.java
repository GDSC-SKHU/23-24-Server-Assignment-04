package com.univstore.headphone.purchasemanagement.service;

import com.univstore.headphone.purchasemanagement.domain.Headphone;
import com.univstore.headphone.purchasemanagement.dto.HeadphoneDto;
import com.univstore.headphone.purchasemanagement.repository.HeadphoneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeadphoneService {
    private final HeadphoneRepository headphoneRepository;

    @Transactional
    public String createHeadphone(HeadphoneDto headphoneDto) {
        Headphone headphone = Headphone.builder()
                .brand(headphoneDto.getBrand())
                .name(headphoneDto.getName())
                .price(headphoneDto.getPrice())
                .build();
        headphoneRepository.save(headphone);
        return "저장 성공";
    }

    public Headphone findHeadphoneByName(String name) {
        return headphoneRepository.findHeadphoneByName(name)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 제품명 입니다."));
    }

    @Transactional
    public String updateHeadphone(HeadphoneDto headphoneDto) {
        Headphone headphone = headphoneRepository.findById(headphoneDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 제품명 입니다."));
        headphone.update(Headphone.builder()
                .id(headphoneDto.getId())
                .brand(headphoneDto.getBrand())
                .name(headphoneDto.getName())
                .price(headphoneDto.getPrice())
                .build());
        return "수정 성공";
    }

    @Transactional
    public String deleteHeadphone(HeadphoneDto headphoneDto) {
        Headphone headphone = findHeadphoneByName(headphoneDto.getName());
        headphoneRepository.delete(headphone);
        return "삭제 성공";
    }
}
