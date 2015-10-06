package org.mit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidFirstActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView t=new TextView(this);
        t.setText("All System information: " +
				"\n Operating system version: "+System.getProperty("os.version")+
				"\n Operating System name: "+System.getProperty("os.name")+
				"\n Architecture: "+System.getProperty("os.arch")+
				"\n Manufacturer: "+android.os.Build.MANUFACTURER+
				"\n Board: "+android.os.Build.BOARD+
				"\n Display: "+android.os.Build.DISPLAY+
				"\n CPU_API: "+android.os.Build.CPU_ABI+
				"\n Device: "+android.os.Build.DEVICE+
				"\n Host: "+android.os.Build.HOST+
				"\n Model: "+android.os.Build.MODEL+
				"\n Product: "+android.os.Build.PRODUCT+
				"\n Type: "+android.os.Build.TYPE+
				"\n Users: "+android.os.Build.USER
				); 

        setContentView(t);
    }
}