public class PersonCheckerIsPensioner implements PersonChecker {
    public boolean test(Person person) {
        if (person.retrieveAge() >= 65) {
            return true;
        }
        return false;
    }
}
