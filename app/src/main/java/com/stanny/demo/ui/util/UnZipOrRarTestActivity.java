package com.stanny.demo.ui.util;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.stanny.demo.R;
import com.stanny.demo.ui.BaseActivity;
import com.zx.zxutils.listener.ZXUnZipRarListener;
import com.zx.zxutils.util.ZXLogUtil;
import com.zx.zxutils.util.ZXSystemUtil;
import com.zx.zxutils.util.ZXUnZipRarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UnZipOrRarTestActivity extends BaseActivity {

    @BindView(R.id.pb_test_unzip)
    ProgressBar pbTestUnzip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_un_zip_or_rar_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test_unzip)
    public void onViewClicked() {
        ZXUnZipRarUtil.unRar(ZXSystemUtil.getSDCardPath() + "rartest.rar", ZXSystemUtil.getSDCardPath(), new ZXUnZipRarListener() {
            @Override
            public void onStart() {
                ZXLogUtil.loge("解压开始");
            }

            @Override
            public void onPregress(int progress) {
                ZXLogUtil.loge("解压：" + progress);
                pbTestUnzip.setProgress(progress);
            }

            @Override
            public void onComplete(String outputPath) {
                ZXLogUtil.loge("解压结束");
            }

            @Override
            public void onError(String message) {
                ZXLogUtil.loge("解压错误" + message);
            }
        });
    }
}
