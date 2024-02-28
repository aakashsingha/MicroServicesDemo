package MicroServices.DemoProject.MicroServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VendorServiceRepository {
    
    @Autowired
    VendorRepository vendorrepository;

    public List<Vendor> getAll()
    {
       return vendorrepository.findAll();
    }

    public void postvendor(Vendor vendor)
    {
        vendorrepository.save(vendor);
    }
}
