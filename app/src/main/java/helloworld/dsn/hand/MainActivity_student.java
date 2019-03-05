package helloworld.dsn.hand;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity_student extends Activity {

    /********显示菜单********/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.main,menu );
        return  true;
    }
    /***********菜单点击事件**********/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Toast.makeText( MainActivity_student.this, "add", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.remove_item:
                Toast.makeText( MainActivity_student.this,"remove",Toast.LENGTH_SHORT ).show();
                break;
            default:

        }
        return true;
    }
    private Button post_message;
    URL url = null;
    HttpsURLConnection connection;
    @SuppressLint({"ResourceType", "MissingSuperCall"})
    @Override
    protected void onCreate(Bundle savedInstanceState)   {
        post_message=(Button)findViewById( R.id.post );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student);/***
        post_message.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity_student.this,
                        "发短信了哦",Toast.LENGTH_SHORT ).show();
            }
        } );**/

        TextView ID_number=(TextView)findViewById( R.id.editText );
        TextView error_message=(TextView)findViewById( R.id.textView3 );
        TextView phone_number=(TextView) findViewById( R.id.phone );
        String str="sdger";
        try {
            url=new URL("http://47.106.159.165:8080/guest/phoneLogin");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            connection=(HttpsURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.setRequestMethod( "GET" );
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        /*****赋值******/
        //ID_number.setText( str );
        /******转到手机号登陆******/
        phone_number.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MainActivity_student.this,MainActivity_phone.class );
                startActivity( intent );
            }
        } );
        /********错误消息*******/
        error_message.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity_student.this, "如有问题请致电：123456", Toast.LENGTH_SHORT ).show();
            }
        } );
        //onClick( phone_number );//这是一开始就有了
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.phone:{
                ProgressDialog progressdialog=new ProgressDialog( MainActivity_student.this );
                progressdialog.setTitle( "这是进度条的弹出框" );
                progressdialog.setMessage( "加载中" );
                progressdialog.setCancelable( true );
                progressdialog.show();
                break;
            }
            default:
                break;
        }
}}
