package hebei.engineery.univercity.web.confuager;

import hebei.engineery.univercity.web.interceptor.ActionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
/**
 * Created by Administrator on 2017/12/10.
 * 添加拦截规则
 */
@Configuration
public class HandlerConfigurer extends WebMvcAutoConfigurationAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ActionInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/dolocation").excludePathPatterns("/register/**");
    }
}
