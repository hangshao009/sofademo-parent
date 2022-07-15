package com.zh.sofa_consumer;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.zh.sofa_comm.pojo.Product;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@GlobalTransactional
//@ComponentScan(basePackages = {"com.zh.sofa_provider.mapper.ProductMapper"})
public class ProductClient {

    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"))
    private com.zh.sofa_comm.service.providerService providservice;

    @RequestMapping("/getProduct")
    @Transactional
    public Product findAllProduct(long id){
        return providservice.getProductInfo(id);
    }
    @RequestMapping("/test")
    public void Test(){
        providservice.updateProduct(1);
        //异常
        int a=1/0;
    }
}
