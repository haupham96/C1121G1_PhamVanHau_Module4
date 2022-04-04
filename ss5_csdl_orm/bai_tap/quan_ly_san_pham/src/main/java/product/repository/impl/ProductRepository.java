package product.repository.impl;

import org.springframework.stereotype.Repository;
import product.model.Product;
import product.repository.BaseRepository;
import product.repository.IProductRepository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {
    private static List<String> nhaSanXuatList = new ArrayList<>();
    static {
        nhaSanXuatList.add("Apple");
        nhaSanXuatList.add("Nokia");
        nhaSanXuatList.add("Samsung");
        nhaSanXuatList.add("Yamaha");
        nhaSanXuatList.add("Toyota");
    }

    @Override
    public List<Product> getAllProducts() {
        String sql = " select p from Product p order by p.tenSanPham";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(sql, Product.class);
        return query.getResultList();
    }


    @Override
    public List<String> getAllManufacturer() {
        return nhaSanXuatList;
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        String sql = "select p from Product p where p.id = ?1 ";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(sql, Product.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public void editProduct(Integer id, Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public List<Product> findByName(String searchName) {
        List<Product> list = this.getAllProducts();
        List<Product> productList = new ArrayList<>();
        for (Product ls : list) {
            if (ls.getTenSanPham().contains(searchName)) {
                productList.add(ls);
            }
        }
        return productList;
    }

    @Override
    public void deleteById(Integer idDelete) {
        Product product = this.findById(idDelete);
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(product);
        transaction.commit();
    }

}
