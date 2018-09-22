package sithira.me.eventmanager.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sithira.me.eventmanager.EventManager;
import sithira.me.eventmanager.activities.AllEvents;
import sithira.me.eventmanager.R;
import sithira.me.eventmanager.database.AppDatabase;
import sithira.me.eventmanager.models.User;

public class RegisterActivity extends AppCompatActivity
{
	
	private EditText username, password;
	
	private Button register;
	
	private TextView textView;
	
	private List<User> users;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		initVariables();
		
		users = AppDatabase.getAppDatabase(this).userDao().index();
		
		register.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				
				for (User user : users)
				{
					if (user.username.equals(username.getText().toString()))
					{

						Toast.makeText(RegisterActivity.this, "A User Exists",
								Toast.LENGTH_LONG).show();

						return;

					}
				}
				
				User user = new User(username.getText().toString(), password.getText().toString());
				
				AppDatabase.getAppDatabase(RegisterActivity.this).userDao().store(user);
				
				EventManager.loggedInUser = user;
				
				Intent intent = new Intent(RegisterActivity.this, AllEvents.class);
				
				startActivity(intent);
				
				finish();
				
				
			}
		});
		
		textView.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
				
				startActivity(intent);
			}
		});
	}
	
	private void initVariables()
	{
		username = findViewById(R.id.username);
		
		password = findViewById(R.id.password);
		
		register = findViewById(R.id.registerBtn);
		
		textView = findViewById(R.id.loginAct);
	}
}
