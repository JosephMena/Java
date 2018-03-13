package org.zer0.test.jaxrs.interceptor;

import java.util.Map;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.openjpa.jdbc.sql.FirebirdDictionary;

@Interceptor
@SAASecurity
public class SAASeguridadInterceptor {
	
	@AroundInvoke
    public Object checkSecurity(InvocationContext context) throws Exception {
        /* comprobar los par�metros o realizar una comprobaci�n de seguridad gen�rica antes de invocar el
           m�todo original */
		
		Map<String,Object> mapa=context.getContextData();
		System.out.println("mapa:"+mapa);
		System.out.println("mapa size:"+mapa.size());
		for (Map.Entry<String, Object> v : mapa.entrySet()) {
			System.out.println("k:"+v.getKey()+" - v:"+v.getValue());
		}
		
        Object[] params = context.getParameters();
        for (Object object : params) {
			System.out.println("->"+object);
			if(object instanceof HttpHeaders){
				System.out.println("headers!!!!!");
				HttpHeaders head=(HttpHeaders)object;
				System.out.println("auth:"+head.getRequestHeader(HttpHeaders.AUTHORIZATION));
			}
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
        
        /* si la validaci�n de seguridad falla, puede generar una excepci�n */

        /* invocar el m�todo proceed() para que llame al m�todo original */
        Object ret = context.proceed();
        /* realizar cualquier trabajo posterior a llamada de m�todo */
        return ret;
    }
	
}
