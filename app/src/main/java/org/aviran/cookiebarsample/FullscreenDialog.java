package org.aviran.cookiebarsample;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.aviran.cookiebar2.CookieBar;
import org.aviran.cookiebar2.OnActionClickListener;

public class FullscreenDialog extends DialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CookieBar.build(FullscreenDialog.this)
                        .setTitle(R.string.infinite_cookie_title)
                        .setTitleColor(R.color.yellow)
                        .setMessage(R.string.infinite_cookie_message)
                        .setIcon(R.drawable.ic_android_white_48dp)
                        .setCookiePosition(CookieBar.BOTTOM)
                        .setAction(R.string.dismiss, new OnActionClickListener() {
                            @Override
                            public void onClick() {
                                CookieBar.dismiss(FullscreenDialog.this.getActivity());
                            }
                        })
                        .show();
            }
        }, 500);


    }
}
