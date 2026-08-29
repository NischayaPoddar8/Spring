package nischaya.example.TransactionDemo2.repository;

import nischaya.example.TransactionDemo2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
