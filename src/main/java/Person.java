import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Person {
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String emailAddress;

    public Person(String name, LocalDate birthday, Gender gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", birthday=" + birthday +
               ", gender=" + gender +
               ", emailAddress='" + emailAddress + '\'' +
               '}';
    }

    public int retrieveAge() {
        LocalDate today = LocalDate.now();
        Years years = Years.yearsBetween(birthday, today);
        return years.getYears();
    }
}
