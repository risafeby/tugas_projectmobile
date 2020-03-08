package com.risafebyrastuti.siakstmikpontianakc1b;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.tonywijaya.siakstmikpontianakc1b.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static android.support.v4.content.ContextCompat.startActivity;

public class PemakaiAdapter extends RecyclerView.Adapter<PemakaiViewHolder> {
    private List<PemakaiModel> pemakaiModelList;

    public PemakaiAdapter(List<PemakaiModel> pemakaiModelList) {
        this.pemakaiModelList = pemakaiModelList;
    }

    @NonNull
    @Override
    public PemakaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater;
        View v;

        inflater =  LayoutInflater.from(parent.getContext());
        v = inflater.inflate(R.layout.item_pemakai, parent,false);

        return new PemakaiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PemakaiViewHolder holder, final int position) {
        final PemakaiModel pm;

        pm = pemakaiModelList.get(position);

        holder.deleteImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //Toast.makeText(view.getContext(),  "Id: " + pm.getId(),Toast.LENGTH_SHORT).show();

                String id = pm.getId();

                try {
                    id = URLEncoder.encode(id, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }
                String url = "http://tonywijaya.000webhostapp.com/011100862/hapusPemakai.php?id=" + id;

                AsyncHttpClient ahc = new AsyncHttpClient();
                ahc.get(url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Toast.makeText(view.getContext(), "Record Telah dihapus", Toast.LENGTH_SHORT).show();
                        pemakaiModelList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, pemakaiModelList.size());
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }
                });
                holder.editImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent ubahPemakaiIntent = new Intent (view.getContext(), UbahPemakaiaActivity.class);
                        startActivity(view.getContext(), ubahPemakaiIntent, null);
                        ubahPemakaiIntent.putExtra("id", pm.getId());
                        ubahPemakaiIntent.putExtra("password", pm.getPassword());

                        startActivity(view.getContext(), ubahPemakaiIntent, null);
                    }
                });
            }
        });
        holder.idTextView.setText(pm.getId());
        holder.passwordTextView.setText(pm.getPassword());
    }

    @Override
    public int getItemCount() {
        int itemCount;

        itemCount = 0;

        if (pemakaiModelList !=null) {
            itemCount = pemakaiModelList.size();
        }

        return itemCount;
    }
}
