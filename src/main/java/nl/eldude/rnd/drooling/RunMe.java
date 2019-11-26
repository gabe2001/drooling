package nl.eldude.rnd.drooling;

import nl.eldude.rnd.drooling.model.Order;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.rule.builder.util.PackageBuilderUtil;
import org.drools.core.WorkingMemory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.core.WorkingMemory;

public class RunMe {

    public static void main(String[] args) throws DroolsParserException, IOException {
        RunMe runMe = new RunMe();
        runMe.executeDrools();
    }

    public void executeDrools() throws DroolsParserException, IOException {

        PackageBuilderUtil packageBuilder = new PackageBuilderUtil();

        String ruleFile = "/nl/eldude/rnd/drooling/rules/applyDiscounts.drl";
        InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

        Reader reader = new InputStreamReader(resourceAsStream);
        packageBuilder.addPackageFromDrl(reader);
        Package rulesPackage = packageBuilder.getPackage();
        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        ruleBase.addPackage(rulesPackage);

        WorkingMemory workingMemory = ruleBase.newStatefulSession();

        Order order = new Order();

        workingMemory.insert(order);
        workingMemory.fireAllRules();

//        System.out.println("The discount for the product " + product.getType()
//                + " is " + product.getDiscount());
    }

}
