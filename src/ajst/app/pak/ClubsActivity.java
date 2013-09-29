package ajst.app.pak;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ClubsActivity extends ListActivity {
	ArrayList<String> tab = new ArrayList<String>();

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clubs);

		int i = 0;

		// TextView selection;

		XmlPullParser club = getResources().getXml(R.xml.listeclubs);
		try {
			while (club.getEventType() != XmlPullParser.END_DOCUMENT) {
				if (club.getEventType() == XmlPullParser.START_TAG) {
					if (club.getName().equals("club")) {

						tab.add(club.getAttributeValue(0));
						// int position=tab.size();
						i++;
					}

				}
				club.next();
			}
		} catch (XmlPullParserException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, tab);
		setListAdapter(adapter);

	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		Intent Club = new Intent(getApplicationContext(), ClubActivity.class);
		Club.putExtra("nomClub", tab.get(position));
		startActivity(Club);
	}

}