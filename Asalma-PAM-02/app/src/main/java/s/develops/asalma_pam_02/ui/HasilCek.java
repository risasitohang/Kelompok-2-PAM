package s.develops.asalma_pam_02.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import s.develops.asalma_pam_02.R;

public class HasilCek extends AppCompatActivity {

    TextView txthasil;
    ImageView iHasil;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_cek);

        txthasil = findViewById(R.id.hasil);
        iHasil = findViewById(R.id.img);
        next = findViewById(R.id.nxt);

        Intent getIngent = getIntent();

        int hasil = getIngent.getIntExtra("hasil", 0);
        if (hasil<=0){
            iHasil.setImageResource(R.drawable.ic_action_camera);
            txthasil.setText("Rendah");
        }else if(hasil>=1 && hasil<=2){
            txthasil.setText("Sedang");
            iHasil.setImageResource(R.drawable.ic_action_email);
        }else if(hasil>=3){
            txthasil.setText("Tinggi");
            iHasil.setImageResource(R.drawable.ic_action_password);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HasilCek.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}
