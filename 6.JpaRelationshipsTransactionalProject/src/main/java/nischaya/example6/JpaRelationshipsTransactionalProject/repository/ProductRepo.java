package nischaya.example6.JpaRelationshipsTransactionalProject.repository;

import nischaya.example6.JpaRelationshipsTransactionalProject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {


}
