package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

@Immutable
@Embeddable
public class Payment_Method implements ValueObject {

    public enum PaymentMethod {
        PAYPAL,
        MBWAY,
        CREDITCARD
    }

    private PaymentMethod paymentMethod;

    protected Payment_Method() {
    }

    public Payment_Method(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    private void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
