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
    public Product addProduct(@RequestBody Product newProduct){
        productList.add(newProduct);
        return newProduct;

    @PutMapping


        @DeleteMapping("/{id}")
                public ResponceEntity<List> deleteProduct(@PathVariable String id){
            for (Product p : productList) {
                if(p.getId().equals(id)){
                    productList.remove(p);
                }

            }

            return ResponceEntity.ok(productList);
        }
    }
}
