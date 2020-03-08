package com.hamidsultanzadeh.buyer.service.inter;

import com.hamidsultanzadeh.buyer.dto.RequestDto;
import com.hamidsultanzadeh.buyer.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "supplier", url = "http://localhost:8080/products")
public interface ProductClient {

    @PostMapping("/send")
    ResponseEntity<ResponseDto> send(@RequestBody RequestDto requestDto);

}
