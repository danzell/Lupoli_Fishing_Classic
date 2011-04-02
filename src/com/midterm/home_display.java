package com.midterm;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class home_display extends ListActivity implements OnItemSelectedListener {
    /** Called when the activity is first created. */
	private ArrayList<FishingTeam> teamList;
	private FishingTeamsAdapter m_adapter;
	private Runnable viewOrders;
	private ProgressDialog m_ProgressDialog;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, 
        																	 R.array.category_array, 
        																	 android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(new MyOnItemsSelectedListener());
        
        teamList = new ArrayList<FishingTeam>();
        m_adapter = new FishingTeamsAdapter(this, R.layout.custom_list_row, teamList);
        setListAdapter(m_adapter);
        
        Thread thread = new Thread(null, viewOrders, "MajentoBackground");
        thread.start();
        m_ProgressDialog = ProgressDialog.show(home_display.this, "Please wait..", "Retrieving data ..", true);
    }

    /*
     * 
     * (non-Javadoc)
     * @see android.widget.AdapterView.OnItemSelectedListener#onItemSelected(android.widget.AdapterView, android.view.View, int, long)
     */
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		
		Toast.makeText(parent.getContext(), "Here is the order for the category " + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private class FishingTeamsAdapter extends ArrayAdapter<FishingTeam>{
		private ArrayList<FishingTeam> teamList;
		
		public FishingTeamsAdapter(Context context, int textViewResourceId, ArrayList<FishingTeam> items){
    		super(context, textViewResourceId, items);
    		this.teamList = items;
    	}
		
    	@Override
    	public View getView(int position, View convertView, ViewGroup parent){
    		View v = convertView;
    		
    		if(v != null){
    			Log.d("OrderAdapter#getview()", "No need to do anything...");
    			return v;
    		}
    		
    		Log.d("OrderAdapter#getview()", "Inflate teh layout and propterly set the view's controls");
    		
    		LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		v = vi.inflate(R.layout.custom_list_row, null);
    		

    		FishingTeam fishingTeam = teamList.get(position);
    		if(fishingTeam != null){
    			TextView tt = (TextView) v.findViewById(R.id.toptext);
    			TextView bt = (TextView) v.findViewById(R.id.bottomtext);
    			if (tt != null) {
    				tt.setText("Name: "+fishingTeam.getName());                            
    			}
    			if(bt != null){
    				//bt.setText("Status: "+ fishingTeam.getOrderStatus());
    			}
    		}
    		return v;
    	}		

	}
}