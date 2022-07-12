package com.zh.sofa_consumer;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.zh.sofa_comm.service.providerService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@ComponentScan(basePackages = {"com.zh.sofa_provider.mapper.ProductMapper"})
public class ProductClient {

    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"))
    private com.zh.sofa_comm.service.providerService providservice;

    @RequestMapping("/getall")
    public List<Object> findAllProduct(long id){
        return (List<Object>) providservice.getProductInfo(id);
    }
}
