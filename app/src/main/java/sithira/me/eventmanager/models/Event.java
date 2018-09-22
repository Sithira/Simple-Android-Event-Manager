package sithira.me.eventmanager.models;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

@Entity(tableName = "events")
public class Event implements Serializable
{
	
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	public int id;
	
	@ColumnInfo(name = "title")
	public String title;
	
	@ColumnInfo(name = "date")
	public String date;
	
	@ColumnInfo(name = "description")
	public String description;
	
	public Event(String title, String date, String description)
	{
		this.title = title;
		this.date = date;
		this.description = description;
	}
	
}
