import com.google.gson.annotations.SerializedName;

public class Person {
    @SerializedName("Фамилия")
    private String lastName;
    @SerializedName("Оценка")
    private int number;
    @SerializedName("Предмет")
    private String subject;

    public String getLastName() {
        return lastName;
    }

    public int getNumber() {
        return number;
    }

    public String getSubject() {
        return subject;
    }

    public Person(String lastName, int number, String subject) {
        this.lastName = lastName;
        this.number = number;

        this.subject = subject;
    }
}
