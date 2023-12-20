package com.msg.msgalaxy.MVCOfTopMSG_homeFragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.msg.msgalaxy.AboutMovieOrSerieActivity;
import com.msg.msgalaxy.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterOfTopMSG extends PagerAdapter {

    private Context context;
    private List<ModelOfTopMSG> topMSGList;


    public AdapterOfTopMSG(Context context , List<ModelOfTopMSG> dataOfTopMSGList) {
        this.context = context;
        this.topMSGList = dataOfTopMSGList;
    }

    @Override
    public int getCount() {
        return topMSGList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_fragment_topmsg_card_item, container , false);
        ModelOfTopMSG modelOfTopMSG = topMSGList.get(position);

        ImageView topMSGPicUrlImageView = (ImageView) view.findViewById(R.id.homeFragment_topMSG_carditem_pictureId);
        TextView type = (TextView) view.findViewById(R.id.homeFragment_topMSG_carditem_typeId);
        TextView year = (TextView) view.findViewById(R.id.homeFragment_topMSG_carditem_yearId);
        TextView imdbRating = (TextView) view.findViewById(R.id.homeFragment_topMSG_carditem_imdbRatingId);

        //The Url of Picture
        String topMSGPicUrl = modelOfTopMSG.getTopMSGPicUrl();
        Picasso.get().load(topMSGPicUrl).into(topMSGPicUrlImageView);

        type.setText(modelOfTopMSG.getType());
        year.setText(modelOfTopMSG.getYear());
        imdbRating.setText(modelOfTopMSG.getImdbRating());

        topMSGPicUrlImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , AboutMovieOrSerieActivity.class);
                context.startActivity(intent);
            }
        });


        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView( (View) object );
    }
}
