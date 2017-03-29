package com.mapswithme.maps.ads;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.my.target.nativeads.NativeAd;
import com.my.target.nativeads.banners.NativePromoBanner;
import com.my.target.nativeads.models.ImageData;

class MyTargetNativeAd extends CachedMwmNativeAd
{
  @NonNull
  private final NativeAd mAd;

  MyTargetNativeAd(@NonNull NativeAd ad, long timestamp)
  {
    super(timestamp);
    mAd = ad;
  }

  @NonNull
  @Override
  public String getTitle()
  {
    return mAd.getBanner().getTitle();
  }

  @NonNull
  @Override
  public String getDescription()
  {
    return mAd.getBanner().getDescription();
  }

  @NonNull
  @Override
  public String getAction()
  {
    return mAd.getBanner().getCtaText();
  }

  @Override
  public void loadIcon(@NonNull View view)
  {
    NativePromoBanner banner = mAd.getBanner();
    ImageData icon = banner.getIcon();
    if (icon != null)
      NativeAd.loadImageToView(icon, (ImageView) view);
  }

  @Override
  public void registerView(@NonNull View bannerView)
  {
    mAd.registerView(bannerView);
  }

  @NonNull
  @Override
  public String getProvider()
  {
    return "MY_TARGET";
  }
}
