package com.api.parkingcontrol.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseVehiclePhotos {
    private long id;
    private String url;
    private int priority;
}
