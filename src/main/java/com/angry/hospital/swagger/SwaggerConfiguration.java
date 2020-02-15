package com.angry.hospital.swagger;

import com.angry.hospital.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	

	@Bean
	public Docket productApi() {

		ParameterBuilder aParameterBuilder1 = new ParameterBuilder();
		aParameterBuilder1.name(Constants.AUTHORIZATION_KEY).description("Authentication Token")
				.modelRef(new ModelRef("string")).parameterType("header")
				.defaultValue("")
				.required(false)
				.build();
		List<Parameter> aParameters = new ArrayList<>();
		aParameters.add(aParameterBuilder1.build());
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.angry.hospital")).build().apiInfo(metaData()).globalOperationParameters(aParameters);
	}

	private ApiInfo metaData() {
		return new ApiInfo("Hospital Api", "", "", "",
				new Contact("", "", ""),
				"", "");
	}
}
