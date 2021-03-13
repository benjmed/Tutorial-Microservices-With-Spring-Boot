package ecommerce.cartservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ecommerce.cartservice.entity.Product;
import ecommerce.cartservice.repository.ProductRepository;

@Component
public class JmsConsumer {

    @Autowired
    ProductRepository productRepository;
    
    @JmsListener(destination = "${product.jms.destination}")
    public void consumeMessage(String data)  {

        try {

            ObjectMapper mapper = new ObjectMapper();
            //Json data to Product object
            Product product = mapper.readValue(data,Product.class);
            productRepository.save(product);

        } catch (JsonProcessingException e){
            e.getStackTrace();
        }
    }
}