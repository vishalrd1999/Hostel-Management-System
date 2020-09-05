import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testAllocRoom {

	@Test
	public void testAllocation()
	{
		AllocRoom alloc = new AllocRoom();
		String res = alloc.Allocation();
		assertEquals("success", res);
	}

}
