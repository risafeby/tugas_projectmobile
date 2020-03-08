package com.risafebyrastuti.siakstmikpontianakc1b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tonywijaya.siakstmikpontianakc1b.R;

public class MenuMasterPemakaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_master_pemakai);

        inisialisasiTampilUbahHapusButton();
        inisialisasiTambahPemakaiButton();

    }
    private void inisialisasiTambahPemakaiButton() {
        Button tambahPemakaiButton = (Button)findViewById(R.id.tambahPemakaiButton);

        tambahPemakaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tambahPemakaiIntent = new Intent(getApplicationContext(), TambahPemakaiActivity.class);
                startActivity(tambahPemakaiIntent);
            }
        });
}
    private void inisialisasiTampilUbahHapusButton () {
        Button tampilUbahHapusButton;

        tampilUbahHapusButton = (Button)findViewById(R.id.tampilUbahHapusPemakaiButton);
        tampilUbahHapusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tampilUbahHapusIntent;

                tampilUbahHapusIntent = new Intent(getApplicationContext(),TampilUbahHapusPemakaiActivity.class);
                startActivity(tampilUbahHapusIntent);
            }
        });
    }
}
