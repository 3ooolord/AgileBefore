package edu.ait.listnames.utils;


import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @program: listnames
 * @description:
 **/
@Configuration
public class SwaggerConfig {

    /**
     * 创建docket类型的对象  并用spring容器管理.
     * docket是swagger中的全局配置对象
     * @return
     */
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
            ApiInfo apiInfo = new ApiInfoBuilder()
                    .contact(new Contact("Wang Shi Yu Swagger 2 Api document","localhost:8080/","A00279842@student.ait.ie"))
                    .title("Swagger2  Apis Document")
                    .description("Swagger framework is build to help developer to understand and develop rest style Apis' document")
                    .version("0.01")
                    .build();
            docket.apiInfo(apiInfo);
            docket.select()  //获取docket中的选择器 返回ApiSelectBuilder  构建选择器  例如 :  扫描什么包的注解
                    .apis(RequestHandlerSelectors.basePackage("edu.ait.listnames"));//设定扫描某个包(包含子包)中的注解.
            return docket;
    }

}
