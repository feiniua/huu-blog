package cn.wen233.blog.infrustructure.config.shiro;

import cn.wen233.blog.core.service.UserService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: huu
 * @date: 2020/4/8 13:09
 * @description:
 */
@Configuration
public class ShiroConfig {

    private final UserService service;

    public ShiroConfig(UserService service) {
        this.service = service;
    }

    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm(service);
    }

    /**
     * 注入 securityManager
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(CustomRealm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(customRealm);
        return securityManager;
    }

    /**
     * anon: 无需验证
     * authc: 必须验证了才能访问
     * user: 必须拥有记住我功能才能访问
     * perms: 拥有对某个资源的权限才能访问
     * role: 拥有某个角色才能访问
     *
     * 请求过滤
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //        shiroFilterFactoryBean.setSuccessUrl("/success");
        shiroFilterFactoryBean.setUnauthorizedUrl("/notPerms");
        shiroFilterFactoryBean.setLoginUrl("/notLogin");

        /**
         * 添加自定义拦截器 对请求方法的不同进行拦截
         */
        Map<String, Filter> filterMap = shiroFilterFactoryBean.getFilters();
        filterMap.put("authc", new CustomShiroFilter());

        shiroFilterFactoryBean.setFilterChainDefinitionMap(getFilterMap());

        return shiroFilterFactoryBean;
    }

    private Map<String, String> getFilterMap() {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("/api/login", "anon");
        map.put("/**", "authc");
        return map;
    };
}