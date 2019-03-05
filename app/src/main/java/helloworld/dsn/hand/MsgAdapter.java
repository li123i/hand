package helloworld.dsn.hand;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    @NonNull
    private List<Main_activity_talking.Msg> mMsgList;

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from( parent.getContext() ).inflate( R.layout.msg_item,parent,false );
        return new ViewHolder( view );
    }

    public MsgAdapter(List<Main_activity_talking.Msg> msgList){
        mMsgList=msgList;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Main_activity_talking.Msg msg=mMsgList.get( position );
        if(msg.getType()== Main_activity_talking.Msg.TYPE_RECEIVED){
            holder.leftLayout.setVisibility( View.VISIBLE );
            holder.rightLayout.setVisibility( View.GONE );
            holder.leftMsg.setText( msg.getContent() );
        }else if(msg.getType()==Main_activity_talking.Msg.TYPE_SENT){
            holder.rightLayout.setVisibility( View.VISIBLE);
            holder.leftMsg.setVisibility( View.GONE );
            holder.rightMsg.setText( msg.getContent() );
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        public ViewHolder(@NonNull View view) {
            super( view );
            leftLayout=(LinearLayout)view.findViewById( R.id.left_layout );
            rightLayout=(LinearLayout)view.findViewById( R.id.right_layout );
            leftMsg=(TextView)view.findViewById( R.id.left_msg );
            rightMsg=(TextView)view.findViewById( R.id.right_msg );
        }
    }
}
