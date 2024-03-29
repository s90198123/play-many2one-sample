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

  public static void createPet(long playerId, Pet pet) {
    Pet it = pet.getByName().saveIfNew();
    Player player = Player.findById(playerId);
    player.pet = it;
    player.save();
    newGroup(player.id);
  }

  public static void newGroup(long playerId) {
    Player player = Player.findById(playerId);
    render(player);
  }

  public static void createGroup(long playerId, Group group) {
    Group it = group.getByName().saveIfNew();
    Player player = Player.findById(playerId);
    player.group = it;
    player.save();
    finish(playerId);
  }

  public static void finish(long playerId) {
    Player player = Player.findById(playerId);
    render(player);
  }
}
