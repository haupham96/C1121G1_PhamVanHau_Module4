package product.repository;

import product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProducts();

    List<String> getAllManufacturer();

    void save(Product product);

    Product findById(Integer id);

    void editProduct(Integer id, Product product);

    List<Product> findByName(String searchName);

    void deleteById(Integer idDelete);
}
