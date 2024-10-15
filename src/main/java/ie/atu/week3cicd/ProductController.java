package ie.atu.week3cicd;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> productList = new ArrayList<>();

    public ProductController() {
        //Initialises with some sample products
        productList.add(new Product("1","TV", "Electronics", 600.0));
        productList.add(new Product("2","Phone", "Electronics", 600.0));

    }
    //GET Endpoint to fetch all products
    @GetMapping
    public List<Product> getAllProducts() {
       return productList;
    }

    //post Endpoint to add a new product
    @PostMapping
    public Product addProduct(@RequestBody Product newProduct) {
        productList.add(newProduct);
        return newProduct;
    }

        @PutMapping("/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody Product updatedProduct) {
        for(int i = 0; i < productList.size(); i++){
            Product existingProduct = productList.get(i);
            if(existingProduct.getId().equals(id)){
                productList.set(i, updatedProduct);
                return ResponseEntity.ok(updatedProduct);
            }
        }
        return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/{id}")
                public ResponseEntity<List<Product>> deleteProduct(@PathVariable String id){
        boolean removed = productList.removeIf(p -> p.getId().equals(id));
           if (removed){
               return ResponseEntity.ok(productList);
           }
           else{
               return ResponseEntity.notFound().build();
           }

        }
    }

