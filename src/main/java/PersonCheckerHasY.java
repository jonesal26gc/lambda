public class PersonCheckerHasY implements PersonChecker {
    public boolean test(Person person){
        if (person.getName().toUpperCase().contains("Y")) {
            return true;
        }
        return false;
    }
}
