package pizzashop.service;

import org.junit.jupiter.api.Test;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import static org.junit.jupiter.api.Assertions.*;

class PizzaServiceTestWhite {

    @Test
    void testP1() throws Exception {
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        pizzaService.setPaymentRepo(null);

        assertEquals(0d, pizzaService.getTotalAmount(PaymentType.Cash));
    }
    @Test
    void testP2() throws Exception {
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        assertEquals(0d, pizzaService.getTotalAmount(PaymentType.Cash));
    }
    @Test
    void testP4() throws Exception {
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        pizzaService.addPayment(1, PaymentType.Cash, 20d);
        pizzaService.addPayment(3, PaymentType.Cash, 20d);
        pizzaService.addPayment(4, PaymentType.Cash, 20d);
        pizzaService.addPayment(5, PaymentType.Cash, 20d);

        assertEquals(0d, pizzaService.getTotalAmount(PaymentType.Card));
    }
}
