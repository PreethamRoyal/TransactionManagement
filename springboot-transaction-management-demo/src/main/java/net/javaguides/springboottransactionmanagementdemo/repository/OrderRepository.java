package net.javaguides.springboottransactionmanagementdemo.repository;

import net.javaguides.springboottransactionmanagementdemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
