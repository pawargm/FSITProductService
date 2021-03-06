package ProductService.Mandinet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import ProductService.Mandinet.CORSFilter;

@EnableDiscoveryClient
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	 SpringApplication.run(App.class, args);
    }
    
    @Bean
 	public FilterRegistrationBean corsFilterRegistration() {
 		FilterRegistrationBean reg = new FilterRegistrationBean(new CORSFilter());
 		reg.setName("CORS Filter");
 		reg.addUrlPatterns("/*");
 		reg.setOrder(1);
 		return reg;	
 	}
}
