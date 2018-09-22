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

public class LoginActivity extends AppCompatActivity
{
	
	private EditText username, password;
	
	private Button login;
	
	private TextView textView;
	
	private List<User> users;
	
	private AppDatabase appDatabase;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	
		initVariables();
		
		users = AppDatabase.getAppDatabase(this).userDao().index();
		
		login.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{

				for (User user : users)
				{
					if (user.username.equals(username.getText().toString())
							&& user.password.equals(password.getText().toString()))
					{

						EventManager.loggedInUser = user;

						Intent intent = new Intent(LoginActivity.this, AllEvents.class);

						startActivity(intent);

						finish();
						
						return;

					}
				}
				
				Toast.makeText(LoginActivity.this, "Credentials not found",
						Toast.LENGTH_LONG).show();
				
			}
		});
		
		textView.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
				
				startActivity(intent);
			}
		});
		
	}
	
	private void initVariables()
	{
		username = findViewById(R.id.username);
		
		password = findViewById(R.id.password);
		
		login = findViewById(R.id.loginBtn);
		
		textView = findViewById(R.id.regAct);
	}
	
	
	
}
