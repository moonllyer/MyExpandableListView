package yl.listview.expandable;

import yl.listview.expandable.adapter.ExpandableAdapter;
import yl.listview.expandable.myExpandableListview.MyExpandableListview;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends Activity 
implements MyExpandableListview.OnChildClickListener, 
MyExpandableListview.OnGroupClickListener {
	
	String[] str_group_items = {"第一组", "第二组", "第三组", "第四组", "第五组"};
	String[][] str_child_items = {{"这是第一条", "这是第二条"}, {"这是第一条", "这是第二条", "这是第三条"}, {"这是第一条"}, {"这是第一条", "这是第二条"}, {"这是第一条", "这是第二条", "这是第三条", "这是第四条"}};
	private MyExpandableListview m_exListview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();
	}
	
	private void initView(){
		initExpandableListview();
	}
	
	private void initExpandableListview(){
		/* 隐藏默认箭头显示 */
		
		m_exListview = (MyExpandableListview) findViewById(R.id.id_expandablelist);
		
		/* 监听child，group点击事件 */
		m_exListview.setOnChildClickListener(this);
		m_exListview.setOnGroupClickListener(this);
		
		
		ExpandableAdapter adapter = new ExpandableAdapter(this, 
				str_group_items,
				str_child_items);
		m_exListview.setAdapter(adapter);
		
	}

	@Override
	public boolean onGroupClick(ExpandableListView parent, View v,
			int groupPosition, long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		// TODO Auto-generated method stub
		Toast.makeText(MainActivity.this, "hi，你竟然点击了第" + (groupPosition + 1) + "组的第" + (childPosition + 1) + "条！", 2000).show();
		return false;
	}

}
