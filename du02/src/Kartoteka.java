import java.util.ArrayList;
import java.util.List;

public class Kartoteka {
    private List<Record> patients;

    public Kartoteka() {
        this.patients = new ArrayList<>();
    }

    public void registerPatient(Record patient) {
        this.patients.add(patient);
    }

    public int countPatients() {
        return this.patients.size();
    }

    public double averageAge() {
        if (this.patients.isEmpty()) {
            return 0;
        }

        int totalAge = 0;
        for (Record patient : this.patients) {
            totalAge += patient.getAge();
        }

        return (double) totalAge / this.patients.size();
    }

    public List<Record> searchByName(String firstName, String lastName) {
        List<Record> foundPatients = new ArrayList<>();
        for (Record patient : this.patients) {
            if (patient.getFirstName().equals(firstName) && patient.getLastName().equals(lastName)) {
                foundPatients.add(patient);
            }
        }
        return foundPatients;
    }
}
