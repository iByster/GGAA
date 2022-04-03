package pizzashop.service;

import pizzashop.model.MenuDataModel;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import java.util.List;

public class PizzaService {

    private final MenuRepository menuRepo;
    private PaymentRepository payRepo;

    public PizzaService(MenuRepository menuRepo, PaymentRepository payRepo){
        this.menuRepo=menuRepo;
        this.payRepo=payRepo;
    }

    public void validate(Payment payment) throws Exception {
        if(payment.getAmount() <= 0d) {
            throw new Exception("Invalid ammount !!!");
        }

        if(payment.getTableNumber() < 1 || payment.getTableNumber() > 8) {
            throw new Exception("Invalid table");
        }
    }

    public List<MenuDataModel> getMenuData() {return menuRepo.getMenu();}

    public List<Payment> getPayments(){return payRepo.getAll(); }

    public void setPaymentRepo(PaymentRepository payRepo) {
        this.payRepo = payRepo;
    }

    public boolean addPayment(int table, PaymentType type, double amount) throws Exception {
        Payment payment= new Payment(table, type, amount);
        this.validate(payment);
        payRepo.add(payment);
        return true;
    }

    public double getTotalAmount(PaymentType type){
        double total=0.0f;
        List<Payment> l=getPayments();
        if (l==null)
            return total;

        if(l.isEmpty())
            return total;
        for (Payment p:l){
            if (p.getType().equals(type))
                total+=p.getAmount();
        }
        return total;
    }

}