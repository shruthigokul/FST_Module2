import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.ExpandingCharAppender;

public class Activity1 {
	static ArrayList<String> list;
	
	String[] exp = new String[] {"shruthi","shriya","vaikunth"};
	
	@BeforeAll()
	static void setup()
	{
		list=new ArrayList<>();
		list.add("shruthi");
		list.add("shriya");
		
	}
	
	@Test()
	public void insertTest()
	{
		assertEquals(3,list.size(),"Wrong size");
		list.add("vaikunth");
		assertEquals(3,list.size(),"Wrong size");
		for(int i=0;i<=list.size();i++)
		{
			assertEquals(exp[i],list.get(i),"Wrong element");
		}
	}
	
	@Test()
	public void replaceTest()
	{
		assertEquals(2,list.size(),"Wrong size");
		list.add("vaikunth");
		assertEquals(3,list.size(),"Wrong size");
		list.set(1,"moma");
		for(int i=0;i<=list.size();i++)
		{
			assertEquals(exp[i],list.get(i),"Wrong element");
		}
		
	}
}
