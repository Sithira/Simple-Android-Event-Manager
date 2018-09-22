package sithira.me.eventmanager.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import sithira.me.eventmanager.interfaces.EventDAO;
import sithira.me.eventmanager.interfaces.UserDAO;
import sithira.me.eventmanager.models.Event;
import sithira.me.eventmanager.models.User;

@Database(entities = {User.class, Event.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase
{
	private static AppDatabase INSTANCE;
	
	public abstract UserDAO userDao();
	
	public abstract EventDAO eventDAO();
	
	public static AppDatabase getAppDatabase(Context context)
	{
		if (INSTANCE == null)
		{
			INSTANCE =
					Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "event-database")
							// allow queries on the main thread.
							// Don't do this on a real app! See PersistenceBasicSample for an example.
							.allowMainThreadQueries()
							.build();
		}
		return INSTANCE;
	}
	
	public static void destroyInstance()
	{
		INSTANCE = null;
	}
}
