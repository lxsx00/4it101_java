import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kartoteka kartoteka = new Kartoteka();

        // Registruji 3 pacienty, dva z toho budou mít stejné jméno ale jiný věk (jedná se o jiné osoby)
        Record patient1 = new Patient("Pavel", "Novák", 47, "Male");
        patient1.addMedicalRecord("Zlomená pravá ruka.");
        patient1.addMedicalRecord("Levé koleno podstoupilo operaci ACL.");
        kartoteka.registerPatient(patient1);

        Record patient2 = new Patient("Anna Karolína", "Novotná", 50, "Female");
        patient2.addMedicalRecord("Prodělaná těžká angína.");
        kartoteka.registerPatient(patient2);

        // Pacient se stejným jménem a příjmením, které tu už je, akorát jiný věk, aby se jednalo o jinou osobu
        Record patient3 = new Patient("Pavel", "Novák", 24, "Male");
        patient3.addMedicalRecord("Nutné vyšetření očí.");
        patient3.addMedicalRecord("Antibiotika předepsána na 3 týdny.");
        patient3.addMedicalRecord("Oči jsou v pořádku, léčba byla úspěšná.");
        kartoteka.registerPatient(patient3);


        // Volání metod a vypisování výsledků
        System.out.println("Počet pacientů v databázi: " + kartoteka.countPatients());
        System.out.println("Průměrný věk všech aktuálních pacientů v kartotéce: " + kartoteka.averageAge());

        //výpis pacienta či pacientů na základě jména
        String searchFirstName = "Pavel";
        String searchLastName = "Novák";
        List<Record> foundPatients = kartoteka.searchByName(searchFirstName, searchLastName);

        System.out.println("Výsledky hledání pacienta se jménem " + searchFirstName + " " + searchLastName + ":");
        for (Record patient : foundPatients) {
            System.out.println(patient);
        }
    }
}
