package org.zer0.test.jaxrs.interceptor;

import java.security.Key;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.zer0.test.jaxrs.jwt.key.KeyGenerator;

import io.jsonwebtoken.Jwts;

@Interceptor
@SAASecurity
public class SAASeguridadInterceptor {
	
	@Inject
    private KeyGenerator keyGenerator;
	
	@AroundInvoke
    public Object checkSecurity(InvocationContext context) throws Exception {
        /* comprobar los parámetros o realizar una comprobación de seguridad genérica antes de invocar el
           método original */
		
		Map<String,Object> mapa=context.getContextData();
		System.out.println("mapa:"+mapa);
		System.out.println("mapa size:"+mapa.size());
		for (Map.Entry<String, Object> v : mapa.entrySet()) {
			System.out.println("k:"+v.getKey()+" - v:"+v.getValue());
		}
		
		HttpHeaders head=null;
        Object[] params = context.getParameters();
        for (Object object : params) {
			System.out.println("->"+object);
			if(object instanceof HttpHeaders){
				System.out.println("headers!!!!!");
				head=(HttpHeaders)object;
			}
			
		}
        List<String> lstAuth=head.getRequestHeader(HttpHeaders.AUTHORIZATION);
        if(lstAuth!=null){
        	String auth=null;
            for (String string : lstAuth) {
    			auth=string;
    		}
            System.out.println("auth:"+auth);
            if (auth == null || !auth.startsWith("Bearer ")) {
            	System.out.println("#### invalid authorizationHeader : " + auth);
            	throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }
            
            
            String token = auth.substring("Bearer".length()).trim();
            try {

                // Validate the token
                Key key = keyGenerator.generateKey();
                String[] partes=token.split("\\.");
                for (String string : partes) {
					System.out.println("parte:"+string);
					Decoder b=Base64.getDecoder();
	                byte[] decodeparte=b.decode(string);
	                System.out.println("decode: "+new String(decodeparte));
				}
                //String primeraParte=token.substring(0,token.indexOf("."));
                
                Jwts.parser().setSigningKey(key).parseClaimsJws(token);
                System.out.println("#### valid token : " + token);
                

            } catch (Exception e) {
            	e.printStackTrace();
                System.out.println("#### invalid token : " + token);
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }
        }else{
        	throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        
        /* si la validación de seguridad falla, puede generar una excepción */

        /* invocar el método proceed() para que llame al método original */
        Object ret = context.proceed();
        /* realizar cualquier trabajo posterior a llamada de método */
        return ret;
    }
	
}
