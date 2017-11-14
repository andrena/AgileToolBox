package mockito;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private PriceProvider provider;
	private PriceDisplay display;

	private List<String> items = new ArrayList<>();

	public Cart(PriceProvider provider) {
		this.provider = provider;
	}

	public void addItem(String itemName) {
		items.add(itemName);
	}

	public int getPrice() {
		int sum = 0;
		for (String item : items) {
			sum += (provider.getPrice(item));
		}
		return sum;
	}

	public void setDisplay(PriceDisplay display) {
		this.display = display;
	}

	public void updatePriceDisplay() {
		display.updatePriceDisplay(getPrice());
	}

}
