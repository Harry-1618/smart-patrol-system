package com.hrt.smartpatrolsystem.common.interceptor;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MybatisPlusInterceptor
 * Package: com.hrt.smartpatrolsystem.common.interceptor
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/1 - 15:58
 * @Version: v1.0
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * IPage的分页使用的是拦截器，属于物理分页，好处就是处理大量数据时，查询速度快。
     *
     * @return MybatisPlus拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 向MybatisPlus拦截器链中添加分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
