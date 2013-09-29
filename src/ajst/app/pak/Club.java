package ajst.app.pak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Club extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club);
        
        ImageView Calender;

		Calender = (ImageView) findViewById(R.id.widget45);


		Calender.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent list_clubs = new Intent(getApplicationContext(),
						CalendarView.class);
				startActivity(list_clubs);
			}
		});
}
}