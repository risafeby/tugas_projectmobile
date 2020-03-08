package com.risafebyrastuti.siakstmikpontianakc1b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.tonywijaya.siakstmikpontianakc1b.R;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inisialisasiLoginButton();
    }

    private void inisialisasiLoginButton() {
        Button loginButton;

        loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncHttpClient asyncHttpClient;
                EditText idEditText, passwordEditText;
                final String id, password, url;

                idEditText = (EditText)findViewById(R.id.idEditText);
                id = idEditText.getText().toString();

                passwordEditText = (EditText)findViewById(R.id.passwordEditText);
                password = passwordEditText.getText().toString();

                url = "http://tonywijaya.000webhostapp.com/011100862/login.php?id=" + id + "&password=" + password;

                asyncHttpClient = new AsyncHttpClient();
                asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Intent menuIntent;
                        String hasil;

                        hasil = new String(responseBody);
                        //Toast.makeText(getApplicationContext(), new String(responseBody), Toast.LENGTH_LONG).show();

                        if (!hasil.equals("[{\"idCount\":\"1\"}]")) {
                            Toast.makeText(getApplicationContext(), "ID dan Password tidak cocok", Toast.LENGTH_LONG).show();
                            return; // keluar, tidak teruskan coding di bawah
                        }

                        Toast.makeText(getApplicationContext(), "Selamat datang, " + id, Toast.LENGTH_LONG).show();

                        menuIntent = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(menuIntent); // Munculkan activity "Menu"
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
