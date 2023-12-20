package com.msg.msgalaxy.MVCOfCategories;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.msg.msgalaxy.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterOfCategories extends RecyclerView.Adapter<AdapterOfCategories.MyViewHolder> {

    private Context context;
    private List<ModelOfCategories> categoriesList;

    public AdapterOfCategories(Context context, List<ModelOfCategories> categoriesList) {
        this.context = context;
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row_for_categories , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelOfCategories categoriePic = categoriesList.get(position);
        Picasso.get().load(categoriePic.getCategoriePicUrl()).into(holder.categoriePic, new Callback() {
            @Override
            public void onSuccess() {
                holder.categorieLoadingIcon.setVisibility(View.GONE);
                holder.categoriePic.setVisibility(View.VISIBLE);
            }
            @Override
            public void onError(Exception e) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView categoriePic;
        private ImageView categorieLoadingIcon;
        private CardView cardViewOfCategoriePicId;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            categoriePic = (ImageView) itemView.findViewById(R.id.categoriePictureId);
            categorieLoadingIcon = (ImageView) itemView.findViewById(R.id.categorieLoadingIconId);
            cardViewOfCategoriePicId = (CardView) itemView.findViewById(R.id.cardViewOfCategoriePicId);
            cardViewOfCategoriePicId.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context , CategorieMoviesAndSeries.class);
            int position = getLayoutPosition();
            ModelOfCategories movie = categoriesList.get(position);
            intent.putExtra("categorieName" , movie.getCategorieName());
            intent.putExtra("categorieBackground", movie.getCategorieBackgroundUrl());
            context.startActivity(intent);
        }
    }
}
