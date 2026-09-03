package nischaya.example6.JpaRelationshipsTransactionalProject.repository;

import nischaya.example6.JpaRelationshipsTransactionalProject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
