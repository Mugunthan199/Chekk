package com.santainc.hoodfiller.controller;

import com.santainc.hoodfiller.entity.HoodFillerRequest;
import com.santainc.hoodfiller.service.HoodFillerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hoodfiller")
@Slf4j
public class HoodFillerController {

    @Autowired
    private HoodFillerService hoodFillerService;
    @PostMapping("/")
    public List<Integer> prepareHood(@RequestBody HoodFillerRequest hoodFillerRequest) {
        log.info("Inside prepareHood Controller");
        return hoodFillerService.prepareHoodForPresent(hoodFillerRequest);
    }
}
