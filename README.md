# Spring Boot CRUD Starter

🚀 **Professional CRUD Starter Library for Spring Boot** 🇸🇳

Spring Boot CRUD Starter is a reusable library that transforms any JPA entity into a complete REST API with Spring Data REST, DTO projections, RSQL search, soft delete, and automatic mapping.

**Never write CRUD controllers again!**

## 📦 Installation

### From GitHub Packages (recommended)
```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/YOUR_USERNAME/spring-boot-crud-starter</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>sn.dakar</groupId>
        <artifactId>spring-boot-crud-starter</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

### From local repo
After `mvn install` of the project:
```xml
<dependency>
    <groupId>sn.dakar</groupId>
    <artifactId>spring-boot-crud-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 🚀 Usage in 5 steps

### 1. Create your entity
```java
import sn.dakar.entity.BaseEntity;
import lombok.Data;
import jakarta.persistence.Entity;

@Entity
@Data
public class Product extends BaseEntity {
    private String name;
    private double price;
    private String category;
}
```

### 2. Create DTO projection (optional for response)
```java
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "productDetail", types = Product.class)
public interface ProductDetailDto {
    Long getId();
    String getName();
    double getPrice();
    String getCategory();
}
```

### 3. Create the repository
```java
import sn.dakar.repository.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "products", excerptProjection = ProductDetailDto.class)
public interface ProductRepository extends BaseRepository<Product> {
}
```

### 4. Create request DTO (optional for input)
```java
public record ProductRequestDto(String name, double price, String category) {
}
```

### 5. Create MapStruct mapper (optional)
```java
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductRequestDto dto);
    void updateProductFromDto(ProductRequestDto dto, @MappingTarget Product product);
}
```

### 6. Create service (optional for business logic)
```java
import sn.dakar.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractCrudService<Product> {
    public ProductService(ProductRepository repository) {
        super(repository);
    }
}
```

### 7. Create controller (optional for custom endpoints)
```java
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    private final ProductMapper mapper;

    @PostMapping
    public Product create(@RequestBody ProductRequestDto dto) {
        return service.save(mapper.toProduct(dto));
    }
}
```

## 🎯 Result

**Your REST API is ready!**

- **GET** `/api/products` → Paginated list with DTO projection
- **GET** `/api/products/1` → Single product detail
- **POST** `/api/products` → Create (with DTO)
- **PUT** `/api/products/1` → Update
- **DELETE** `/api/products/1` → Soft delete
- **GET** `/api/products/search?name==Laptop` → RSQL search
- **GET** `/api/products?page=0&size=10` → Pagination

## 📋 Included Features

✅ **Spring Data REST** automatic
✅ **DTO projections** to hide entities
✅ **RSQL advanced search**
✅ **Soft delete** with @Where
✅ **Automatic auditing** (createdAt, updatedAt)
✅ **MapStruct automatic mapping**
✅ **Lombok @Data** to reduce code
✅ **Swagger/OpenAPI** integrated
✅ **SOLID principles** (separated layers)
✅ **Pagination** and sorting automatic

## 🔧 Required Configuration

In your `application.properties`:
```properties
# Database
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=create-drop

# Enable projections
spring.data.rest.detection-strategy=annotated
```

## 📖 Complete Example

See the `sn.dakar` package for a complete example with `Client`.

## 🤝 Contributing

1. Fork the repo
2. Create your branch (`git checkout -b feature/AmazingFeature`)
3. Commit (`git commit -m 'Add AmazingFeature'`)
4. Push (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

MIT License - see LICENSE file for details.

---

**Made with ❤️ for the Senegalese dev community** 🇸🇳