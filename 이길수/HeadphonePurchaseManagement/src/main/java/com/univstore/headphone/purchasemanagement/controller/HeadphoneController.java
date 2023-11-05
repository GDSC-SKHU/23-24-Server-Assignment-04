package com.univstore.headphone.purchasemanagement.controller;

import com.univstore.headphone.purchasemanagement.dto.HeadphoneDto;
import com.univstore.headphone.purchasemanagement.service.HeadphoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HeadphoneController {
    private final HeadphoneService headphoneService;

    @PostMapping("/headphone/new")
    public String createCustomer(@RequestBody HeadphoneDto headphoneDto) {
        return headphoneService.createHeadphone(headphoneDto);
    }

    @GetMapping("/headphone/{name}")
    public HeadphoneDto findHeadphoneByName(@PathVariable("name") String name) {
        return headphoneService.findHeadphoneByName(name).toHeadphoneDto();
    }

    @PutMapping("/headphone")
    public String updateHeadphone(@RequestBody HeadphoneDto headphoneDto) {
        return headphoneService.updateHeadphone(headphoneDto);
    }

    @DeleteMapping("/headphone")
    public String deleteHeadphone(@RequestBody HeadphoneDto headphoneDto) {
        return headphoneService.deleteHeadphone(headphoneDto);
    }
}
