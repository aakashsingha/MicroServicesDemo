package MicroServices.DemoProject.MicroServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    

    @Autowired
    VendorService vendorservice;
    
    @GetMapping("/api/vendors")
    public ResponseEntity<List<Vendor>> getvendors()
    {
        List<Vendor> vendors= vendorservice.getallvendors();
        return ResponseEntity.ok().body(vendors);
    }
    
    @PostMapping("/api/vendors")
    public ResponseEntity<String> postvendors( @Validated VendorRequest vendorRequest)
    {
       vendorservice.postVendor(vendorRequest);
       return ResponseEntity.ok().body("Vendor created successfully");
    }

}
