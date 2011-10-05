package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
@Table(name="groups")
public class Group extends Model {
  public String name;

  private Group(String name) {
    this.name = name;
  }

  public Player player() {
    return Player.find("group", this).first();
  }

  public Group getByName(){
    Group it = findOrCreate(name);
    if(it == null){
      return this;
    }
    return it;
  }

  public static Group findOrCreate(String name){
    Group it = Group.find("name", name).first();
    if(it == null){
      it = new Group(name);
    }
    return it;
  }

  public Group saveIfNew() {
    if(!this.isPersistent()){
      return this.save();
    } else {
      return this;
    }
  }

}
