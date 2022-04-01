package product.repository.impl;

import org.springframework.stereotype.Repository;
import product.model.Product;
import product.repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> listProduct = new HashMap<>();
    private static List<String> nhaSanXuatList = new ArrayList<>();

    static {
        listProduct.put(1, new Product(1, "iPhone1", "1000", "good1", "Apple"));
        listProduct.put(2, new Product(2, "iPhone2", "2000", "good2", "Nokia"));
        listProduct.put(3, new Product(3, "iPhone3", "3000", "good3", "Samsung"));
        listProduct.put(4, new Product(4, "iPhone4", "4000", "good4", "Yamaha"));
        listProduct.put(5, new Product(5, "iPhone5", "5000", "okok", "Toyota"));

        nhaSanXuatList.add("Apple");
        nhaSanXuatList.add("Nokia");
        nhaSanXuatList.add("Samsung");
        nhaSanXuatList.add("Yamaha");
        nhaSanXuatList.add("Toyota");
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(listProduct.values());
    }

    private Integer lastID() {
        Integer lastID = 0;
        for (Product ls : this.getAllProducts()) {
            lastID = ls.getId();
        }
        return lastID;
    }

    @Override
    public List<String> getAllManufacturer() {
        return nhaSanXuatList;
    }

    @Override
    public void save(Product product) {
        product.setId(this.lastID() + 1);
        listProduct.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return listProduct.get(id);
    }

    @Override
    public void editProduct(Integer id, Product product) {
        listProduct.put(id, product);
    }

    @Override
    public List<Product> findByName(String searchName) {
        List<Product> list = this.getAllProducts();
        List<Product> productList = new ArrayList<>();
        for(Product ls:list){
            if(ls.getTenSanPham().contains(searchName)){
                productList.add(ls);
            }
        }
        return productList;
    }

    @Override
    public void deleteById(Integer idDelete) {
        listProduct.remove(idDelete);
    }

}
