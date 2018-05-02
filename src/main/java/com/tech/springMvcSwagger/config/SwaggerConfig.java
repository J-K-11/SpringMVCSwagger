package com.tech.springMvcSwagger.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
    public Docket employeeApiV1() {

		return new Docket(DocumentationType.SWAGGER_2).groupName("Employee-api-version-1.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tech.springMvcSwagger.controllers"))
                .paths(PathSelectors.regex("/v1/.*"))
                .build()
              .apiInfo(metaDataV1());
    }
	
	private ApiInfo metaDataV1() {
		
        ApiInfo apiInfo = new ApiInfo( "Swagger Employee Documentation-1.0",
                "This is employee api documentation. The document list out all APIs that supports employee operations like saving, fetching employee by id and employee listing.",
                "1.0",
                "http://swagger.io/terms/", "Jasleenkhurana48@gmail.com", "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
    
	@Bean
	public Docket employeeApiV2() {
		
		//configuring header for api calls
		Parameter tokenId = (Parameter) new ParameterBuilder().name("tokenId").description("tokenId").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
		List<Parameter> list = new ArrayList<Parameter>();
		list.add(tokenId);
		
		return new Docket(DocumentationType.SWAGGER_2).groupName("Employee-api-version-2.0").globalOperationParameters(list)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.tech.springMvcSwagger.controllers"))
        .paths(PathSelectors.regex("/v2/.*"))
        .build()
      .apiInfo(metaDataV2());
	}
	
	private ApiInfo metaDataV2() {
			
	        ApiInfo apiInfo = new ApiInfo( "Swagger Employee Documentation-2.0",
	                "This is employee api documentation. The document list out all APIs that supports employee operations like saving, fetching employee by id and employee listing. The api also requires tokenId as its header.",
	                "2.0",
	                "http://swagger.io/terms/", "Jasleenkhurana48@gmail.com", "Apache 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0");
	        return apiInfo;
	    }
	
}
