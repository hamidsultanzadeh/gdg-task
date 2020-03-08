package com.hamidsultanzadeh.supplier.controller;

import com.hamidsultanzadeh.supplier.dto.ProductOrderDto;
import com.hamidsultanzadeh.supplier.dto.ResponseDto;
import com.hamidsultanzadeh.supplier.entity.ProductOrder;
import com.hamidsultanzadeh.supplier.mapper.ProductOrderMapper;
import com.hamidsultanzadeh.supplier.service.inter.ProductOrderServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class ProductOrderRestController {

    private final ProductOrderServiceInter productOrderServiceInter;

    public ProductOrderRestController(ProductOrderServiceInter productOrderServiceInter) {
        this.productOrderServiceInter = productOrderServiceInter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable(name = "id") Integer id){
        ProductOrder productOrder = productOrderServiceInter.findById(id);

        if(productOrder == null) return ResponseEntity.ok(new ResponseDto(404,"Not found",null));

        return ResponseEntity.ok(
                new ResponseDto(200,"Found", ProductOrderMapper.entityToDto(productOrder))
        );
    }

    @PostMapping
    public ResponseEntity<ResponseDto> save(@RequestBody ProductOrderDto productOrderDto){
        ProductOrder productOrder = productOrderServiceInter.save(productOrderDto);

        if(productOrder == null) return ResponseEntity.ok(new ResponseDto(404,"Failed",null));

        return ResponseEntity.ok(
                new ResponseDto(200,"Added", ProductOrderMapper.entityToDto(productOrder))
        );
    }

    @GetMapping
    public ResponseEntity<ResponseDto> findAll(){
        List<ProductOrder> productOrders = productOrderServiceInter.findAll();

        if(productOrders == null || productOrders.size() == 0){
            return ResponseEntity.ok(new ResponseDto(404,"Not found",null));
        }

        return ResponseEntity.ok(
                new ResponseDto(200,"Found", ProductOrderMapper.entitiesToDtos(productOrders))
        );
    }
}
