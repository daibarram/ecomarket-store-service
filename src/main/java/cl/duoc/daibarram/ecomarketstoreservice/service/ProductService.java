package cl.duoc.daibarram.ecomarketstoreservice.service;

import cl.duoc.daibarram.ecomarketstoreservice.repository.ProductRepository;
import cl.duoc.daibarram.ecomarketstoreservice.repository.entity.ProductEntity;
import cl.duoc.daibarram.ecomarketstoreservice.service.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        List<ProductEntity> products = productRepository.getAll();
        List<Product> productList = new ArrayList<>();
        for (ProductEntity productEntity : products) {
            productList.add(
                    new Product(
                       productEntity.getId(),
                       productEntity.getStoreId(),
                       productEntity.getName(),
                       productEntity.getDescription(),
                       productEntity.getPrice()
                    ));
        }
        return productList;
    }

    public Product getProductById(int id) {
        List<Product> products = getProducts();
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public boolean saveProduct(Product product) {
        ProductEntity productEntity = productRepository.getByName(product.getName());
        if (productEntity == null) {
            productRepository.save(
                    new ProductEntity(
                        product.getId(),
                        product.getStoreId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                    ));
            return true;
        }
        return false;
    }

    public boolean replaceProduct(int id, Product newProduct) {
        ProductEntity found = null;
        List<ProductEntity> products = productRepository.getAll();
        for (ProductEntity product : products) {
            if (product.getId() == id) {
                found = product;
            }
        }
        if (found != null) {
            productRepository.replace(
                    found,
                    new ProductEntity(
                        newProduct.getId(),
                        newProduct.getStoreId(),
                        newProduct.getName(),
                        newProduct.getDescription(),
                        newProduct.getPrice()
                    ));
            return true;
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        ProductEntity found = null;
        List<ProductEntity> products = productRepository.getAll();
        for (ProductEntity product : products) {
            if (product.getId() == id) {
                found = product;
            }
        }
        if (found != null) {
            productRepository.delete(found);
            return true;
        }
        return false;
    }
}
