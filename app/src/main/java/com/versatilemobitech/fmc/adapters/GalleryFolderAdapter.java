package com.versatilemobitech.fmc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.versatilemobitech.fmc.R;
import com.versatilemobitech.fmc.models.GalleryFolderModel;
import com.versatilemobitech.fmc.models.HomeDataModel;
import com.versatilemobitech.fmc.models.LeftMenuModel;

import java.util.ArrayList;

/**
 * Created by Shankar on 10/25/2016.
 */
public class GalleryFolderAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<GalleryFolderModel> galleryFolderModels;


    public GalleryFolderAdapter(Context context, ArrayList<GalleryFolderModel> galleryFolderModels) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.galleryFolderModels = galleryFolderModels;
    }

    @Override
    public int getCount() {
        //return galleryFolderModels.size();
        return 10;
    }

    @Override
    public GalleryFolderModel getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GalleryFolderHolder mGalleryFolderHolder = null;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.gallery_folder_item,
                    null);
            mGalleryFolderHolder = new GalleryFolderHolder();
            convertView.setTag(mGalleryFolderHolder);
        } else {
            mGalleryFolderHolder = (GalleryFolderHolder) convertView.getTag();
        }

        GalleryFolderModel leftMenuModel = (GalleryFolderModel) getItem(position);

        return convertView;
    }

    private class GalleryFolderHolder {
        private TextView txt_left_drawer_text;
        private ImageView img_left_drawer_icon;
    }
}