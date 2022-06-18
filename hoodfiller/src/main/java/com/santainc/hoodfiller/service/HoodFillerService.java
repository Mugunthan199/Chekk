package com.santainc.hoodfiller.service;

import com.santainc.hoodfiller.entity.HoodFillerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HoodFillerService {
    public List<Integer> prepareHoodForPresent(HoodFillerRequest hoodFillerRequest) {
        List<Integer> inputList = hoodFillerRequest.getPresent_weights();
        int wt = hoodFillerRequest.getHood_capacity();
        int diff = wt;
        boolean run = true;
        List<Integer> out = new ArrayList<>();
        try {
            List<Integer> subList = inputList.stream().filter(x -> x <= wt).sorted().collect(Collectors.toList());
            int max = Collections.max(subList);
            while (run) {
                if (wt != 0 && inputList != null) {
                    if (diff == 0) {
                        run = false;
                        break;
                    } else if (diff >= max) {
                        out.add(max);
                        log.info(out + "");
                        diff = diff - max;
                        log.info("diff-->" + diff);
                    } else if (diff < max) {
                        if (subList.contains(diff)) {
                            out.add(diff);
                            break;
                        }
                        out.remove(out.size() - 1);
                        log.info(out + "");
                        subList.remove(subList.size() - 1);
                        log.info(subList + "");
                        if (subList.isEmpty()) {
                            out.clear();
                            return out;
                        } else {
                            max = Collections.max(subList);
                            diff = wt - (out.stream().mapToInt(x -> x).sum());
                        }
                    }
                }
            }
        }catch (Exception e)
        {
            out.clear();
            return out;
        }
        log.info("#############################");
        return out;
}
}
