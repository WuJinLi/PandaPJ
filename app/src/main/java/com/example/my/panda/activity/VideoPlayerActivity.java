package com.example.my.panda.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import com.example.my.panda.R;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * 视频播放页面
 */
public class VideoPlayerActivity extends AppCompatActivity {

    private VideoView videoView_VideoPlayer;
    //手势识别类
    private GestureDetector gestureDetector;
    //当前音量
    private int nVolume = -1;
    //系统最大音量
    private int maxVolume;
    //音频管理器
    private AudioManager audioManager;
    //当前屏幕的而两地
    private float mBrightness = -1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);
        setContentView(R.layout.activity_video_player);
        //初始化UI控件
        initView();
        //播放视频
        playVideo();
        //实例化手势识别对象
        gestureDetector = new GestureDetector(this, new MyGestureDetector());
    }

    private void playVideo() {
        //接收intent表并获取携带的网址
        Intent intent = getIntent();
        String videoUrl = intent.getStringExtra("videoUrl");
        //获取视频地址
        videoView_VideoPlayer.setVideoURI(Uri.parse(videoUrl));
        //设置controller
        MediaController controller = new MediaController(this);
        videoView_VideoPlayer.setMediaController(controller);
        //获取焦点
        videoView_VideoPlayer.requestFocus();
        //启动播放器
        videoView_VideoPlayer.start();
        //视频横屏播放
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        videoView_VideoPlayer.setVideoLayout(VideoView.VIDEO_LAYOUT_ZOOM, 0);
    }

    private void initView() {
        videoView_VideoPlayer = (VideoView) findViewById(R.id.videoView_videoPlayer);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //获取系统的最大声音
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    }

    //识别手势操作的内部类
    public class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        //双击屏幕实现视频的暂停和播放
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            //根据当前videoView_VideoPlayer的状态执行响应的操作
            if (videoView_VideoPlayer.isPlaying()) {
                videoView_VideoPlayer.pause();
            } else {
                videoView_VideoPlayer.start();
            }
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            //获取滑动前的坐标位置
            float oldX = e1.getX();
            float oldY = e1.getY();

            //获取滑动后Y的坐标
            int eTY = (int) e2.getRawY();

            //获取窗口管理器
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            //通过窗口管理器来获取当前窗口的宽度和高度
            int windowWidth = defaultDisplay.getWidth();
            int windowHeigth = defaultDisplay.getHeight();

            //计算当前的操作是在屏幕的左边还是右边
            if (oldX > windowWidth * 4.0 / 5) {
                //在屏幕的右端 实现音量的调节
                changeVolume((oldY - eTY) / windowWidth);
            } else if (oldX < windowWidth / 5) {
                //在屏幕的左端实现亮度的调节
                changeBrightness((oldY - eTY) / windowHeigth);
            }
            return super.onScroll(e1, e2, distanceX, distanceY);

        }
    }

    //改变音量
    public void changeVolume(float changed) {
        //判断是否成功改变音量
        if (nVolume == -1) {
            //获取系统当前的音量
            nVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            //当前音量为负数，设置音量为0
            if (nVolume < 0) {
                nVolume = 0;
            }
        }

        //设置用户滑动的距离
        int index = (int) ((changed * maxVolume) + nVolume);
        if (index > maxVolume) {
            index = maxVolume;
        } else if (index < 0) {
            index = 0;
        }
        //设置当前音量
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, index, 0);
    }

    //改变屏幕的亮度
    public void changeBrightness(float changed) {
        if (mBrightness < 0) {
            //获得屏幕亮度
            mBrightness = getWindow().getAttributes().screenBrightness;
            //判断当前亮度是否小于0.01f，是的话则给变量赋值0.01f放置屏幕变黑
            if (mBrightness <= 0.01f)
                mBrightness = 0.01f;

        }
        //获取window窗口属性
        WindowManager.LayoutParams lpa = getWindow().getAttributes();
        //将当前屏幕亮度加上我们移动的距离的值赋给lpa（窗口管理）
        lpa.screenBrightness = mBrightness + changed;
        //判断当前亮度是否大于1，是则设置为1,（亮度最大只能是1）
        if (lpa.screenBrightness > 1.0f)
            lpa.screenBrightness = 1.0f;
            //判断是否小于0.01，防止黑屏最小设置成0.01
        else if (lpa.screenBrightness < 0.01f)
            lpa.screenBrightness = 0.01f;
        //让设置好的亮度生效
        getWindow().setAttributes(lpa);
    }

    //处理手势操作
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //判断手势识别类是否识别用户的操作
        if (gestureDetector.onTouchEvent(event)) {
            return true;
        }
        //音量和亮度回复初始
        nVolume = -1;
        mBrightness = -1f;
        return super.onTouchEvent(event);
    }
}
