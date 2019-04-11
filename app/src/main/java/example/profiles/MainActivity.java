package example.profiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // 위젯 멤버 변수 선언;
    CheckBox checkBox;
    TextView tvSchool, tvGrade, tvName, tvResult, tvtell;
    EditText edtSchool, edtName, edttell;
    RadioGroup radioGroup;
    Button btnPrint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("개인 명함");
// 위젯 멤버 변수 초기화
        checkBox = (CheckBox) findViewById(R.id.cbInput);
        tvtell = (TextView) findViewById(R.id.tvtell);
        tvSchool = (TextView) findViewById(R.id.tvSchool);
        tvGrade = (TextView) findViewById(R.id.tvGrade);
        tvName = (TextView) findViewById(R.id.tvName);
        tvResult = (TextView) findViewById(R.id.tvResult);
        edttell = (EditText) findViewById(R.id.edtell);
        edtSchool = (EditText) findViewById(R.id.edtSchool);
        edtName = (EditText) findViewById(R.id.edName);
        radioGroup = (RadioGroup) findViewById(R.id.rdGroup);
        btnPrint = (Button) findViewById(R.id.btnPrint);
// 첫 번째 체크박스 체크 시 visible 속성 값을 수정하는 이벤트 처리 소스 추가
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox.isChecked()==true) {
                    tvSchool.setVisibility(View.VISIBLE);
                    tvtell.setVisibility(View.VISIBLE);
                    edttell.setVisibility(View.VISIBLE);
                    tvGrade.setVisibility(View.VISIBLE);
                    tvName.setVisibility(View.VISIBLE);
                    tvResult.setVisibility(View.VISIBLE);
                    edtSchool.setVisibility(View.VISIBLE);
                    edtName.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    btnPrint.setVisibility(View.VISIBLE);
                } else {
                    tvtell.setVisibility(View.INVISIBLE);
                    edttell.setVisibility(View.INVISIBLE);
                    tvSchool.setVisibility(View.INVISIBLE);
                    tvGrade.setVisibility(View.INVISIBLE);
                    tvName.setVisibility(View.INVISIBLE);
                    tvResult.setVisibility(View.INVISIBLE);
                    edtSchool.setVisibility(View.INVISIBLE);
                    edtName.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    btnPrint.setVisibility(View.INVISIBLE);
                }
            }
        });


// 결과 출력 버튼 이벤트 처리
        btnPrint.setOnClickListener(new View.OnClickListener() {
            String schoolName, studentName, tellnumber;
            @Override
            public void onClick(View v) {
// 입력된 학교 이름 문자열 얻기
                schoolName = edtSchool.getText() .toString();
// 입력된 학생 이름 문자열 얻기
                studentName = edtName.getText() .toString();
// 입력된 전화번호 문자열 얻기
                tellnumber = edttell.getText() .toString();
// null 체크 하기
                if(schoolName.isEmpty())
                    Toast.makeText(getApplicationContext(),"기업이름을 입력하세요",Toast.LENGTH_LONG).show();
                else if(studentName.isEmpty())
                    Toast.makeText(getApplicationContext(),"이름을 입력하세요", Toast.LENGTH_LONG).show();
                else {
                    switch (radioGroup.getCheckedRadioButtonId()){
                        case R.id.radioButton:
                            tvResult.setText(schoolName + " " + "사원 " + studentName + " " + "tell " +tellnumber);
                            break;
                        case R.id.radioButton2:
                            tvResult.setText(schoolName + " " + "주임 " + studentName + " " +"tell " + tellnumber);
                            break;
                        case R.id.radioButton3:
                            tvResult.setText(schoolName + " " + "대리 " + studentName + " " + "tell " +tellnumber );
                            break;
                        case R.id.radioButton4:
                            tvResult.setText(schoolName + " " + "과장 " + studentName + " " + "tell " + tellnumber);
                            break;
                        default:
                            Toast.makeText(getApplicationContext(),"직위를 선택하세요",Toast.LENGTH_LONG).show();
                    }
                }
                //화면전환
                Intent intent = new Intent(MainActivity.this, resultActivity.class);
                intent.putExtra("result",tvResult.getText().toString());
                startActivity(intent);


            }
        });
    }


}

