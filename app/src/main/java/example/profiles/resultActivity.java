package example.profiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class resultActivity extends AppCompatActivity {

    TextView txtresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtresult=(TextView)findViewById(R.id.txtresult); // intent 객체 받아옴
        Intent intent = getIntent();
        String result = intent.getStringExtra("result"); // 스트링변수
        txtresult.setText(result);
    }
}
