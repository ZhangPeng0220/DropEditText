package com.zhangpeng.administrator.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;  // 输入框
    private ImageView mDropImage; // 右边的图片按钮
    private PopupWindow mPopup; // 点击图片弹出popupwindow
    private WrapListView mPopView; // popupwindow的布局
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        mPopView = (WrapListView) LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_view, null);
        setAdapter(new BaseAdapter() {
            private List<String> mList = new ArrayList<String>() {
                {
                    add("起床");
                    add("下午茶");
                    add("伤感");
                    add("兴奋");
                    add("劲爆");
                    add("轻缓");
                    add("孩童时代");
                }
            };

            @Override
            public int getCount() {
                return mList.size();
            }

            @Override
            public Object getItem(int position) {
                return mList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = new TextView(MainActivity.this);
                tv.setText(mList.get(position));
                return tv;
            }
        });
    }
    public void setAdapter(BaseAdapter adapter) {
        mPopup = new PopupWindow(mPopView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopup.setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
        mPopup.setFocusable(true); // 让popwin获取焦点
        mPopView.setAdapter(adapter);

    }
    public void mushow(View view){
        if(mPopup.isShowing()) {
            mPopup.dismiss();
            return;
        }

        mPopup.showAsDropDown(view, -225,5);
    }
    public void ligshow(View view){
        if(mPopup.isShowing()) {
            mPopup.dismiss();
            return;
        }

        mPopup.showAsDropDown(view, -225,5);
    }

}
