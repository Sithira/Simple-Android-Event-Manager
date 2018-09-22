package sithira.me.eventmanager.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sithira.me.eventmanager.models.Event;

@Dao
public interface EventDAO
{
	
	@Query("SELECT * FROM events")
	List<Event> index();

	@Query("SELECT * FROM events WHERE id = :id")
	Event show(int id);
	
	@Insert
	void store(Event... events);
	
	@Update
	void update(Event... events);
	
	@Delete
	void delete(Event... events);
	
}
