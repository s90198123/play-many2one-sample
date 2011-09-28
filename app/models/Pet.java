package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
@Table(name="pets")
public class Pet extends Model {
    public String name;

    private Pet(String name) {
      this.name = name;
    }

    public static Pet findOrCreate(String name){
      Pet pet = Pet.find("name", name).first();
      if(pet == null){
        pet = new Pet(name);
      }
      return pet;
    }
}
