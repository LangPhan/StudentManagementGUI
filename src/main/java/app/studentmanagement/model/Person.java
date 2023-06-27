package app.studentmanagement.model;

public class Person {
    private long id;
    private String fullName;
    private String birthDay;

    private String homeTown;

    public Person(long id, String fullName, String birthDay, String homeTown) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.homeTown = homeTown;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Person{" +
               "id=" + id +
               ", fullName='" + fullName + '\'' +
               ", birthDay='" + birthDay + '\'' +
               ", homeTown='" + homeTown + '\'' +
               '}';
    }
}
