package se.gyran.aio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainScreen extends Activity {
	private IonCanon canon;
	
	private Button btnStart;
	private Button btnStop;
	private EditText edtHost;
	private CheckBox cbAwake;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Canon
        this.canon = new IonCanon(10);
        
        /** Capture elements **/
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        edtHost = (EditText) findViewById(R.id.edtHost);
        cbAwake = (CheckBox) findViewById(R.id.cbAwake);
        /*********************/
        
        btnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					canon.setTarget(edtHost.getText().toString());
					canon.fire();
				} catch (Exception e) {
				}
			}
		});
    }
}