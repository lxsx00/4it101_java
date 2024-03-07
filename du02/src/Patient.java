import java.util.ArrayList;
import java.util.List;

public class Patient implements Record {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private List<String> medicalRecords;

    public Patient(String firstName, String lastName, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public void addMedicalRecord(String record) {
        this.medicalRecords.add(record);
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public List<String> getMedicalRecords() {
        return medicalRecords;
    }

    @Override
    public String toString() {
        return "Jméno: '" + firstName + "'" +
                ", Příjmení: '" + lastName + "'" +
                ", Věk: '" + age + "'" +
                ", Pohlaví: '" + gender + "'" +
                ", Lékařské záznamy: '" + medicalRecords +"'";
    }
}
