package com.angry.hospital.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response
 */

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    @ApiModelProperty(example = "Data Found")
    private String message;

    @ApiModelProperty(example = "Data")
    private Object data;


    /**
     *
     * @param message
     * @param data
     * @return
     */
    public Response getInstance(String message, Object data){
        return Response.builder().message(message).data(data).build();
    }
}
