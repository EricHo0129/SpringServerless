package eric.spring;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.amazonaws.serverless.proxy.RequestReader;
import com.amazonaws.serverless.proxy.model.ApiGatewayRequestContext;

public class CognitoIdentityFilter implements Filter {

	public static final String COGNITO_IDENTITY_ATTRIBUTE = "com.amazonaws.serverless.cognitoId";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Object apiGwContext = request.getAttribute(RequestReader.API_GATEWAY_CONTEXT_PROPERTY);
        if (apiGwContext == null) {
            System.out.println("API Gateway context is null");
            chain.doFilter(request, response);
        }
        if (!ApiGatewayRequestContext.class.isAssignableFrom(apiGwContext.getClass())) {
        	System.out.println("API Gateway context object is not of valid type");
            chain.doFilter(request, response);
        }

        ApiGatewayRequestContext ctx = (ApiGatewayRequestContext)apiGwContext;
        if (ctx.getIdentity() == null) {
        	System.out.println("Identity context is null");
            chain.doFilter(request, response);
        }
        String cognitoIdentityId = ctx.getIdentity().getCognitoIdentityId();
        if (cognitoIdentityId == null || "".equals(cognitoIdentityId.trim())) {
        	System.out.println("Cognito identity id in request is null");
        }
        request.setAttribute(COGNITO_IDENTITY_ATTRIBUTE, cognitoIdentityId);
        chain.doFilter(request, response);
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
