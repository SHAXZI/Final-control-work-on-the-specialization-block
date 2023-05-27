package fabrics;

import enums.PetType;
import models.Pet;

import java.time.LocalDate;

public abstract class PetBuilder {
    protected abstract Pet createNewPet(PetType type);

    public Pet createPet(PetType type, String nickname, LocalDate date) {

        Pet pet = createNewPet(type);
        pet.setNickName(nickname);
        pet.setBirthday(date);
        return pet;
    }
}
