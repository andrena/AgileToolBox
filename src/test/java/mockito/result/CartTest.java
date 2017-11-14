package mockito.result;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.mockito.Mockito;

import mockito.Cart;
import mockito.PriceDisplay;
import mockito.PriceProvider;

public class CartTest {

	@Test
	public void testGetPrice() throws Exception {
		PriceProvider provider = Mockito.mock(PriceProvider.class);
		Cart cart = new Cart(provider);
	
		assertThat(cart.getPrice(), equalTo(0));
	}

	@Test
	public void testGetPriceForOneItem() throws Exception {
		PriceProvider provider = Mockito.mock(PriceProvider.class);
		Mockito.when(provider.getPrice("Eau de Cologne")).thenReturn(4711);
		Cart cart = new Cart(provider);
		cart.addItem("Eau de Cologne");
		
		assertThat(cart.getPrice(), equalTo(4711));
	}
	
	@Test
	public void testGetPriceForTwoItems() throws Exception {
		PriceProvider provider = Mockito.mock(PriceProvider.class);
		Mockito.when(provider.getPrice("Eau de Cologne")).thenReturn(4711);
		Mockito.when(provider.getPrice("Hitchhiker's Guide")).thenReturn(42);
		Cart cart = new Cart(provider);
		cart.addItem("Eau de Cologne");
		cart.addItem("Hitchhiker's Guide");
		
		assertThat(cart.getPrice(), equalTo(4711 + 42));
	}

	@Test
	public void testUpdatePriceDisplay() throws Exception {
		PriceDisplay display = Mockito.mock(PriceDisplay.class);
		PriceProvider provider = Mockito.mock(PriceProvider.class);
		Mockito.when(provider.getPrice("Eau de Cologne")).thenReturn(4711);
		Mockito.when(provider.getPrice("Hitchhiker's Guide")).thenReturn(42);
		Cart cart = new Cart(provider);
		cart.setDisplay(display);
		cart.addItem("Eau de Cologne");
		cart.addItem("Hitchhiker's Guide");
		
		cart.updatePriceDisplay();
		
		Mockito.verify(display).updatePriceDisplay(4711 + 42);
	}
	
}
