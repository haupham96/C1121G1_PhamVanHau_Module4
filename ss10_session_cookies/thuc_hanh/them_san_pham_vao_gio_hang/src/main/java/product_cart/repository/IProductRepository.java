package product_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import product_cart.model.Product;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
