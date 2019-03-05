package helloworld.dsn.hand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_person extends Activity {
    private TextView textView;
    private TextView textView2;
    private TextView textView6;
    private TextView textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_person );
        textView=(TextView)findViewById( R.id.textView );
        /*******个人信息*******/
        textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MainActivity_person.this,
                        MainActivity_information.class);
                startActivity( intent );
            }
        } );
        /**********退出**********/
        textView6=(TextView)findViewById( R.id.textView6 );
        textView6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
        /********帮助与反馈*********/
        textView2=(TextView)findViewById( R.id.textView2 );
        textView2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity_person.this,"call at 123456",
                        Toast.LENGTH_SHORT).show();
            }
        } );
        /********设置********/
        textView7=(TextView)findViewById( R.id.textView7);
        textView7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MainActivity_person.this,MainActivity_shezhi.class );
                startActivity( intent );
            }
        } );
        }
}
