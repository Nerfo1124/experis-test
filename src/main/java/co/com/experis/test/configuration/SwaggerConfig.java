package co.com.experis.test.configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${api.swagger.tittle}")
	private String apiTittle;

	@Value("${api.swagger.description}")
	private String apiDescription;

	@Value("${api.swagger.version}")
	private String apiVersion;

	@Value("${api.swagger.contact.name}")
	private String contactName;

	@Value("${api.swagger.contact.url}")
	private String contactUrl;

	@Value("${api.swagger.contact.email}")
	private String contactEmail;

	@Value("${api.swagger.service.rootpath}")
	private String serviceRootpath;

	@Value("${api.swagger.base-package}")
	private String basePackage;

	@Value("${api.swagger.service.name}")
	private String serviceName;

	@Autowired
	private TypeResolver typeResolver;

	@Bean
	public Docket sltApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.paths(PathSelectors.any()).build()
				.pathMapping("/").apiInfo(apiInfo())
				.directModelSubstitute(LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(LocalDateTime.class, java.util.Date.class)
				.genericModelSubstitutes(ResponseEntity.class)
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(DeferredResult.class,
								typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
						typeResolver.resolve(WildcardType.class)))
				.useDefaultResponseMessages(false).tags(new Tag(serviceRootpath, serviceName))
				.enableUrlTemplating(true);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(apiTittle, apiDescription, apiVersion, "",
				new Contact(contactName, contactUrl, contactEmail), "", "", Collections.emptyList());
	}

	public String getApiTittle() {
		return apiTittle;
	}

	public String getApiDescription() {
		return apiDescription;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public String getContactName() {
		return contactName;
	}

	public String getContactUrl() {
		return contactUrl;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public String getServiceRootpath() {
		return serviceRootpath;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public String getServiceName() {
		return serviceName;
	}

	public TypeResolver getTypeResolver() {
		return typeResolver;
	}
}
