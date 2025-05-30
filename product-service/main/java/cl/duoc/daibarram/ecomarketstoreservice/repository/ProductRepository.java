package cl.duoc.daibarram.ecomarketstoreservice.repository;

import cl.duoc.daibarram.ecomarketstoreservice.repository.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    List<ProductEntity> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new ProductEntity(1, 1, "Pan", "Pan integral 500g", 1500));
        products.add(new ProductEntity(2, 1, "Leche", "Leche descremada 1L", 1200));
        products.add(new ProductEntity(3, 1, "Arroz", "Arroz grano largo 1kg", 1800));
    }

    public List<ProductEntity> getAll() {
        return products;
    }

    public void save(ProductEntity product) {
        product.setId(products.size() + 1);
        products.add(product);
    }

    public void replace(ProductEntity found, ProductEntity replacement) {
        int index = products.indexOf(found);
        replacement.setId(found.getId());
        products.set(index, replacement);
    }

    public void delete(ProductEntity found) {
        products.remove(found);
    }

    public ProductEntity getByName(String name) {
        for (ProductEntity product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public ProductEntity getById(int id) {
        for (ProductEntity product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}