package com.book.mvc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        final CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        return resolver;
    }

    //    @Bean
    //    public MappingJackson2JsonView jsonView() {
    //        final MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
    //        jsonView.setPrettyPrint(true);
    //        return jsonView;
    //    }
    //
    //    @Bean
    //    public MarshallingView xmlView() {
    //        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    //        marshaller.setClassesToBeBound(Product.class);
    //        return new MarshallingView(marshaller);
    //    }
    //
    //    @Bean
    //    public ViewResolver contentNegotiatingViewResolver(final ContentNegotiationManager manager) {
    //        final ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
    //        resolver.setContentNegotiationManager(manager);
    //        final ArrayList<View> views = new ArrayList<>();
    //        views.add(jsonView());
    //        views.add(xmlView());
    //        resolver.setDefaultViews(views);
    //        return resolver;
    //  }
}
