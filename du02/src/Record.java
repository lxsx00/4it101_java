import java.util.List;

public interface Record {
    void addMedicalRecord(String record);
    String getFirstName();
    String getLastName();
    int getAge();
    String getGender();
    List<String> getMedicalRecords();
    String toString();
}
