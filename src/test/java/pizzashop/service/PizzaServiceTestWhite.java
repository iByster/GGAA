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
}
