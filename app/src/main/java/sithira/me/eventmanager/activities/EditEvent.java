package sithira.me.eventmanager.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import sithira.me.eventmanager.R;
import sithira.me.eventmanager.database.AppDatabase;
import sithira.me.eventmanager.models.Event;

public class EditEvent extends AppCompatActivity
{
	
	private Event event;
	
	private TextView title, date, description;
	
	private Button updateBtn, deleteBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_event);
		
		event = (Event) getIntent().getExtras().get("event");
		
		initVariables();
		
		loadData();
		
		initClickListners();
	}
	
	/**
	 * Initialize variable references
	 */
	public void initVariables()
	{
		title = findViewById(R.id.title);
		
		date = findViewById(R.id.date);
		
		description = findViewById(R.id.description);
		
		updateBtn = findViewById(R.id.updateBtn);
		
		deleteBtn = findViewById(R.id.deleteBtn);
	}
	
	public void loadData()
	{
		title.setText(event.title);
		
		date.setText(event.date);
		
		description.setText(event.description);
	}
	
	public void initClickListners()
	{
	
		updateBtn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
			
				event.title = title.getText().toString();
				
				event.date = date.getText().toString();
				
				event.description = description.getText().toString();
				
				AppDatabase.getAppDatabase(EditEvent.this).eventDAO().update(event);
				
				Toast.makeText(EditEvent.this, "Event updated Successfully", Toast.LENGTH_LONG).show();
			}
		});
		
		deleteBtn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				event.title = title.getText().toString();
				
				event.date = date.getText().toString();
				
				event.description = description.getText().toString();
				
				AppDatabase.getAppDatabase(EditEvent.this).eventDAO().delete(event);
				
				Toast.makeText(EditEvent.this, "Event removed Successfully", Toast.LENGTH_LONG).show();
				
				startActivity(new Intent(EditEvent.this, AllEvents.class));
				
				finish();
			}
		});
	
	}
}
