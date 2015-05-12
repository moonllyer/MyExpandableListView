package yl.listview.expandable.myExpandableListview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

public class MyExpandableListview extends ExpandableListView{
	
	public MyExpandableListview(Context context) {
		super(context);
		initParam();
	}	
    
	public MyExpandableListview(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initParam();
	}
	
	private void initParam(){
		/* ����Ĭ�ϼ�ͷ��ʾ */
		this.setGroupIndicator(null);
		/* ���ش�ֱ������ */
		this.setVerticalScrollBarEnabled(false);
		
		setCacheColorHint(Color.TRANSPARENT);
		setDividerHeight(0);
		setChildrenDrawnWithCacheEnabled(false);
		setGroupIndicator(null);
		
		/*����ѡ��Ļ�ɫ����*/
		ColorDrawable drawable_tranparent_ = new ColorDrawable(Color.TRANSPARENT);
		setSelector(drawable_tranparent_);
	}
}
