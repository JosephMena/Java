package org.zer0.test.jaxrs.security;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class SAADecorator implements SAASecurity{

	@Inject
    @Delegate
    private SAASecurity decoratedItem;

    public String getInformation() {
        /* realizar registro cronológico */
    	System.out.println("antes");
        String info = decoratedItem.getInformation();
        System.out.println("info:"+info);
        System.out.println("luego");
        /* realizar registro cronológico adicional */
        return info;
    }
}
