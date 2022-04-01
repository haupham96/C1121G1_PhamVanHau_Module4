package product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.model.Product;
import product.repository.IProductRepository;
import product.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts() ;
    }

    @Override
    public List<String> getAllManufacturer() {
        return productRepository.getAllManufacturer();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void editProduct(Integer id, Product product) {
        productRepository.editProduct(id,product);
    }

    @Override
    public List<Product> findByName(String searchName) {
        return productRepository.findByName(searchName);
    }

    @Override
    public void deleteById(Integer idDelete) {
        productRepository.deleteById(idDelete);
    }

}
