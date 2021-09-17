import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

class testLoginPAge{
	
	@Test
	void testlogin() {
		LoginPage lp = new LoginPage();
		assertEquals(true, lp.loginactivity("admin","password"));
	}
	
	@Test
	void testloginfail() {
		LoginPage lp1 = new LoginPage();
		assertNotEquals(true, lp1.loginactivity("", ""));
	}
	
	@Test
	void testregister() {
		RegisterPage1 reg = new RegisterPage1();
		assertEquals(true, reg.regactivity("Mayank More","mayank.32@gmail.com","MALE","TE","9027536563","27 Nov 2016"));
	}
	
	@Test
	void testregisterfail() {
		RegisterPage1 reg1 = new RegisterPage1();
		assertNotEquals(true, reg1.regactivity("","mayank.32@gmail.com","MALE","TE","9027536563","27 Nov 2016"));
	}
	
	@Test
	void testupdate() {
		UpdateDetails upd = new UpdateDetails();
		assertEquals(true, upd.updactivity("47", "mayankmore2@gmail.com", "FE", "7778889998"));
	}
	
	@Test
	void testalloc() {
		AllocRoom alloc = new AllocRoom();
		assertNotEquals(-1, alloc.allocactivity("7"));
	}
	
	@Test
	void testdealloc() {
		DeallocRoom dealloc = new DeallocRoom();
		assertEquals(102, dealloc.deallocactivity("12"));
	}
	
	@Test
	void testchange() {
		assertEquals(true, ChangeRoom.changeactivity("5","104"));
	}

}
