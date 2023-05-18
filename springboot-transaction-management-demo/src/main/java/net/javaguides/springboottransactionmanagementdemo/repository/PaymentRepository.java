package net.javaguides.springboottransactionmanagementdemo.repository;

import net.javaguides.springboottransactionmanagementdemo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
