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
		/* 隐藏默认箭头显示 */
		this.setGroupIndicator(null);
		/* 隐藏垂直滚动条 */
		this.setVerticalScrollBarEnabled(false);
		
		setCacheColorHint(Color.TRANSPARENT);
		setDividerHeight(0);
		setChildrenDrawnWithCacheEnabled(false);
		setGroupIndicator(null);
		
		/*隐藏选择的黄色高亮*/
		ColorDrawable drawable_tranparent_ = new ColorDrawable(Color.TRANSPARENT);
		setSelector(drawable_tranparent_);
	}
}
