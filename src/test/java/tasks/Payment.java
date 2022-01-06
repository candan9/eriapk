package tasks;

import io.appium.java_client.HidesKeyboard;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnElement;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import ui.HomePageElements;
import ui.PaymentPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class Payment implements Task {
    private String username="company";
    private String password="company";
    private String phone="5060643018";
    private String name ="Emre";
    public Payment() {
    }



    @Override
    @Step("{0} deposite to the eribank")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(HomePageElements.PAYMENT_BTN),
                //WaitUntil.the(HomePageElements.PAYMENT_BTN,isClickable()).forNoMoreThan(2).seconds(),
                Click.on(PaymentPageElements.PHONE_FIELD),
                SendKeys.of(this.phone).into(PaymentPageElements.PHONE_FIELD),
                Click.on(PaymentPageElements.NAME_FIELD),
                SendKeys.of(this.name).into(PaymentPageElements.NAME_FIELD),
                SendKeys.of("50").into(PaymentPageElements.AMOUNT_SCROLL),

                Click.on(PaymentPageElements.COUNTRY_BUTTON)
                //Click.on(PaymentPageElements.COUNTRY_VALUE)
        );
    }
    
    public static Payment open(){
        return instrumented(Payment.class);
    }



}
