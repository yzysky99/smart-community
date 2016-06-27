package com.stev.smart_community.home;

import java.util.ArrayList;
import java.util.List;

import com.stev.smart_community.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ShopAdapter extends BaseAdapter {
	private static final String TAG = "CategoryAdapter";
	private Context context;
	private List<ShopInfo> mShopInfoList = new ArrayList<ShopInfo>();
		
	public ShopAdapter(Context context){
		this.context=context;
	}

	@Override
	public int getCount() {
		return mShopInfoList.size();
	}

	public void updateData(List<ShopInfo> data) {
		mShopInfoList.clear();
		if (data != null && data.size() != 0) {
			mShopInfoList.addAll(data);
		}
		Log.d(TAG, "updateData mShopInfoList.size() = %d" + mShopInfoList.size());
	}
	
	@Override
	public Object getItem(int position) {
		return mShopInfoList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HolderView holderView=null;
		if (convertView==null) {
			holderView=new HolderView();
			convertView=LayoutInflater.from(context).inflate(R.layout.shop_list_item, null);
			holderView.shopLogo = (ImageView) convertView.findViewById(R.id.iv_shop_logo);
			holderView.shopName = (TextView) convertView.findViewById(R.id.tv_shop_name);
			holderView.shopRatingBar = (RatingBar) convertView.findViewById(R.id.rb_shop_ratingbar);
			holderView.shopPrice = (TextView) convertView.findViewById(R.id.tv_shop_price);
			convertView.setTag(holderView);
		}else {
			holderView=(HolderView) convertView.getTag();
		}
		
		Log.d(TAG, "position = " + position);
		Bitmap logoBitmap = mShopInfoList.get(position).shopLogo;
		holderView.shopLogo.setImageBitmap(logoBitmap);
		holderView.shopName.setText(mShopInfoList.get(position).shopName);
//		holderView.shopRatingBar.set
		holderView.shopPrice.setText(mShopInfoList.get(position).shopPrice);
		
		return convertView;
	}
	
	public class HolderView {
		private ImageView shopLogo;
		private TextView shopName;
		private RatingBar shopRatingBar;
		private TextView shopPrice;
	}
	
}

