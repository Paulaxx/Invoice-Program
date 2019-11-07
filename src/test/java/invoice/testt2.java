package invoice;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class testt2 {

	@Test
	public void test() {
		Product product = new Product(200, "testName");
		double expected = 246.0;
		double actual = product.pricePlusVat(200);
		
		
		assertEquals(expected, actual, 0);
	}

}
