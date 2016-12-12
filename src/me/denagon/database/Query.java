package me.denagon.database;

import java.util.List;
import java.util.UUID;

public class Query {
	
	Db db = new Db();
	
	public List<Column> getRecord(UUID uuid){
		db.UUID.setValue(uuid.toString());
		return db.getTable().getExact(db.UUID);
	}
	
	public boolean isInTable(UUID uuid) {
		if (getRecord(uuid) != null)	return true;
		else return false;
	}
	
	public String getName(UUID uuid) {
		List<Column> result = getRecord(uuid);
		if (result != null) {
			return (String) result.get(1).getValue();
		} else {
			return "";
		}
	}
	
	public int getTimestamp(UUID uuid) {
		List<Column> result = getRecord(uuid);
		if (result != null) {
			return (int) result.get(2).getValue();
		} else {
			return -1;
		}
	}
}
