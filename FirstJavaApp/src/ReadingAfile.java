import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReadingAfile {

	public static void main(String[] args) {

		String fileName = "ExampleFileWithData.txt";
		 try {

			// Create object of FileReader
			FileReader inputFile = new FileReader(fileName);					// czytam plik

			// Instantiate the BufferedReader Class
			BufferedReader bufferReader = new BufferedReader(inputFile);		//czytam linie

			// Variable to hold the one line data
			String line;
			int counting = 0;					
			List<Person> users = new ArrayList<Person>();		//lista trzymająca obiekty klasy Person
			// Read file line by line and print on the console
			while ((line = bufferReader.readLine()) != null) {		// czytaj dopóki masz czytać

				String[] fields = line.split(",");
				Person p = null;
				if (fields.length == 4) {
					p = new Person(fields[0], fields[1], fields[2], fields[3]);	//utwórz obiekt klasy Person (i przypisz go do zmiennej p) 
																						//przekazując jako parametry konstruktora kolejne fieldy
				} else {
					p = new Person(fields[0], fields[1], fields[2], "");	//jak nie 4 to mobile zastąp ciągiem pustych znaków
				}
				users.add(p);	//dodaję do listy users nowy obiekt który znajduje się w zmiennej p
				counting++;  	//dodaję ++ do licznika linii
			}
// przeczytałam wszystkie linie i mam wypełnioną listę users
			Person oldestUser = users.get(0);		//przypisuję do zmiennej oldestUser pierwszego użytkownika z listy

			for (int i = 1; i < users.size(); i++) {
				Person currentUser = users.get(i);
				if (currentUser.getUserBirthday().before(oldestUser.getUserBirthday())) {
					// System.out.println("Kolejna starsza osoba znaleziona");
					oldestUser = currentUser;
				}
			}
			Calendar c1 = Calendar.getInstance();		//bo tak --> getInstance jest zawsze bieżącą datą
			Calendar c2 = Calendar.getInstance();
			c2.setTime(oldestUser.getUserBirthday());		//tu przesuwam mu czas na datę urodzenia najstarszego użytkowanika
			int age = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR); // wiek wyliczam jako różnicę roków tych dwóch kalendarzy

			System.out.println("Liczba użytkowników: " + counting); // albo users.size() zamiast counting
			System.out.println(
					oldestUser.getUserName() + " " + oldestUser.getUserLastName() + " is the oldest user and has " + age
							+ " years and" + checkingMobile(oldestUser.getUserMobile()));
			// System.out.println(users);
			bufferReader.close();		//zamkniecie wczesniej otwartego pliku
		} catch (Exception e) {
			System.out.println("Error while reading file line by line:" + e.getMessage());
			e.printStackTrace();			//wypisuje szczegolowy komunikat błedu
		}
	}

	public static String checkingMobile(String userMobile) {		//metoda statyczna klasy ReadingAfile
		if (userMobile.trim().isEmpty()) {							//trim obcina spacje --> jeżeli po obcięciu spacji string isEmpty to wyświetla has no mobile
			return " has no mobile.";
		} else {
			return " has the following number: " + userMobile;
		}
	}
}