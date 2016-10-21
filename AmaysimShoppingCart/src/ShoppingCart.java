import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author cpviola
 * @param <T>
 *
 */
public class ShoppingCart {
	
	private List<Item> cartItems;
	private Map<String, PricingRule> pricingRules;
	private double total;
	
	public ShoppingCart() {
		
	}
	
	public ShoppingCart(Map<String, PricingRule> activePricingRules) {
		// TODO Auto-generated constructor stub
	}

	public void newCart(Map<String, PricingRule> pricingRules) {
		this.cartItems = new ArrayList<Item>();
		this.setPricingRules(pricingRules);
	}
	
	public void addItem(Item item){
		this.cartItems.add(item);
	}
	
	public void addItem(Item item, String promoCode){
		this.cartItems.add(item);
		
		Map.Entry<String, PricingRule> ruleCode = verifyPromoCode(promoCode);
		
		if (ruleCode != null){
			Map<String, PricingRule> currentRules = getPricingRules();
			currentRules.put(ruleCode.getKey(), ruleCode.getValue());
			this.setPricingRules(currentRules);
		}
	}
	
	public Map.Entry<String, PricingRule> verifyPromoCode(String promoCode){
		Map.Entry<String, PricingRule> correspondingRuleCode = null;
		Map<String, PricingRule> currentRules = new PricingRules().getAllActivePricingRulesList();
		
		for(Map.Entry<String, PricingRule> rule : currentRules.entrySet()) {
			if (rule.getValue().getRulePromoCode().equals(promoCode)){
				correspondingRuleCode = rule;
				break;
			}
		}
		
		return correspondingRuleCode;
	}
	
	public double computeTotal(){
		double dicounts = verifyDiscount();
		double deduction = verifyDeduction();
		double total = 0.0;
		final DecimalFormat df = new DecimalFormat("####0.00");
		
		Map<String, Item> activeItems = new ItemsList().getItemsList();
		List<Item> currentItems = getCartItems();
		
		for(Item i : new ArrayList<Item>(currentItems)){
			total += activeItems.get(i.getItemCode()).getItemPrice();
		}
		
		total = total - deduction;
		total = total - (total * (dicounts/100));
		
		System.out.println("You will only pay $" + df.format(total) + " for the following items:");
		
		verifyCartItems();
		
		return total;
	}
	
	public void verifyCartItems() {
		Map<String, Item> activeItems = new ItemsList().getItemsList();
		
		List<Item> currentItems = getCartItems();
		Map<String, PricingRule> currentRules = getPricingRules();
		
		//additional item if R003 rule is applied
		if (currentRules.containsKey("R003")){
			for(Item i : new ArrayList<Item>(currentItems)){
				if(i.getItemCode().equals("utc_medium")) {
					this.addItem(activeItems.get("1gb"));
				}
			}
		}
	}
	
	public double verifyDeduction() {
		Map<String, Item> activeItems = new ItemsList().getItemsList();
		
		List<Item> currentItems = getCartItems();
		Map<String, PricingRule> currentRules = getPricingRules();
		
		double deduction = 0.0;
		
		//if R001 rule is applied
		int utcSmallCounter = 0;
		if (currentRules.containsKey("R001")){
			for(Item i : new ArrayList<Item>(currentItems)){
				if(i.getItemCode().equals("utc_small")) {
					utcSmallCounter++;
				}
				if(utcSmallCounter == 3) {
					utcSmallCounter = 0;
					deduction += activeItems.get("utc_small").getItemPrice();
				}
			}
		}
		
		//if R002 rule is applied
		int utcLargeCounter = 0;
		if (currentRules.containsKey("R002")){
			for(Item i : new ArrayList<Item>(currentItems)){
				if(i.getItemCode().equals("utc_large")) {
					utcLargeCounter++;
				}
			}
			if(utcLargeCounter >= 3) {
				deduction += (activeItems.get("utc_large").getItemPrice() * utcLargeCounter) - (39.90 * utcLargeCounter);
			}
		}
		
		return deduction;
	}
	
	public double verifyDiscount() {
		double discountPercent = 0.0;
		
		Map<String, PricingRule> currentRules = getPricingRules();
		//if R004 rule is applied
		if (currentRules.containsKey("R004")){
			discountPercent = 10.0;
		}
		
		return discountPercent;
	}
	
	public List<Item> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Item> cartItems) {
		this.cartItems = cartItems;
	}
	
	public Map<String, PricingRule> getPricingRules() {
		return pricingRules;
	}

	public void setPricingRules(Map<String, PricingRule> pricingRules) {
		this.pricingRules = pricingRules;
	}
}
