import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author cpviola
 *
 */
public class AmaysimShoppingMain {

	/**
	 * 
	 */
	public AmaysimShoppingMain() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param <T>
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, PricingRule> activePricingRules = new PricingRules().getActivePricingRulesList();
		Map<String, Item> activeItems = new ItemsList().getItemsList();
		
		customerAShopping(activePricingRules, activeItems);
		customerBShopping(activePricingRules, activeItems);
		customerCShopping(activePricingRules, activeItems);
		customerDShopping(activePricingRules, activeItems);
	}
	
	public static void customerAShopping(Map<String, PricingRule> activePricingRules, Map<String, Item> activeItems) {
		ShoppingCart customerShoppingCart = new ShoppingCart();
		customerShoppingCart.newCart(activePricingRules);
		
		customerShoppingCart.addItem(activeItems.get("utc_small"));
		customerShoppingCart.addItem(activeItems.get("utc_small"));
		customerShoppingCart.addItem(activeItems.get("utc_small"));
		customerShoppingCart.addItem(activeItems.get("utc_large"));
		
		customerShoppingCart.computeTotal();
		
		List<Item> currentItems = customerShoppingCart.getCartItems();
		
		for(Item i : new ArrayList<Item>(currentItems)){
			System.out.println("- " + i.getItemName());
		}
		
	}
	
	public static void customerBShopping(Map<String, PricingRule> activePricingRules, Map<String, Item> activeItems) {
		ShoppingCart customerShoppingCart = new ShoppingCart();
		customerShoppingCart.newCart(activePricingRules);
		
		customerShoppingCart.addItem(activeItems.get("utc_small"));
		customerShoppingCart.addItem(activeItems.get("utc_small"));
		customerShoppingCart.addItem(activeItems.get("utc_large"));
		customerShoppingCart.addItem(activeItems.get("utc_large"));
		customerShoppingCart.addItem(activeItems.get("utc_large"));
		customerShoppingCart.addItem(activeItems.get("utc_large"));
		
		customerShoppingCart.computeTotal();
		
		List<Item> currentItems = customerShoppingCart.getCartItems();
		
		for(Item i : new ArrayList<Item>(currentItems)){
			System.out.println("- " + i.getItemName());
		}
		
	}
	
	public static void customerCShopping(Map<String, PricingRule> activePricingRules, Map<String, Item> activeItems) {
		ShoppingCart customerShoppingCart = new ShoppingCart();
		customerShoppingCart.newCart(activePricingRules);
		
		customerShoppingCart.addItem(activeItems.get("utc_small"));
		customerShoppingCart.addItem(activeItems.get("utc_medium"));
		customerShoppingCart.addItem(activeItems.get("utc_medium"));
		
		customerShoppingCart.computeTotal();
		
		List<Item> currentItems = customerShoppingCart.getCartItems();
		
		for(Item i : new ArrayList<Item>(currentItems)){
			System.out.println("- " + i.getItemName());
		}
		
	}
	
	public static void customerDShopping(Map<String, PricingRule> activePricingRules, Map<String, Item> activeItems) {
		ShoppingCart customerShoppingCart = new ShoppingCart();
		customerShoppingCart.newCart(activePricingRules);
		
		customerShoppingCart.addItem(activeItems.get("utc_small"));
		customerShoppingCart.addItem(activeItems.get("1gb") , "I<3AMAYSIM");
		
		customerShoppingCart.computeTotal();
		
		List<Item> currentItems = customerShoppingCart.getCartItems();
		
		for(Item i : new ArrayList<Item>(currentItems)){
			System.out.println("- " + i.getItemName());
		}
		
	}

}
