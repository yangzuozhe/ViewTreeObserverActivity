package racom.example.viewtreeobserveractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnPreDrawListener, ViewTreeObserver.OnGlobalFocusChangeListener, ViewTreeObserver.OnTouchModeChangeListener {
    EditText et1, et2;
    TextView tvShow;
    Button btn;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ViewTreeObserver observer = layout.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(this);
        observer.addOnPreDrawListener(this);
        observer.addOnGlobalFocusChangeListener(this);
        observer.addOnTouchModeChangeListener(this);
    }
    private void initView(){
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tvShow = findViewById(R.id.tvShow);
        btn = findViewById(R.id.btn);
        layout = findViewById(R.id.layout);
    }

    @Override
    public void onGlobalLayout() {

    }

    @Override
    public boolean onPreDraw() {
        return false;
    }

    @Override
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {

    }

    @Override
    public void onTouchModeChanged(boolean isInTouchMode) {

    }
}