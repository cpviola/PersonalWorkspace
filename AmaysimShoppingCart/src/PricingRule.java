/**
 * 
 */

/**
 * @author cpviola
 *
 */
public class PricingRule {

	/**
	 * 
	 */
	
	private String ruleDescription;
	private String rulePromoCode;
	private String ruleStatus;
	
	public PricingRule() {
		
		// TODO Auto-generated constructor stub
	}
	
	public PricingRule(String ruleDescription, String rulePromoCode, String ruleStatus) {
		// TODO Auto-generated constructor stub
		this.ruleDescription = ruleDescription;
		this.rulePromoCode = rulePromoCode;
		this.ruleStatus = ruleStatus;
	}

	public String getRuleDescription() {
		return ruleDescription;
	}

	public void setRuleDescription(String ruleDescription) {
		this.ruleDescription = ruleDescription;
	}

	public String getRulePromoCode() {
		return rulePromoCode;
	}

	public void setRulePromoCode(String rulePromoCode) {
		this.rulePromoCode = rulePromoCode;
	}

	public String getRuleStatus() {
		return ruleStatus;
	}

	public void setRuleStatus(String ruleStatus) {
		this.ruleStatus = ruleStatus;
	}
	

}
