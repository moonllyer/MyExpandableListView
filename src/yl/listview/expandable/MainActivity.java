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
	
	String[] str_group_items = {"��һ��", "�ڶ���", "������", "������", "������"};
	String[][] str_child_items = {{"���ǵ�һ��", "���ǵڶ���"}, {"���ǵ�һ��", "���ǵڶ���", "���ǵ�����"}, {"���ǵ�һ��"}, {"���ǵ�һ��", "���ǵڶ���"}, {"���ǵ�һ��", "���ǵڶ���", "���ǵ�����", "���ǵ�����"}};
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
		/* ����Ĭ�ϼ�ͷ��ʾ */
		
		m_exListview = (MyExpandableListview) findViewById(R.id.id_expandablelist);
		
		/* ����child��group����¼� */
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
		Toast.makeText(MainActivity.this, "hi���㾹Ȼ����˵�" + (groupPosition + 1) + "��ĵ�" + (childPosition + 1) + "����", 2000).show();
		return false;
	}

}
