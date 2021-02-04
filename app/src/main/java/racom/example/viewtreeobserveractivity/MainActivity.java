package racom.example.viewtreeobserveractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnPreDrawListener, ViewTreeObserver.OnGlobalFocusChangeListener, ViewTreeObserver.OnTouchModeChangeListener, ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnWindowAttachListener, ViewTreeObserver.OnWindowFocusChangeListener, ViewTreeObserver.OnDrawListener {
    EditText et1, et2;
    TextView tvShow;
    Button btn;
    LinearLayout layout;
    int mHeaderViewHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Log.i("Demo", et1.getHeight() + "");
        ViewTreeObserver observer = layout.getViewTreeObserver();
        //当全局布局状态或视图树中视图的可见性更改时回调，可以在这里获取view的宽高
        observer.addOnGlobalLayoutListener(this);
        //当视图即将绘制时回调，在 OnDraw 之前
        observer.addOnPreDrawListener(this);
        //当视图树即将绘制时，在 OnPreDraw 之后
        observer.addOnDrawListener(this);
        //当视图树中的焦点状态更改时回调
        observer.addOnGlobalFocusChangeListener(this);
        //当视图层次结构的窗口焦点状态发生变化时回调
        observer.addOnWindowFocusChangeListener(this);
        //当触摸模式改变时回调
        observer.addOnTouchModeChangeListener(this);
        //当视图树中的某些内容被滚动时回调
        findViewById(R.id.nsView).getViewTreeObserver().addOnScrollChangedListener(this);
        //当视图层次结构 关联 或 分离 窗口 时回调
        observer.addOnWindowAttachListener(this);
    }

    private void initView() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tvShow = findViewById(R.id.tvShow);
        layout = findViewById(R.id.layout);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.isShown()) {
                    et1.setVisibility(View.GONE);
                } else {
                    et1.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onGlobalLayout() {
        mHeaderViewHeight = et1.getWidth();
        Log.i("Demo1", mHeaderViewHeight + "");
        layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override
    public boolean onPreDraw() {
        //在 onDraw 之前
        //返回 true 继续绘制，返回false取消。
        //也就是
        // true：绘制 LinearLayout 布局，false ：不绘制
        return true;
    }

    @Override
    public void onDraw() {
        //在 onPreDraw 之后，可以拦截绘制任务，重新发起绘制流程
    }

    @Override
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        //如果改变了焦点，就会给 oldFocus 和 newFocus 赋值。
        if (oldFocus != null) {
            tvShow.setText("Focus change from " + oldFocus.getTag() + "to" + newFocus.getTag());
        } else {
            //如果没有改变焦点， oldFocus 就没有值
            tvShow.setText(newFocus.getTag() + "get focus");
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        if (hasCapture) {
            Log.i("BUHUO", "捕获");
        } else {
            Log.i("BUHUO", "不捕获");

        }

    }

    @Override
    public void onTouchModeChanged(boolean isInTouchMode) {

    }

    @Override
    public void onScrollChanged() {
        //控件滑动得时候会调用
        Log.i("Demo", "滑动");
    }

    @Override
    public void onWindowAttached() {
        //onWindowAttached() 在 Activity 生命周期 onResume 方法之后，但是在 View 绘制流程之前
    }

    @Override
    public void onWindowDetached() {
        //onWindowDetached() 在 Activity 生命周期 onDestory 方法之后，此时 View 已经从窗口中移除
    }


}