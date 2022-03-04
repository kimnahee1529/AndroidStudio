package com.good.project11_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
//    Button btnsend;
    Button btnReceive;
    TextView ReceiveText;
//    EditText WriteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnsend = (Button) findViewById(R.id.btnsend);
        btnReceive = (Button) findViewById(R.id.btnsReceive);
        ReceiveText = (TextView) findViewById(R.id.ReceiveText);
//        WriteText = (EditText)findViewById(R.id.WriteText);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef  = database.getReference("글쓰기");

//        // Editext 클릭시 빈칸으로 바뀜
//        WriteText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                WriteText.setText(null);
//            }
//        });
//
//        btnsend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //파이어베이스에 글을 씀
//                myRef.setValue(WriteText.getText().toString());
//                //Toast로 메시지를 띄워 전송을 완료 했다는 것을 알려줌
//                Toast.makeText(MainActivity.this, "전송이 완료되었습니다.", Toast.LENGTH_SHORT).show();
//                WriteText.setText(null);
//            }
//        });
        btnReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String m = snapshot.getValue(String.class);
                        //TextView에 텍스트 가 입력됨
                        ReceiveText.setText(m);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}