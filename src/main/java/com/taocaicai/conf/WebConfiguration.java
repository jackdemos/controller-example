package com.taocaicai.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/** 处理返回字符串异常问题 方式二（推荐此方法）
 * @author Oakley
 * @project controller-example
 * @created 2023-05-15 10:33:10:33
 * @package com.taocaicai.conf
 * @since 0.0.1
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     *
     * 当处理字符串类型时，会抛出 xxx.包装类 cannot be cast to java.lang.String 的类型转换的异常
     * @param converters initially an empty list of converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (int i = 0; i < converters.size(); i++) {
            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = (MappingJackson2HttpMessageConverter) converters.get(i);
                converters.set(i, converters.get(0));
                converters.set(0, mappingJackson2HttpMessageConverter);
                break;
            }
        }
    }
}
