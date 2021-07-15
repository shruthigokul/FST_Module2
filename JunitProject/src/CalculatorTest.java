import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	private Calculator calculator;
	
	 	@BeforeEach
	    public void setUp() throws Exception {
	        calculator = new Calculator();
	    }
	 
	  /*  @Test
	    @Disabled("some")
	    @DisplayName("Simple multiplication should work")
	    public void testMultiply() {
	        assertEquals(20, calculator.multiply(4, 5));
	        
	        
	    }*/
	 	
	 	void iterablesEqual() {
	 	    final List<String> list = Arrays.asList("orange", "mango", "banana");
	 	    final List<String> expected = Arrays.asList("banana", "mango", "orange");
	 	    
	 	    // Add a new value
	 	    //list.add("apple");
	 	    // Sort array
	 	   // Collections.sort(list);
	 	    
	 	    // Assertion
	 	    assertIterableEquals(expected, list); //Fail
	 	}
	    
	    
	    
	    
	
	

}
