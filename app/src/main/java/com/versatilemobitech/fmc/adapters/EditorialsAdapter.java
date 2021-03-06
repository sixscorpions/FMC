package com.versatilemobitech.fmc.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.versatilemobitech.fmc.R;
import com.versatilemobitech.fmc.models.EditorialsModel;
import com.versatilemobitech.fmc.models.GalleryFolderModel;
import com.versatilemobitech.fmc.models.MembersModel;
import com.versatilemobitech.fmc.utility.Utility;

import java.util.ArrayList;

/**
 * Created by Shankar on 10/25/2016.
 */
public class EditorialsAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<EditorialsModel> editorialsModels;
    private Typeface mTypefaceRobotoRegular;

    public EditorialsAdapter(Context context, ArrayList<EditorialsModel> editorialsModels) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.editorialsModels = editorialsModels;
        mTypefaceRobotoRegular = Utility.setTypeFaceRobotoRegular(mContext);
    }


    @Override
    public int getCount() {
        return editorialsModels.size();
    }

    @Override
    public EditorialsModel getItem(int position) {
        return editorialsModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        EditorialsItemHolder mEditorialsItemHolder = null;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_editorials,
                    null);
            mEditorialsItemHolder = new EditorialsItemHolder();
            mEditorialsItemHolder.txt_your_name = (TextView) convertView.findViewById(R.id.txt_your_name);
            mEditorialsItemHolder.txt_author_name = (TextView) convertView.findViewById(R.id.txt_author_name);
            mEditorialsItemHolder.txt_time_date = (TextView) convertView.findViewById(R.id.txt_time_date);
            mEditorialsItemHolder.img_editorials = (ImageView) convertView.findViewById(R.id.img_editorials);
            mEditorialsItemHolder.txt_your_name.setTypeface(mTypefaceRobotoRegular);
            mEditorialsItemHolder.txt_time_date.setTypeface(mTypefaceRobotoRegular);
            convertView.setTag(mEditorialsItemHolder);
        } else {
            mEditorialsItemHolder = (EditorialsItemHolder) convertView.getTag();
        }

        EditorialsModel editorialsModel = (EditorialsModel) getItem(position);


        mEditorialsItemHolder.txt_your_name.setText(Utility.capitalizeFirstLetter(editorialsModel.getBook_name()));
        mEditorialsItemHolder.txt_author_name.setText(Utility.capitalizeFirstLetter(editorialsModel.getAuthor()));
        mEditorialsItemHolder.txt_time_date.setText(Utility.capitalizeFirstLetter(editorialsModel.getBook_description()));

        if (!Utility.isValueNullOrEmpty(editorialsModel.getSmall_Image()))
            Picasso.with(mContext)
                    .load(editorialsModel.getSmall_Image()).memoryPolicy(MemoryPolicy.NO_CACHE)
                    .placeholder(Utility.getDrawable(mContext, R.drawable.folder_icon))
                    .into(mEditorialsItemHolder.img_editorials);

        return convertView;
    }


    private class EditorialsItemHolder {
        private TextView txt_your_name;
        private TextView txt_author_name;
        /*private TextView txt_company;*/
        private TextView txt_time_date;
        private ImageView img_editorials;
    }
}
