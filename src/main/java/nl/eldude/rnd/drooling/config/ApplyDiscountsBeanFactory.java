package nl.eldude.rnd.drooling.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * (C) Copyright 2019 Hewlett Packard Enterprise Development LP
 *
 * @author Gabriel Inäbnit - 2019-11-26
 */
@Configuration
@ComponentScan("nl.eldude.rnd.drooling.service")
public class ApplyDiscountsBeanFactory
{

	private static final String RULES_DIR = "nl/eldude/rnd/drooling/rules";
	private static final String RULE_FILE = "applyDiscounts.drl";

	@Bean
	public KieContainer kieContainer()
	{
		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_DIR + "/" + RULE_FILE));
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();
		return kieServices.newKieContainer(kieModule.getReleaseId());
	}

}
