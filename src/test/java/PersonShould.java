import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonShould {

    Person person1 = PersonBuilder.aPerson()
            .withName("Tony Jones")
            .withBirthday(new LocalDate(1962, 9, 22))
            .withGender(Gender.MALE)
            .withEmailAddress("tony.jones26gc@hotmail.co.uk")
            .build();

    Person person2 = PersonBuilder.aPerson()
            .withName("Ann Jones")
            .withBirthday(new LocalDate(1964, 7, 2))
            .withGender(Gender.FEMALE)
            .withEmailAddress("ann.jones26gc@hotmail.co.uk")
            .build();

    Person person3 = PersonBuilder.aPerson()
            .withName("Amy Jones")
            .withBirthday(new LocalDate(1997, 6, 2))
            .withGender(Gender.FEMALE)
            .withEmailAddress("amyeljones@outlook.com")
            .build();

    Person person4 = PersonBuilder.aPerson()
            .withName("Holly Jones")
            .withBirthday(new LocalDate(1997, 6, 2))
            .withGender(Gender.FEMALE)
            .withEmailAddress("h.jones101@hotmail.co.uk")
            .build();

    Person person5 = PersonBuilder.aPerson()
            .withName("Ross Jones")
            .withBirthday(new LocalDate(1997, 6, 2))
            .withGender(Gender.MALE)
            .withEmailAddress("tony.jones26gc@hotmail.co.uk")
            .build();

    Person person6 = PersonBuilder.aPerson()
            .withName("Barry Jones")
            .withBirthday(new LocalDate(1944, 7, 7))
            .withGender(Gender.MALE)
            .withEmailAddress("barry.jones135hh@hotmail.co.uk")
            .build();

    @Test
    public void
    variousTests() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);

        listPeople(personList);
        retrieveAgeOfThePerson(personList);
        listPeopleOlderThan(personList, 30);
        listPeopleBetween(personList, 10, 20);

        listPeopleUsingPersonCheckerAllPurpose(personList, new PersonCheckerAllPurpose(PersonCheckerAllPurposeCondition.MALE));
        listPeopleUsingPersonCheckerAllPurpose(personList, new PersonCheckerAllPurpose(PersonCheckerAllPurposeCondition.FEMALE));

        listPeopleUsingPersonChecker(personList, new PersonCheckerIsPensioner());
        listPeopleUsingPersonChecker(personList, new PersonCheckerHasY());

        listPeopleUsingPersonChecker(personList, new PersonChecker() {
            public boolean test(Person person) {
                if (person.getName().toUpperCase().contains("TONY")) {
                    return true;
                }
                return false;
            }
        });

    }

    public void
    listPeople(List<Person> personList) {
        System.out.println("everybody");
        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }

    public void
    retrieveAgeOfThePerson(List<Person> personList) {
        System.out.println("everyones age");
        for (Person person : personList) {
            System.out.println(person.getName() + " is " + person.retrieveAge() + "yrs");
        }
    }

    public void
    listPeopleOlderThan(List<Person> personList, int age) {
        System.out.println("older people");
        for (Person person : personList) {
            if (person.retrieveAge() >= age) {
                System.out.println("Person over " + age + "yrs : " + person.getName());
            }
        }
    }

    private void
    listPeopleBetween(List<Person> personList, int min, int max) {
        System.out.println("between");
        for (Person person : personList) {
            if (person.retrieveAge() >= min & person.retrieveAge() <= max) {
                System.out.println(String.format("between %d and %d : ",
                                                 min,
                                                 max) + person.getName() + " at " + person.retrieveAge());
            }
        }
    }

    private void
    listPeopleUsingPersonCheckerAllPurpose(List<Person> personList, PersonCheckerAllPurpose personCheckerAllPurpose) {
        System.out.println("using all purpose checker");
        for (Person person : personList) {
            if (personCheckerAllPurpose.performTest(person)) {
                System.out.println(person.getName());
            }
        }
    }

    private void listPeopleUsingPersonChecker(List<Person> personList, PersonChecker personChecker) {
        System.out.println("with parameterised condition");
        for (Person person : personList) {
            if (personChecker.test(person)) {
                System.out.println(person.toString());
            }
        }
    }
}
