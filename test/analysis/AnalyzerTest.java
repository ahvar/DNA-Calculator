/**
 * 
 */
package analysis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for Analyzer.java
 * @author Arthur Vargas
 */
class AnalyzerTest {
	private String test1 = "test-files/test-string1";
	private String test2 = "test-files/test-string2";
	private String test3 = "test-files/test-string3";
	private String string1 = "AbuJklVcBg";
	private String string2 = "AaBbCdTtGgEeYy";
	private String string3 = "ccbwiaaaaatt";
	private String string4 = "heggggaaacc";

	/**
	 * Test method for Analyzer constructor.
	 */
	@Test
	public void testAnalyzer() {
		Analyzer a1 = new Analyzer(test1); //longer string
		Analyzer a2 = new Analyzer(test2); //short string
		Analyzer a3 = new Analyzer(test3); //string with whitespace
		assertEquals(a1.getStr().toString().length(),33);
		assertEquals(a2.getStr().toString().length(),8);
		assertEquals(a3.getStr().toString().length(),11);
		
	}
	
	/**
	 * Test method for readCharString()
	 */
	@Test
	public void testReadCharString() {
		Analyzer a1 = new Analyzer();
		a1.readCharString(string1);
		assertEquals(a1.getStr().toString().length(),10);
	}
	
	/**
	 * Test method for countDNA()
	 */
	@Test
	public void testCountDNA() {
		Analyzer a1 = new Analyzer();
		Analyzer a2 = new Analyzer();
		a1.readCharString(string1);
		a2.readCharString(string2);
		a1.countDNA();
		a2.countDNA();
		assertEquals(a1.getAdenine(),1);
		assertEquals(a1.getCytosine(),1);
		assertEquals(a1.getGuanine(),1);
		assertEquals(a1.getThymine(),0);
		assertEquals(a1.getOther(),7);
		assertEquals(a2.getAdenine(),2);
		assertEquals(a2.getCytosine(),1);
		assertEquals(a2.getGuanine(),2);
		assertEquals(a2.getThymine(),2);
		assertEquals(a2.getOther(),7);
	}
	
	/**
	 * Tests the countConsecutive() method
	 */
	@Test
	public void testCountConsecutive() {
		Analyzer a1 = new Analyzer();
		Analyzer a2 = new Analyzer();
		a1.readCharString(string3);
		a2.readCharString(string4);
		a1.countDNA();
		a2.countDNA();
		assertEquals(a1.countConsecutive('a'),5);
		assertEquals(a1.countConsecutive('t'),2);
		assertEquals(a2.countConsecutive('g'),4);
		assertEquals(a2.countConsecutive('a'),3);
		assertEquals(a2.countConsecutive('c'),2);	
	}
	


}
