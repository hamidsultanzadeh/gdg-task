package com.hamidsultanzadeh.supplier.controller;

import com.hamidsultanzadeh.supplier.dto.ProductDto;
import com.hamidsultanzadeh.supplier.dto.ProductOrderDto;
import com.hamidsultanzadeh.supplier.dto.RequestDto;
import com.hamidsultanzadeh.supplier.dto.ResponseDto;
import com.hamidsultanzadeh.supplier.entity.Product;
import com.hamidsultanzadeh.supplier.mapper.ProductMapper;
import com.hamidsultanzadeh.supplier.service.inter.ProductOrderServiceInter;
import com.hamidsultanzadeh.supplier.service.inter.ProductServiceInter;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.callback.PrivateKeyCallback;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private final ProductServiceInter productServiceInter;

    private final ProductOrderServiceInter productOrderServiceInter;

    public ProductRestController(ProductServiceInter productServiceInter,ProductOrderServiceInter productOrderServiceInter) {
        this.productServiceInter = productServiceInter;
        this.productOrderServiceInter = productOrderServiceInter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable(name = "id") Integer id){

        Product product = productServiceInter.findById(id);

        if(product == null){
            return ResponseEntity.ok(new ResponseDto(404,"Not found",null));
        }

        return ResponseEntity.ok(
                new ResponseDto(200,"Found",ProductMapper.entityToDto(product))
        );

    }

    @GetMapping
    public ResponseEntity<ResponseDto> findAll(){
        List<Product> products = productServiceInter.findAll();

        if(products == null || products.size() == 0){
            return ResponseEntity.ok(new ResponseDto(404,"Not found",null));
        }

        return ResponseEntity.ok(
                new ResponseDto(200,"Found",ProductMapper.entitiesToDtos(products))
        );
    }

    @PostMapping
    public ResponseEntity<ResponseDto> save(@RequestBody ProductDto productDto){

        Product product = productServiceInter.save(productDto);

        if(product==null) return ResponseEntity.ok(new ResponseDto(500,"Failed",null));

        return ResponseEntity.ok(
                new ResponseDto(200,"Added",ProductMapper.entityToDto(product))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> remove(@PathVariable(name = "id") Integer id){
        Product pr = productServiceInter.remove(id);
        if(pr == null){
            return ResponseEntity.ok(new ResponseDto(500,"Failed",null));
        }

        return ResponseEntity.ok(
                new ResponseDto(200,"Removed",ProductMapper.entityToDto(pr))
        );
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@RequestBody ProductDto productDto){
        Product pr = productServiceInter.update(productDto);

        if(pr == null){
            return ResponseEntity.ok(new ResponseDto(500,"Failed",null));
        }

        return ResponseEntity.ok(
                new ResponseDto(200,"Updated",ProductMapper.entityToDto(pr))
        );
    }

    @PostMapping("/send")
    public ResponseDto send(@RequestBody RequestDto requestDto){
        System.out.println(requestDto.getMessage());

        Product readyForSending = productServiceInter.prepareForClient(requestDto);

        if(readyForSending == null) {
            return null;
        }

        productOrderServiceInter.
                save(new ProductOrderDto(requestDto.getQuantity(),new ProductDto(readyForSending.getId())));

        System.out.println(readyForSending);

        return new ResponseDto(200,"We send your order , quantity "+readyForSending.getQuantity() ,ProductMapper.entityToDto(readyForSending));
    }

}
