import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author cpviola
 *
 */
public class PricingRules {

	/**
	 * 
	 */
	private final Map<String, PricingRule> pricingRulesList = new HashMap<String, PricingRule>();
	
	public Map<String, PricingRule> getAllActivePricingRulesList() {
		Map<String, PricingRule> allActivePricingRules = new HashMap<String, PricingRule>();
		for(Map.Entry<String, PricingRule> entry : pricingRulesList.entrySet()){
			if(entry.getValue().getRuleStatus().equals("Active"))
				allActivePricingRules.put(entry.getKey(), entry.getValue());
		}
		return allActivePricingRules;
	}
	
	public Map<String, PricingRule> getActivePricingRulesList() {
		Map<String, PricingRule> activePricingRules = new HashMap<String, PricingRule>();
		for(Map.Entry<String, PricingRule> entry : pricingRulesList.entrySet()){
			if(entry.getValue().getRuleStatus().equals("Active") && (entry.getValue().getRulePromoCode().equals("NA")))
				activePricingRules.put(entry.getKey(), entry.getValue());
		}
		return activePricingRules;
	}

	public PricingRules() {
		this.pricingRulesList.put("R001", new PricingRule("3 for 2 1 GB", "NA", "Active"));
		this.pricingRulesList.put("R002", new PricingRule("3 above 5 GB", "NA", "Active"));
		this.pricingRulesList.put("R003", new PricingRule("Free 1GB for every 2 GB", "NA", "Active"));
		this.pricingRulesList.put("R004", new PricingRule("10 percent discount", "I<3AMAYSIM", "Active"));
	}
	
}
