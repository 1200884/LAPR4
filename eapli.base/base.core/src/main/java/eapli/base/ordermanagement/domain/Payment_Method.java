package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Immutable
@Embeddable
public class Payment_Method implements ValueObject {
    private int payment_methodid;

    enum PaymentMethod {
        PAYPAL,
        MBWAY,
        CREDITCARD
    }

    private PaymentMethod paymentMethod;

    protected Payment_Method() {
    }

    public Payment_Method(int payment_methodid, PaymentMethod paymentMethod) {
        this.payment_methodid = payment_methodid;
        this.paymentMethod = paymentMethod;
    }

    public int getPayment_methodid() {
        return payment_methodid;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    private void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    private void setPayment_methodid(int payment_methodid) {
        this.payment_methodid = payment_methodid;
    }
}
