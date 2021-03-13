package ecommerce.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.cartservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}