package com.risafebyrastuti.siakstmikpontianakc1b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.risafebyrastuti.siakstmikpontianakc1b.MenuMasterPemakaiActivity;
import com.tonywijaya.siakstmikpontianakc1b.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        inisialisasiMasterPemakaiButton();
    }

    private void inisialisasiMasterPemakaiButton() {
        Button masterPemakaiButton;

        masterPemakaiButton = (Button)findViewById(R.id.masterPemakaiButton);
        masterPemakaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuMasterPemakaiIntent;

                menuMasterPemakaiIntent = new Intent(getApplicationContext(), MenuMasterPemakaiActivity.class);
                startActivity(menuMasterPemakaiIntent);
            }
        });
    }
}
