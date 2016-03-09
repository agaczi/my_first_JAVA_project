import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

	private String userName;
	private String userLastName;
	private Date userBirthday;
	private String userMobile;

	// A constructor used to initialize an item
	public Person(String name, String lastName, String birthday, String mobile) throws ParseException {
		this.userName = name;
		this.userLastName = lastName;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		this.userBirthday = df.parse(birthday);		//konwersja stringa na date - może rzucić wyjątkiem ParseException
		this.userMobile = mobile;
	}
	
	public String getUserName() {		// publiczna metoda klasy Person która zwraca stringa i nie przyjmuje żadnych parametrów. jako rezultat zwraca wartość pola userName
		return userName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public String getUserMobile() {
		return userMobile;
	}

	@Override							
	public String toString() {					// służy do wypisania Persona jako stringa
		return "Person [userName=" + userName + ", userLastName=" + userLastName + ", userBirthday=" + userBirthday
				+ ", userMobile=" + userMobile + "]";
	}
}
