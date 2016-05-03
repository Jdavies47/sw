import org.junit.Test;

import static org.junit.Assert.*;

/**Public tests for Ex5.
 * 
 * @author Alexandros Evangelidis
 * @Date 2015-10-26
 *
 */

public class Ws3Ex5PublicTests {

	private Graph g1,g2,g3,g4,g5,g6,g7;
	
	//first graph of worksheet
	@Test
	public void test1() {
		g1 = new Graph("g1.graph");
		assertFalse(g1.isFullyConnected());
	}

	//second graph of worksheet
	@Test
	public void test2() {
		g2 = new Graph("g2.graph");
		assertFalse(g2.isFullyConnected());
	}

	//third graph of worksheet
	@Test
	public void test3() {
		g3 = new Graph("g3.graph");
		assertFalse(g3.isFullyConnected());
	}

	//fourth graph of worksheet
	@Test
	public void test4() {
		g4 = new Graph("g4.graph");
		assertTrue(g4.isFullyConnected());
	}

	//a  graph with connection probability 0.9
	@Test
	public void test5() {
		g5 = new Graph("g100.graph");
		assertFalse(g5.isFullyConnected());
	}
	
	//a  graph with connection probability 0.2
	@Test
	public void test6() {
		g6 = new Graph("g1000.graph");
		assertFalse(g6.isFullyConnected());
	}

	//a graph with connection probability 1.0
	@Test
	public void test8() {
		g7 = new Graph("g1001.graph");
		assertTrue(g7.isFullyConnected());
	}

}



