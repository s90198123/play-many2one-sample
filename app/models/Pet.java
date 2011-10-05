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

    public Player player(){
      return Player.find("pet", this).first();
    }

    public Pet getByName(){
      Pet pet = findOrCreate(name);
      if(pet == null){
        return this;
      }
      return pet;
    }

    public static Pet findOrCreate(String name){
      Pet pet = Pet.find("name", name).first();
      if(pet == null){
        pet = new Pet(name);
      }
      return pet;
    }

    public Pet saveIfNew() {
      if(!this.isPersistent()){
      return this.save();
      } else {
      return this;
      }
    }
}
