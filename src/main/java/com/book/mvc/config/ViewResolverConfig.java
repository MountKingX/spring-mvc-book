package com.book.mvc.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ViewResolverConfig {

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
