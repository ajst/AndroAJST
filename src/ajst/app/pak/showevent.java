package ajst.app.pak;

import ajst.app.pak.R;
import ajst.app.pak.R.id;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class showevent extends Activity{
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.showevent);
	        Bundle d= getIntent().getExtras(); 
	        String name = d.getString("nom");
	        String  local= d.getString("lieu");
	        String descr = d.getString("descri");
	       
	        TextView nom = (TextView) findViewById(R.id.nom);
	        nom.setText("Nom : " +name + "\n\n");
	        
	        TextView lieu = (TextView) findViewById(id.lieu); 
	        lieu.setText("Lieu : " + local + "\n\n"); 
	        
	        TextView descri = (TextView) findViewById(id.desc);
	        descri.setText("Description : \n" + descr + "\n\n"); 
	        
	        
	        /*AlertDialog.Builder msg = new AlertDialog.Builder(this); 
	        msg.setMessage("Nom \n" + name );
	        msg.setTitle("Event ! ");
	        msg.show();*/
	    }

}
