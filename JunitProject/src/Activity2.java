import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.security.auth.login.AccountException;

import org.junit.jupiter.api.Test;

public class Activity2 {
	
	@Test
	public void NotEnoughFunds() {
		BankAccount bankAccount=new BankAccount(9);
		assertThrows(NotEnoughFundsException.class,()->bankAccount.withdraw(10));
	}
	
	@Test
	public void EnoughFunds() {
		BankAccount bankAccount=new BankAccount(0);
		assertDoesNotThrow(()->bankAccount.withdraw(100));
	}

}
