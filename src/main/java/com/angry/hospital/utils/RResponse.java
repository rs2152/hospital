package com.angry.hospital.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RResponse
 */

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RResponse {

    @ApiModelProperty(example = "Users Found")
    private String message;

    /**
     *
     * @param message  -> Message
     * @return
     */
    public RResponse getInstance(String message){
        return RResponse.builder().message(message).build();
    }


}
