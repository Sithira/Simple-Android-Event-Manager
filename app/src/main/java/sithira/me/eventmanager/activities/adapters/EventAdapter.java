package sithira.me.eventmanager.activities.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import sithira.me.eventmanager.R;
import sithira.me.eventmanager.models.Event;

public class EventAdapter extends BaseAdapter implements View.OnClickListener
{
	
	private final List<Event> list;
	
	private Activity activity;
	
	private LayoutInflater inflater;
	
	public EventAdapter(Activity activity, List<Event> list)
	{
		this.activity = activity;
		
		this.list = list;
	}
	
	@Override
	public void onClick(View view)
	{
	
	}
	
	@Override
	public int getCount()
	{
		return list.size();
	}
	
	@Override
	public Object getItem(int i)
	{
		return list.get(i);
	}
	
	@Override
	public long getItemId(int i)
	{
		return 0;
	}
	
	@Override
	public View getView(int i, View view, ViewGroup viewGroup)
	{
		View v = view;
		
		if (inflater == null)
		{
			inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
		
		if (v == null)
		{
			v = inflater.inflate(R.layout.event_item, null);
		}
		
		Event event = list.get(i);
		
		TextView title = v.findViewById(R.id.title);
		
		TextView date = v.findViewById(R.id.date);
		
		TextView description = v.findViewById(R.id.description);
		
		title.setText(event.title);
		date.setText(event.date);
		description.setText(event.description);
		
		return v;
	}
}
