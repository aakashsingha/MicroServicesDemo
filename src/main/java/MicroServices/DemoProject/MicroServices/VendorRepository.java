package MicroServices.DemoProject.MicroServices;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendorRepository extends MongoRepository<Vendor,Integer> {
    
}
