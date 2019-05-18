package com.kodilla.ecommercee.mail.scheduler;



import com.kodilla.ecommercee.mail.Mail;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.service.SimpleEmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class EmailScheduler {
    private SimpleEmailService simpleEmailService;
    private OrderRepository orderRepository;

    private static final String SUBJECT = "Reminder about unclosed order";

    public EmailScheduler(SimpleEmailService simpleEmailService, OrderRepository orderRepository) {
        this.simpleEmailService = simpleEmailService;
        this.orderRepository = orderRepository;
    }

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {

        orderRepository.findOpenOrders().forEach(order -> {
            String mail = order.getUser().getUserMail();


            simpleEmailService.send(new Mail(mail, SUBJECT, "Hey! You currently have open order. We remind you about completing your order." +
                    "Date of order: " + order.getDate()));
        });
    }
}
