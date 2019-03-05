package helloworld.dsn.hand;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Main_activity_talking extends AppCompatActivity {

    private List<Msg> msgList=new ArrayList<>(  );
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_talking );
        initMsgs();
        inputText =(EditText)findViewById( R.id.input_text );
        send=(Button)findViewById( R.id.send );
        msgRecyclerView=(RecyclerView)findViewById( R.id.msg_recyler_view );
        LinearLayoutManager layoutManager= new LinearLayoutManager( this );
        msgRecyclerView.setLayoutManager( layoutManager );
        adapter=new MsgAdapter( msgList );
        msgRecyclerView.setAdapter( adapter );
        send.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=inputText.getText().toString();
                if(!"".equals( content )){
                    Msg msg=new Msg( content,Msg.TYPE_SENT );
                    msgList.add( msg );
                    adapter.notifyItemInserted( msgList.size()-1 );
                    msgRecyclerView.scrollToPosition( msgList.size()-1 );
                    inputText.setText( "" );
                }
            }
        } );
    }

    private void initMsgs(){
        Msg msg1=new Msg("Hello guy",Msg.TYPE_RECEIVED);
        msgList.add( msg1 );
        Msg msg2=new Msg( "Hello,who is that",Msg.TYPE_SENT );
        msgList.add( msg2 );
        Msg msg3=new Msg( "This is Tom",Msg.TYPE_RECEIVED );
        msgList.add( msg3 );
    }
    public class Msg {
        public static final int TYPE_RECEIVED=0;
        public static final int TYPE_SENT=1;
        private String content;
        private int type;
        public Msg(String content,int type){
            this.content=content;
            this.type=type;
        }
        public String getContent(){
            return content;
        }
        public int getType(){
            return type;
        }
    }
}
