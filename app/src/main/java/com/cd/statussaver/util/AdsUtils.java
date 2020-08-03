package com.cd.statussaver.util;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.cd.statussaver.R;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAdListener;

public class AdsUtils {




    public static AdView showFBBannerAd(Context context, LinearLayout adContainer) {
        adContainer.setVisibility(View.VISIBLE);
        AdView adView = new AdView(context, context.getResources().getString(R.string.fb_placement_id), AdSize.BANNER_HEIGHT_50);
        adContainer.addView(adView);
        adView.loadAd();

        return adView;

    }

    public static AdView showFBBannerAdRect(Context context, LinearLayout adContainer) {
        adContainer.setVisibility(View.VISIBLE);
        AdView adView = new AdView(context, context.getResources().getString(R.string.fb_placement_id), AdSize.BANNER_HEIGHT_50);
        adContainer.addView(adView);
        adView.loadAd();

        return adView;

    }

    public static void  showFBInterstitialads(Context context){
        com.facebook.ads.InterstitialAd interstitialAd = new com.facebook.ads.InterstitialAd(context, context.getResources().getString(R.string.fb_placement_interstitial_id));
        // Set listeners for the Interstitial Ad
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                Log.e(ContentValues.TAG, "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                Log.e(ContentValues.TAG, "Interstitial ad dismissed.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback

            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(ContentValues.TAG, "Interstitial ad is loaded and ready to be displayed!");
                // Show the ad
                interstitialAd.show();

            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                Log.d(ContentValues.TAG, "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                Log.d(ContentValues.TAG, "Interstitial ad impression logged!");
            }
        });

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd();
    }


}
