package sithira.me.eventmanager.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import sithira.me.eventmanager.R;
import sithira.me.eventmanager.activities.adapters.EventAdapter;
import sithira.me.eventmanager.database.AppDatabase;
import sithira.me.eventmanager.models.Event;

public class AllEvents extends AppCompatActivity
{
	
	private List<Event> events;
	
	private EventAdapter eventAdapter;
	
	private ListView listView;
	
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		listView = findViewById(R.id.eventList);
		
		button = findViewById(R.id.addNewEvent);
		
		events = AppDatabase.getAppDatabase(this).eventDAO().index();
		
		eventAdapter = new EventAdapter(this, events);
		
		listView.setAdapter(eventAdapter);
		
		listView.deferNotifyDataSetChanged();
		
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				startActivity(new Intent(AllEvents.this, CreateEvent.class));
			}
		});
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
			{
				Event event = (Event) adapterView.getAdapter().getItem(i);
				
				Intent intent = new Intent(AllEvents.this, EditEvent.class);
				
				intent.putExtra("event", event);
				
				startActivity(intent);
			}
		});
		
		
	}
}
