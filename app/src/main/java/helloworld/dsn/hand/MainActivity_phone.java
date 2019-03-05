package helloworld.dsn.hand;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_phone extends Activity {
    private TextView ID_number;
    private TextView error_message;
    private EditText phone_number;
    private Button load;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        phone_number=(EditText) findViewById(R.id.editText);
        setContentView( R.layout.activity_main_phone );
        ID_number=(TextView)findViewById( R.id.phone );
        ID_number.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MainActivity_phone.this,MainActivity_student.class );
                startActivity( intent );
            }
        } );
        error_message=(TextView)findViewById( R.id.textView3 );

        error_message.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity_phone.this,"question call at 123456",Toast.LENGTH_SHORT ).show();
            }
        } );
        load=(Button)findViewById( R.id.textView4 );
        load.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MainActivity_phone.this,MainActivity_person.class);
                startActivity( intent );
            }
        } );
    }
}
