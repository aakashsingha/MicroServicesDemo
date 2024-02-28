package MicroServices.DemoProject.MicroServices;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Vendor")
public class VendorPOJO {

    @Id
    private int v_id;

    private String name;
    private String location;
    
}
