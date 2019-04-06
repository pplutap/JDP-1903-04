package com.kodilla.ecommercee.mapper;

<<<<<<< HEAD
import com.kodilla.ecommercee.domain.order.ItemDto;
import com.kodilla.ecommercee.domain.order.OrderDto;
import com.kodilla.ecommercee.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.kodilla.ecommercee.domain.product.Product;
import com.kodilla.ecommercee.domain.product.ProductDto;
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

<<<<<<< HEAD
    @Autowired
    GroupMapper groupMapper;

    public Product mapToProduct(final ItemDto productDto) {
        return new Product();
=======
    public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getProductId(), productDto.getName(), productDto.getDescription(), productDto.getPrice(), productDto.getGroup(), productDto.getDeleted(), productDto.getCarts());
    }

    //Do zrobienia GroupMapper
    public ProductDto mapToProductDto(final Product product){
        return new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getGroup(), product.getIsDeleted(), product.getCarts());
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
    }

    public List<ItemDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
<<<<<<< HEAD
                .map(product -> new ItemDto(1L, new OrderDto(), product.getId(), product.getName(), product.getDescription(), 1.0, 1.0)).collect(Collectors.toList());
=======
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getGroup(), product.getIsDeleted(), product.getCarts()))
                .collect(Collectors.toList());
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
    }

    public List<Product> mapToProductList(final List<ItemDto> productDtoList) {
        return productDtoList.stream()
<<<<<<< HEAD
                .map(productDto -> new Product()).collect(Collectors.toList());
=======
                .map(productDto -> new Product(productDto.getProductId(), productDto.getName(), productDto.getDescription(), productDto.getPrice(), productDto.getGroup(), productDto.getDeleted(), productDto.getCarts()))
                .collect(Collectors.toList());
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
    }
}
