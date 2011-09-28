
package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
@Table(name="players")
public class Player extends Model {
  @OneToOne
    public Pet pet;
  @ManyToOne
    public Group group;

  public void setPet(Pet pet) {
    if(pet != null){
      Player player = Player.find("pet = ? and id != ?", pet, id).first();
      if(player != null){
        player.pet = null;
        player.save();
      }
    }
    this.pet = pet;
  }

  public String name;
}
