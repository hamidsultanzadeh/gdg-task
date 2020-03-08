package com.hamidsultanzadeh.buyer.controller;

import com.hamidsultanzadeh.buyer.dto.ProductDto;
import com.hamidsultanzadeh.buyer.dto.RequestDto;
import com.hamidsultanzadeh.buyer.dto.ResponseDto;
import com.hamidsultanzadeh.buyer.entity.Product;
import com.hamidsultanzadeh.buyer.mapper.ProductMapper;
import com.hamidsultanzadeh.buyer.service.inter.ProductClient;
import com.hamidsultanzadeh.buyer.service.inter.ProductServiceInter;
import feign.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private final ProductServiceInter productServiceInter;

    private final ProductClient productClient;

    public ProductRestController(ProductServiceInter productServiceInter,ProductClient productClient) {
        this.productServiceInter = productServiceInter;
        this.productClient = productClient;
    }

    @GetMapping
    public ResponseEntity<ResponseDto> findAll(){
        List<Product> products = productServiceInter.findAll();

        if(products == null || products.size() == 0){
            return ResponseEntity.ok(new ResponseDto(404,"Not found",null));
        }

        return ResponseEntity.ok(
                new ResponseDto(200,"Found", ProductMapper.entitiesToDtos(products))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable(name = "id") Integer id){
        Product product = productServiceInter.findById(id);

        if(product == null){
            return ResponseEntity.ok(new ResponseDto(404,"Not found",null));
        }

        return ResponseEntity.ok(
                new ResponseDto(200,"Found", ProductMapper.entityToDto(product))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> remove(@PathVariable(name = "id") Integer id){
        Product product = productServiceInter.remove(id);

        if(product == null){
            return ResponseEntity.ok(new ResponseDto(500,"Failed",null));
        }

        return ResponseEntity.ok(
                new ResponseDto(200,"Removed", ProductMapper.entityToDto(product))
        );
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@RequestBody ProductDto productDto){
        Product product = productServiceInter.update(productDto);

        if(product == null) {
            return ResponseEntity.ok(new ResponseDto(500,"Failed",null));
        }

        return ResponseEntity.ok(
                new ResponseDto(200,"Updated", ProductMapper.entityToDto(product))
        );
    }

    @GetMapping("/order")
    public ResponseEntity<ResponseDto> order(@RequestBody RequestDto requestDto){

        ResponseDto responseDto = productClient.send(requestDto).getBody();

        if(responseDto == null) {
            return ResponseEntity.ok(new ResponseDto(500,"Failed",null));
        }

        Product pr = productServiceInter.save(responseDto);

        if(pr == null){
            return ResponseEntity.ok(new ResponseDto(500,"Failed",null));
        }

        return ResponseEntity.ok(
                new ResponseDto(200,responseDto.getMessage(),pr)
        );

    }
}
