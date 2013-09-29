package ajst.app.pak;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
 
public class Email extends Activity {
        Button send;
        EditText address, subject, emailtext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail);
        
        Bundle adressMail = getIntent().getExtras();
        send=(Button) findViewById(R.id.emailsendbutton);
        address=(EditText) findViewById(R.id.emailaddress);
        subject=(EditText) findViewById(R.id.emailsubject);
        emailtext=(EditText) findViewById(R.id.emailtext);
       
        address.setText(adressMail.getString("mail"));
        send.setOnClickListener(new OnClickListener() {
                       
                        @Override
                        public void onClick(View v) {
                                // TODO Auto-generated method stub
                                 
                                      final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                               
                                      emailIntent.setType("plain/text");
                                 
                                      emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ address.getText().toString()});
                               
                                      emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject.getText());
                               
                                      emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, emailtext.getText());
                       
                                    Email.this.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
 
                        }
                });
    }
}
