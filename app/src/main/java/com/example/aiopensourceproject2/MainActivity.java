package com.example.aiopensourceproject2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat,rdoRabbit;
    Button btnOk;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1=(TextView)findViewById(R.id.Text1);
        chkAgree=(CheckBox) findViewById(R.id.ChkAgree);

        text2=(TextView) findViewById(R.id.Text2);
        rGroup1=(RadioGroup)findViewById(R.id.Rgroup1);
        rdoDog=(RadioButton) findViewById(R.id.RdoDog);
        rdoCat=(RadioButton) findViewById(R.id.RdoCat);
        rdoRabbit=(RadioButton) findViewById(R.id.RdogRabbit);

        btnOk=(Button) findViewById(R.id.BtnOk);
        imgPet=(ImageView)findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked()==true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }else
                {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = rGroup1.getCheckedRadioButtonId();

                if(selectedRadioButtonId != -1) { // 라디오 버튼이 선택된 경우
                    if(selectedRadioButtonId == R.id.RdoDog) {
                        imgPet.setImageResource(R.drawable.dog);
                    } else if(selectedRadioButtonId == R.id.RdoCat) {
                        imgPet.setImageResource(R.drawable.cat);
                    } else if(selectedRadioButtonId == R.id.RdogRabbit) {
                        imgPet.setImageResource(R.drawable.rabbit);
                    }
                } else { // 라디오 버튼이 선택되지 않은 경우
                    Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}