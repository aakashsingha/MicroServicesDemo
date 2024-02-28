package MicroServices.DemoProject.MicroServices;

import lombok.Data;
import lombok.NonNull;

@Data
public class VendorRequest {

    @NonNull
    String name;
    @NonNull
    String location;
    
}
