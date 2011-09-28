package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

  @Before
  static void setDefault() {
    List<Player> players = Player.findAll();
    renderArgs.put("players", players);
  }

  public static void index() {
    render();
  }

  public static void all() {
    List<Player> players = Player.findAll();
    renderJSON(players);
  }

  public static void create(Player player) {
    player.save();
    newPet(player.id);
  }

  public static void newPet(long playerId) {
    Player player = Player.findById(playerId);
    render(player);
  }

  public static void createPet(long playerId, String petName) {
    Pet pet = Pet.findOrCreate(petName);
    if(!pet.isPersistent()){
      pet.save();
    }
    Player player = Player.findById(playerId);
    player.pet = pet;
    player.save();
    newGroup(player.id);
  }

  public static void newGroup(long playerId) {
    Player player = Player.findById(playerId);
    render(player);
  }

  public static void createGroup(long playerId, Group group) {
    group.save();
    Player player = Player.findById(playerId);
    player.group = group;
    player.save();
    finish(playerId);
  }

  public static void finish(long playerId) {
    Player player = Player.findById(playerId);
    render(player);
  }
}
