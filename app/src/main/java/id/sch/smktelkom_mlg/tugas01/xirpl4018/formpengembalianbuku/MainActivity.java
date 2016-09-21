package id.sch.smktelkom_mlg.tugas01.xirpl4018.formpengembalianbuku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etJudul;
    CheckBox cbGuru, cbAnggota, cbPengurus;
    RadioButton rbX, rbXI, rbXII;
    Spinner spRak;
    TextView tvNama, tvCB, tvRB, tvSP, tvRat;
    RatingBar ratB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editText);
        etJudul = (EditText) findViewById(R.id.editText2);
        cbAnggota = (CheckBox) findViewById(R.id.checkBox);
        cbGuru = (CheckBox) findViewById(R.id.checkBox3);
        cbPengurus = (CheckBox) findViewById(R.id.checkBox2);
        rbX = (RadioButton) findViewById(R.id.radioButton);
        rbXI = (RadioButton) findViewById(R.id.radioButton2);
        rbXII = (RadioButton) findViewById(R.id.radioButton3);
        spRak = (Spinner) findViewById(R.id.spinner);
        ratB = (RatingBar) findViewById(R.id.ratingBar);
        tvNama = (TextView) findViewById(R.id.textViewNama);
        tvCB = (TextView) findViewById(R.id.textViewCB);
        tvRB = (TextView) findViewById(R.id.textViewRB);
        tvSP = (TextView) findViewById(R.id.textViewSpinner);
        tvRat = (TextView) findViewById(R.id.textViewRat);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
                doProcess();
            }
        });
    }

    private void doProcess() {
        String nama = etNama.getText().toString();
        String judul = etJudul.getText().toString();
        tvNama.setText("nama Peminjam : " + nama + "\nBuku Yang di Rating : " + judul);

    }

    private void doClick() {
        String hasil = null;
        if (rbX.isChecked()) {
            hasil = rbX.getText().toString();
        } else if (rbXI.isChecked()) {
            hasil = rbXI.getText().toString();
        } else if (rbXII.isChecked()) {
            hasil = rbXII.getText().toString();
        }

        if (hasil == null) {
            tvRB.setText("Belum memilih kelas");
        } else {
            tvRB.setText("kelas :" + hasil);
        }
        String cb = "jabatan anda : ";
        int startlen = cb.length();
        if (cbPengurus.isChecked()) cb += cbPengurus.getText() + ", ";
        if (cbGuru.isChecked()) cb += cbGuru.getText() + ", ";
        if (cbAnggota.isChecked()) cb += cbAnggota.getText() + ", ";

        if (cb.length() == startlen) cb += "Bukan anggota, pengurus dan guru";
        tvCB.setText(cb);
        tvSP.setText("kategori buku : " + spRak.getSelectedItem());

        float[] i = new float[]{ratB.getRating()};
        tvRat.setText("adalah: " + i[0]);
    }

}
