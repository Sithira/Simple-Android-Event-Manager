package sithira.me.eventmanager.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sithira.me.eventmanager.models.User;

@Dao
public interface UserDAO
{

	@Query("SELECT * FROM users")
	List<User> index();

	@Query("SELECT * FROM users WHERE id = :id")
	User show(int id);
	
	@Insert
	void store(User... users);
	
	@Update
	void update(User... users);
	
	@Delete
	void delete(User... users);
	
}
