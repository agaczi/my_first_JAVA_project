import static org.junit.Assert.*;		//import statyczny importuje metody statyczne z podanej klasy
import java.text.ParseException;
import org.junit.Test;

public class PersonTests {

	@Test
	public void testValidDate() throws ParseException {
		Person p = new Person("Jan", "Kowalski", "1900-01-09", "900900900");
	}

	@Test(expected = ParseException.class)
	public void testInvalidDate() throws ParseException {
		Person p = new Person("Jan", "Kowalski", "ffhhhf", "900900900");
	}

	@Test
	public void testCheckingEmptyMobile() {
		String result = ReadingAfile.checkingMobile("");
		assertEquals(" has no mobile.", result);
	}

	@Test
	public void testCheckingMobileWithSpaces() {
		String result = ReadingAfile.checkingMobile("      ");
		assertEquals(" has no mobile.", result);
	}

	@Test
	public void testCheckingMobile() {
		String result = ReadingAfile.checkingMobile("123123123");
		assertEquals(" has the following number: 123123123", result);
	}

}
