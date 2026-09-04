package nischaya.example6.JpaRelationshipsTransactionalProject.repository;

import nischaya.example6.JpaRelationshipsTransactionalProject.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    @EntityGraph(attributePaths = {"orderList","orderList.productList"})
    public Optional<User> findWithOrdersAndProductsById(Long id);

}
