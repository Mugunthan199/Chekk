package com.santainc.hoodfiller.entity;


import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoodFillerRequest {
    private int hood_capacity;
    private List<Integer> present_weights;
}
