package MicroServices.DemoProject.MicroServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    

    @Autowired

    VendorServiceRepository vendorservicerepository;

    public List<Vendor> getallvendors()
    {
        return (vendorservicerepository.getAll());
    }

    public void postVendor(VendorRequest vendorRequest)
    {
        Vendor vendor= new Vendor((int)(Math.random()*1000),vendorRequest.getName(),vendorRequest.getLocation());
        vendorservicerepository.postvendor(vendor);
    }
}
