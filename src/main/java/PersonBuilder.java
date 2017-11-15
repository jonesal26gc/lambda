import org.joda.time.LocalDate;

import java.util.Date;

public final class PersonBuilder {
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String emailAddress;

    private PersonBuilder() {
    }

    public static PersonBuilder aPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public PersonBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public PersonBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public Person build() {
        return new Person(name, birthday, gender, emailAddress);
    }
}
