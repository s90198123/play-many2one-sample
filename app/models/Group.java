package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
@Table(name="groups")
public class Group extends Model {
    public String name;
}
