package com.risafebyrastuti.siakstmikpontianakc1b;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tonywijaya.siakstmikpontianakc1b.R;

public class PemakaiViewHolder extends RecyclerView.ViewHolder {
    public TextView idTextView, passwordTextView;
    public ImageView deleteImageview, editImageView;
    public PemakaiViewHolder (View itemView) {
        super(itemView);

        idTextView = (TextView)itemView.findViewById(R.id.idTextView);
        passwordTextView = (TextView)itemView.findViewById(R.id.PasswordTextView);
        deleteImageview = (ImageView)itemView.findViewById(R.id.deleteImageView);
        editImageView = (ImageView)itemView.findViewById(R.id.deleteImageView);
    }
}
