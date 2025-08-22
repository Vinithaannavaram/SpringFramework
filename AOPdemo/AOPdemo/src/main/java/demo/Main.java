package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String a[]) {
		ApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
		Checkout obj = con.getBean(Checkout.class);
        obj.checkoutOrder("cancelled");
        Login log= con.getBean(Login.class);
        log.checkoutOrder();
	}
}
