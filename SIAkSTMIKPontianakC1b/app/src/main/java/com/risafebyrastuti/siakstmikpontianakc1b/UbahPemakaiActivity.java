package com.risafebyrastuti.siakstmikpontianakc1b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.tonywijaya.siakstmikpontianakc1b.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cz.msebera.android.httpclient.Header;

public class UbahPemakaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_pemakai);

        inisialisasiActivity();
        inisialisasiSimpanButton();
    }

    private void inisialisasiSimpanButton() {
        Button simpanButton = (Button)findViewById(R.id.simpanButton);

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText idEditText = (EditText)findViewById(R.id.idEditText);
                String id = idEditText.getText().toString();

                try {
                    id = URLEncoder.encode(id, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }

String url = "http://tonywijaya.000webhostapp.com/011100862/hapusPemakai.php?id=" + id;


                AsyncHttpClient ahc = new AsyncHttpClient();
                ahc.get(url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String id2 = idEditText.getText().toString();

                        try {
                            id2 = URLEncoder.encode(id2, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            return;
                        }

                        EditText passwordEditText = (EditText)findViewById(R.id.passwordEditText);
                        String password = passwordEditText.getText().toString();

                        try {
                            password = URLEncoder.encode(password, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            return;
                        }

String url2 = "http://tonywijaya.000webhostapp.com/011100862/tambahPemakai.php?id=" + id2 + "&password=" + password;

                        AsyncHttpClient ahc2 = new AsyncHttpClient();
                        ahc2.get(url2, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                                Toast.makeText(getApplicationContext(), "Record telah disimpan: " + new String(responseBody), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                });
            }
        });
    }

    private void inisialisasiActivity() {
        String id = getIntent().getStringExtra("id");
        EditText idEditText = (EditText)findViewById(R.id.idEditText);
        idEditText.setText(id);

        String password = getIntent().getStringExtra("password");
        EditText passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        passwordEditText.setText(password);
    }
}