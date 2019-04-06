package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.carts.CartDto;
import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.order.ItemDto;
import com.kodilla.ecommercee.domain.order.Order;
import com.kodilla.ecommercee.domain.order.OrderDto;
import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.users.User;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ItemMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    ItemMapper itemMapper;

    @GetMapping(value = "getProductsFromCart")
    public List<ItemDto> getProductsFromCart(@RequestParam Long cartId)  {
        Group food = new Group();
        Product jam = new Product(1L, "jam", "strawberry jam", Collections.emptyList(), new Group());
        List<Product> list = Arrays.asList(jam);
        Cart cart1 = new Cart("DefaultUserCart", 15L,list);
        cart1.getProducts().add(jam);
        return cart1.getProducts().stream()
                .map(product -> new ItemDto(1L, new OrderDto(), product.getId(), product.getName(), product.getDescription(), 1.0, 1.0))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
        Cart newCart = cartMapper.mapToCart(cartDto);
    }

    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody CartDto cartDto) {
        Order newOrder = new Order(1L, new Date(), new User(), itemMapper.itemDtoListToItemList(cartDto.getItems()), false);
    }

    @PostMapping(value = "addItemToCart", consumes = APPLICATION_JSON_VALUE)
    public void addItemToCart(@RequestBody ItemDto productDto, CartDto cartDto) {
        Group food = new Group();
        Product jam = new Product(1L, "jam", "strawberry jam", Collections.emptyList(), new Group());
        List<Product> list = Arrays.asList(jam);
        Cart newCart = new Cart("UserCart", cartDto.getUserId(),list);
        newCart.getProducts().add(productMapper.mapToProduct(productDto));
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long productId, Long cartId) {
        Group food = new Group();
        Product jam = new Product(1L, "jam", "strawberry jam", Collections.emptyList(), new Group());
        List<Product> list = Arrays.asList(jam);
        Cart newCart = new Cart("testCart", 15L,list);
        Product laptop = new Product(1L, "notebook", "brand new notebook", Collections.emptyList(), new Group());
        newCart.getProducts().add(laptop);
        newCart.getProducts().remove(laptop); //W prawdziwej implementacji ustawienie pola boolean "isDeleted" produktu na true
    }
}
