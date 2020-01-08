package nl.eldude.rnd.drooling.service;

import nl.eldude.rnd.drooling.model.Order;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (C) Copyright 2019 Hewlett Packard Enterprise Development LP
 *
 * @author Gabriel Inäbnit - 2019-11-26
 */
@Service
public class ApplyDiscountsService
{

	@Autowired
	private KieContainer kieContainer;

	public Order applyDiscounts(Order order)
	{
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("order", order);
		kieSession.fireAllRules();
		kieSession.dispose();
		return order;
	}

}
