package com.kodilla.ecommercee.domain.order;

<<<<<<< HEAD:src/main/java/com/kodilla/ecommercee/domain/order/OrderDto.java
import com.kodilla.ecommercee.domain.users.User;
=======
import com.kodilla.ecommercee.domain.user.User;
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f:src/main/java/com/kodilla/ecommercee/domain/order/OrderDto.java
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD:src/main/java/com/kodilla/ecommercee/domain/order/OrderDto.java
=======
import java.util.ArrayList;
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f:src/main/java/com/kodilla/ecommercee/domain/order/OrderDto.java
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private Long orderId;
    private Date date;
    private User user;
<<<<<<< HEAD:src/main/java/com/kodilla/ecommercee/domain/order/OrderDto.java
    private List<ItemDto> items;
=======
    private List<Item> items;
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f:src/main/java/com/kodilla/ecommercee/domain/order/OrderDto.java
    private Boolean paid;
}
