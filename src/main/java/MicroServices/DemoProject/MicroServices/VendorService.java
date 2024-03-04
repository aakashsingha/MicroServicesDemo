package MicroServices.DemoProject.MicroServices;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    

    @Autowired

    VendorServiceRepository vendorservicerepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    public List<Vendor> getallvendors()
    {
        return (vendorservicerepository.getAll());
    }

    public void postVendor(VendorRequest vendorRequest) throws JsonProcessingException {
        Vendor vendor = new Vendor((int)(Math.random()*1000),vendorRequest.getName(),vendorRequest.getLocation());
        vendorservicerepository.postvendor(vendor);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(vendor);
        rabbitTemplate.convertAndSend(rabbitMQConfig.queue().getName(), jsonString);
    }
}
