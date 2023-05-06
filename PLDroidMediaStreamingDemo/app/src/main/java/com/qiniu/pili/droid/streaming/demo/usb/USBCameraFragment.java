package com.qiniu.pili.droid.streaming.demo.usb;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jiangdg.ausbc.MultiCameraClient;
import com.jiangdg.ausbc.base.CameraFragment;
import com.jiangdg.ausbc.widget.IAspectRatio;
import com.qiniu.pili.droid.streaming.demo.databinding.FragmentImportStreamingBinding;

/**
 * Created by HuangXin on 2023/4/17.
 */
public class USBCameraFragment extends CameraFragment {
    private static final String TAG = "USBCameraFragment";
    private FragmentImportStreamingBinding binding;
    public com.jiangdg.ausbc.callback.IPreviewDataCallBack callBack;

    @Nullable
    @Override
    protected View getRootView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        binding = FragmentImportStreamingBinding.inflate(layoutInflater, viewGroup, false);
        return binding.getRoot();
    }

    @Nullable
    @Override
    protected IAspectRatio getCameraView() {
        return new AspectRatioTextureView(requireContext());
    }

    @Nullable
    @Override
    protected ViewGroup getCameraViewContainer() {
        return binding.cameraViewContainer;
    }

    @Override
    public void onCameraState(@NonNull MultiCameraClient.ICamera iCamera, @NonNull State state, @Nullable String s) {
        Log.d(TAG, "onCameraState: " + state);
        iCamera.addPreviewDataCallBack(callBack);
    }
}
