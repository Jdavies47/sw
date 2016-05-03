package Exercise1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Ws4Ex1PrivateTests {

	private ExamQuestion eq1;
	private ExamQuestionNumeric eqn1;
	private ExamQuestionSimpleChoice eqsc1;
	ArrayList<String> a;
	ArrayList<String> b;
	double precision = 0.0000001;

	@Before
	public void setUp() {
		eq1 = new ExamQuestion("15/5 = ?", 10);
		eqn1 = new ExamQuestionNumeric("8*3 = ?", 10, 24);
		eqsc1 = new ExamQuestionSimpleChoice("5^2 = ?", 10, a, 3);
	}

	@Test
	public void test1() {
		// GETTERS AND SETTERS
		eq1.setQuestion("4+4 = ?");
		eq1.setMaximalMark(100);
		
		String expectedQuestion = "4+4 = ?";
		int expectedMaximalMark = 100;
		
		String actualQuestion = eq1.getQuestion();
		int actualMaximalMark = eq1.getMaximalMark();
		
		assertEquals(expectedQuestion, actualQuestion);
		assertEquals(expectedMaximalMark, actualMaximalMark);
	}

	@Test
	public void test2() {
		// TESTING ANSWER METHOD
		ArrayList<String> a = new ArrayList<>();
		a.add("123");
		a.add("143");
		a.add("25");
		a.add("pineapple");

		assertEquals(10,eqsc1.answer(3));
	}

	@Test
	public void test3() {
		// TESTING ANSWER METHOD
		assertEquals(10,eqn1.answer(24));
	}

	@Test
	public void test4() {
		// TESTING ARRAYLIST FUNCTIONS
		ArrayList<String> a = new ArrayList<>();
		a.add("the wrong answer");
		a.add("another wrong answer");
		a.add("the right answer");
		a.add("yet another wrong answer");
		
		a.remove(3);
		a.remove(2);
		a.remove(1);
		
		assertEquals(10, eqsc1.answer(3), precision);
	}

	@Test
	public void test5() {
		// TESTING ANSWER METHOD '0th' vs '1st' VALUE
		ExamQuestionSimpleChoice eqsc2 = new ExamQuestionSimpleChoice("10*2 = ?", 10, b, 0);
		
		ArrayList<String> b = new ArrayList<>();
		b.add("20");
		b.add("the wrong answer");
		b.add("the other wrong answer");
		b.add("and another wrong answer");
		
		assertEquals(0, eqsc2.answer(1));
	}
}
