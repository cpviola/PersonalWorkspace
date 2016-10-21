import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author cpviola
 *
 */
public class ItemsList {

	/**
	 * 
	 */
	final Map<String, Item> itemsList = new HashMap<String, Item>();
	
	public ItemsList() {
		itemsList.put("utc_small", new Item("utc_small", "Unlimited 1 GB", 24.90));
		itemsList.put("utc_medium", new Item("utc_medium","Unlimited 2 GB", 29.90));
		itemsList.put("utc_large", new Item("utc_large","Unlimited 5 GB", 44.90));
		itemsList.put("1gb", new Item("1gb","1 GB Datapack", 9.90));
	}

	public Map<String, Item> getItemsList() {
		return itemsList;
	}

}
