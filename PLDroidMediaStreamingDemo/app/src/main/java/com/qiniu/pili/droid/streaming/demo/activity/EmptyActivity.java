package com.qiniu.pili.droid.streaming.demo.activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.qiniu.pili.droid.streaming.demo.R;
import com.qiniu.pili.droid.streaming.demo.usb.UVCCameraFragment;

import java.nio.ByteBuffer;

/**
 * Created by HuangXin on 2023/7/3.
 */
public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//        setRequestedOrientation(Config.SCREEN_ORIENTATION);
        setContentView(R.layout.activity_empty);
        UVCCameraFragment usbCameraFragment = new UVCCameraFragment();
        usbCameraFragment.callBack = new UVCCameraFragment.UVCCallback() {
            @Override
            public void onFrame(ByteBuffer buffer, int width, int height) {
                if (buffer != null) {
                }
            }

            @Override
            public void onSizeChange() {
                finish();
            }
        };
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, usbCameraFragment);
        transaction.commitAllowingStateLoss();
    }
}
