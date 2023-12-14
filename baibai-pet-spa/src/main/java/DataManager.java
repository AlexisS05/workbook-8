import java.sql.Date;
import java.util.ArrayList;

public interface DataManager {
    Date getPetBirthday(int petId);
    void setPetBirthday(int petId, Date birthday );
    String getPetFullName(int petId);

    ArrayList<Pet> getAllPets();
}
