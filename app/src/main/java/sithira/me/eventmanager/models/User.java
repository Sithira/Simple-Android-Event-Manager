package sithira.me.eventmanager.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "users")
public class User implements Serializable
{
	
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	public int id;

	@ColumnInfo(name = "username")
	public String username;
	
	@ColumnInfo(name = "password")
	public String password;
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
}
