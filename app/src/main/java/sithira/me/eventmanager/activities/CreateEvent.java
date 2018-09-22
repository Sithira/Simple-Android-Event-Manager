package sithira.me.eventmanager.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sithira.me.eventmanager.R;
import sithira.me.eventmanager.database.AppDatabase;
import sithira.me.eventmanager.models.Event;

public class CreateEvent extends AppCompatActivity
{
	
	private EditText title, date, description;
	
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_event);
		
		title = findViewById(R.id.title);
		
		date = findViewById(R.id.date);
		
		description = findViewById(R.id.description);
		
		button = findViewById(R.id.addEvent);
		
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				
				Event event = new Event(title.getText().toString(), date.getText().toString(), description.getText().toString());
				
				AppDatabase.getAppDatabase(CreateEvent.this).eventDAO().store(event);
				
				Toast.makeText(CreateEvent.this, "Event Added !", Toast.LENGTH_LONG).show();
			}
		});
	}
}
