package yl.listview.expandable.adapter;

import yl.listview.expandable.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableAdapter extends BaseExpandableListAdapter{

	LinearLayout mGroupLayout;

	private Context context_;
	private String[] str_group_items_;
	private String [][] str_child_items_;
	
	public final class ViewHolder{
		public TextView txtContext;
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++
	// child's stub
	
	public ExpandableAdapter(Context ctx, String[] group, String[][] child){
		context_ = ctx;
		str_group_items_ = group;
		str_child_items_ = child;
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return str_child_items_[groupPosition][childPosition];
	}
	
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}
	
	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return str_child_items_[groupPosition].length;
	}
	
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(null == convertView){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context_).inflate(R.layout.child_item, null);
			holder.txtContext = (TextView)convertView.findViewById(R.id.id_child_txt);
			convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder)convertView.getTag();
		}
		/*判断是否是最后一项，最后一项设计特殊的背景*/
		if(isLastChild){
			convertView.setBackgroundResource(R.drawable.child_end);
		} else {
			convertView.setBackgroundResource(R.drawable.child);
		}
		
		holder.txtContext.setText(str_child_items_[groupPosition][childPosition]);
	
		return convertView;
	}
			
	//++++++++++++++++++++++++++++++++++++++++++++
	// group's stub
	
	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return str_group_items_[groupPosition];
	}
	
	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return str_group_items_.length;
	}
	
	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,  View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView txt_group;
		if(null == convertView){
			convertView = LayoutInflater.from(context_).inflate(R.layout.group_item, null);  
		}
		/*判断是否group张开，来分别设置背景图*/
		if(isExpanded){
			convertView.setBackgroundResource(R.drawable.group_e);
		}else{
			convertView.setBackgroundResource(R.drawable.group);
		}
		
		txt_group = (TextView)convertView.findViewById(R.id.id_group_txt);
		txt_group.setText(str_group_items_[groupPosition]);
		return convertView;
	}
	
	    @Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}


}
