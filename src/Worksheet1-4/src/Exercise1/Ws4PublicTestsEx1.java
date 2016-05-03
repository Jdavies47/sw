package Exercise1;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


/**
 * Public tests for Ex1.
 * 
 * @author Alexandros Evangelidis
 * @date 2015-11-09
 */

public class Ws4PublicTestsEx1 {

	private ExamQuestion eq1;
	private ExamQuestionNumeric eqn1;
	private ExamQuestionSimpleChoice eqsc1;

	
	
	@Before
	public void setUp() {

		eq1 = new ExamQuestion("2+3=?", 4);

		eqn1 = new ExamQuestionNumeric("2+3 = ?", 10, 5);
	}

	@Test
	public void test1() {

		String expected = "Question (Maximal mark: 4)\n" + "2+3=?" + "\n";
		assertEquals(expected, eq1.toString());
	}

	@Test
	public void test2() {

		eq1.setQuestion("1+1=?");
		eq1.setMaximalMark(100);
		String expected = "Question (Maximal mark: 100)\n" + "1+1=?" + "\n";
		assertEquals(expected, eq1.toString());
	}

	@Test
	public void test3() {

		int expected = 10;
		int result = eqn1.answer(5);

		assertEquals(expected, result);
	}

	@Test
	public void test4() {

		ArrayList<String> a = new ArrayList<String>();
		a.add("4");
		a.add("5");
		a.add("10");
		a.add("20");

		eqsc1 = new ExamQuestionSimpleChoice("2+3 = ?", 10, a, 2);

		int expected1 = 0;
		int expected2 = 10;

		int result1 = eqsc1.answer(1);
		int result2 = eqsc1.answer(2);

		assertEquals(expected1, result1);
		assertEquals(expected2, result2);

	}

	@Test
	public void test5() {

		ArrayList<String> a = new ArrayList<String>();
		a.add("4");
		a.add("5");
		a.add("10");
		a.add("20");

		eqsc1 = new ExamQuestionSimpleChoice("2+3 = ?", 10, a, 2);

		String expected = "Question (Maximal mark: 10)\n" + "" + "2+3 = ?\n"
				+ "" + "Possible answers are: 4\n" + "" + "5\n" + "10\n"
				+ "20\n" + "" + "Correct answer position is: 2\n";

		String result = eqsc1.toString();
		assertEquals(expected, result);

	}

	@Test
	public void test6() {

		eqn1 = new ExamQuestionNumeric("2+3 = ?", 10, 5);

		int expected = 10;
		int result = eqn1.answer(5);

		assertEquals(expected, result);

	}

	@Test
	public void test7() {

		String expected = "Question (Maximal mark: 10)\n" + "2+3 = ?\n"
				+ "Correct answer is: 5\n";
		String result = eqn1.toString();

		assertEquals(expected, result);
	}

}