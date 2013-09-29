package ajst.app.pak;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ClubActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		String nomClub = "", descriptionClub = "", comiteClub = "", contactClub = "" ;
		String mailClub = "";
		String longitude="", altitude="";

		super.onCreate(savedInstanceState);
		setContentView(R.layout.club);

		Bundle clubb = getIntent().getExtras();
		String nomClubXML = clubb.getString("nomClub");
		
		XmlPullParser club = null;
		if (nomClubXML.equals("Club de Tunis")) {
			club = getResources().getXml(R.xml.tunis);
		} else if (nomClubXML.equals("Club Central")) {
			club = getResources().getXml(R.xml.central);
		} else if (nomClubXML.equals("Club de Nabeul")) {
			club = getResources().getXml(R.xml.nabeul);
		}
		
		try {
			while (club.getEventType() != XmlPullParser.END_DOCUMENT) {
				if (club.getEventType() == XmlPullParser.START_TAG) {
					if (club.getName().equals("club")) {
						nomClub = club.getAttributeValue(0);
						descriptionClub = club.getAttributeValue(1);
						contactClub += " L'adresse du Club : "
								+ club.getAttributeValue(2) + " \n";
						mailClub = club.getAttributeValue(6);
						longitude = club.getAttributeValue(4);
						altitude = club.getAttributeValue(5);
					}
					if (club.getName().equals("comite")) {
						comiteClub += " Le directeur du Club : "
								+ club.getAttributeValue(0) + " \n";
						comiteClub += " Le tr�sorier du Club : "
								+ club.getAttributeValue(1) + " \n";
					}
				}
				club.next();
			}
			// Set les textes
			TextView nom = (TextView) findViewById(R.id.nom);
			nom.setText(nomClub);

			TextView description = (TextView) findViewById(R.id.description);
			description.setText(descriptionClub);

			TextView contact = (TextView) findViewById(R.id.textContact);
			contact.setText(contactClub);

			TextView comite = (TextView) findViewById(R.id.textComite);
			comite.setText(comiteClub);
			
			// Cr�er un �couteur sur les boutons MAP et MAIL
			ImageButton map = ( ImageButton ) findViewById(R.id.map);
			ImageButton mail = ( ImageButton ) findViewById(R.id.mail);
			final String mailAdress = mailClub ;
			mail.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent mailAc = new Intent(getApplicationContext(), Email.class);
					mailAc.putExtra("mail", mailAdress);
					startActivity(mailAc);
					
				}
			});
			
			final String longitudeClub = longitude ;
			final String altitudeClub = altitude ;
			map.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent mapAc = new Intent(getApplicationContext(), GMapsActivity.class);
					//mapAc.putExtra("longitude", longitudeClub);
					//mapAc.putExtra("altitude", altitudeClub);
					startActivity(mapAc);
					//Toast.makeText(getApplicationContext(), "Cette fonctionalit� n'est pas encore disponible", Toast.LENGTH_LONG).show();
				}
			});

		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * private InputStream getInputStream(URL url) { // TODO Auto-generated
	 * method stub try{ return url.openConnection().getInputStream(); } catch
	 * (IOException e){
	 * 
	 * } return null; }
	 */
}