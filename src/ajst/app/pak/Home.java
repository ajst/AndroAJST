package ajst.app.pak;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Home extends Activity {
	private LinearLayout layout;
	ImageButton Clubs;
	ImageButton Association;
	ImageButton Stages;
	ImageButton Camps;
	ImageButton Gale;

	ImageView Calender;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/*
		 * layout = new LinearLayout(this); BitmapDrawable img =
		 * (BitmapDrawable)
		 * this.getResources().getDrawable(R.drawable.background);
		 * layout.setBackgroundDrawable(img); setContentView(layout);
		 */
		Clubs = (ImageButton) findViewById(R.id.club_list);
		Gale = (ImageButton) findViewById(R.id.galy);
		Association = (ImageButton) findViewById(R.id.associa);
		Stages = (ImageButton) findViewById(R.id.stages);
		Camps = (ImageButton) findViewById(R.id.camp);

		Calender = (ImageView) findViewById(R.id.widget45);

Gale.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*AlertDialog.Builder alertMsg = new AlertDialog.Builder(getApplicationContext());
				alertMsg.setTitle("Informations ..");
				alertMsg.setMessage("Arja3 8odwa .." );
				alertMsg.show();*/
				Intent galler = new Intent(getApplicationContext(),
						DVPGallery.class);
				startActivity(galler);
			}
		});
		Calender.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent list_clubs = new Intent(getApplicationContext(),
						CalendarView.class);
				startActivity(list_clubs);
			}
		});
		Clubs.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent list_clubs = new Intent(getApplicationContext(),
						ClubsActivity.class);
				startActivity(list_clubs);
			}
		});

		Stages.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent list_clubs = new Intent(getApplicationContext(),
						Stages.class);
				startActivity(list_clubs);
			}
		});
		Camps.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent list_clubs = new Intent(getApplicationContext(),
						Camp.class);
				startActivity(list_clubs);
			}
		});

		Association.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent list_clubs = new Intent(getApplicationContext(),
						Association.class);
				startActivity(list_clubs);
			}
		});
	
		
	}

	public void setLayout(LinearLayout layout) {
		this.layout = layout;
	}

	public LinearLayout getLayout() {
		return layout;
	}

	/*
	 * public void onClick(View arg0) { // TODO Auto-generated method stub
	 * 
	 * }
	 */
}