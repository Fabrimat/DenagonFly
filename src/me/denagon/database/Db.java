package me.denagon.database;

import java.util.Arrays;

import me.denagon.fly.Main;

public class Db {
	public Column UUID;
	public Column playerName;
	public Column hasFlyUntil;
	public Table FlyTimes = getTable();
	public Database database = getDatabase();
	
	public Table getTable(){
		UUID = new Column("UUID", DataType.STRING, 0);
		playerName = new Column("Name", DataType.STRING, 0);
		hasFlyUntil = new Column("UntilTimestamp", DataType.INTEGER, 0);
		return FlyTimes = new Table("FlyTimes",  Arrays.asList(UUID, playerName, hasFlyUntil));
	}
	
	public Database getDatabase() {
		Main pl = new Main();
		return database = new Database(pl, "PlayerFly", getTable());
	}
}
