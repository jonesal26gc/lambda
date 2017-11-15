public class PersonCheckerAllPurpose {
    private PersonCheckerAllPurposeCondition test;

    public PersonCheckerAllPurpose(PersonCheckerAllPurposeCondition test) {
        this.test = test;
    }

    public boolean performTest(Person person) {
        switch (test) {
            case MALE:
                return isMale(person);
            case FEMALE:
                return isFemale(person);
        }
        return false;
    }

    public boolean isMale(Person person) {
        if (person.getGender() == Gender.MALE) {
            return true;
        }
        return false;
    }


    public boolean isFemale(Person person) {
        if (person.getGender() == Gender.FEMALE) {
            return true;
        }
        return false;
    }
}
