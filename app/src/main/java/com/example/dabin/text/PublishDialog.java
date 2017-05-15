package com.example.dabin.text;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Dabin on 2017/5/11.
 */

public class PublishDialog extends Dialog {
    private RelativeLayout mPublishMainRlmian;
    private LinearLayout mPublishDialogVideo;
    private LinearLayout mPublishDialogDanpin;
    private LinearLayout mPublishDialogPhoto;
    private LinearLayout mPublishDialogLlBt;
    private ImageView mPublishDialogIvMenu;


    private Handler mHandler;
    private Context mContext;

    public PublishDialog(Context context) {
        this(context, R.style.main_publishdialog_style);

    }

    public PublishDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.mContext=context;
        init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);

    }

    /**
     * 初始化
     */
    private void init() {
        setContentView(R.layout.mian_dialog_publish);
        mPublishMainRlmian = (RelativeLayout) findViewById(R.id.publish_main_rlmian);
        mPublishDialogVideo = (LinearLayout) findViewById(R.id.Publish_dialog_video);
        mPublishDialogDanpin = (LinearLayout) findViewById(R.id.publish_dialog_danpin);
        mPublishDialogPhoto = (LinearLayout) findViewById(R.id.publish_dialog_Photo);
        mPublishDialogLlBt = (LinearLayout) findViewById(R.id.publish_dialog_llBt);
        mPublishDialogIvMenu = (ImageView) findViewById(R.id.publish_dialog_ivMenu);

        mHandler=new Handler();

        mPublishDialogLlBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outDia();
            }
        });

        mPublishMainRlmian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outDia();
            }
        });

    }

    @Override
    public void show() {
        super.show();
        goinDia();
    }

    /**
     * 进入dialog
     */
    private void goinDia() {
        mPublishDialogVideo.setVisibility(View.INVISIBLE);
        mPublishDialogDanpin.setVisibility(View.INVISIBLE);
        mPublishDialogPhoto.setVisibility(View.INVISIBLE);


        mPublishMainRlmian.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.main_go_in));

        mPublishDialogIvMenu.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.main_rotate_right));

        mPublishDialogVideo.setVisibility(View.VISIBLE);
        mPublishDialogVideo.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.mian_shoot_in));


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPublishDialogDanpin.setVisibility(View.VISIBLE);
                mPublishDialogDanpin.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.mian_shoot_in));

            }
        },100);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPublishDialogPhoto.setVisibility(View.VISIBLE);
                mPublishDialogPhoto.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.mian_shoot_in));


            }
        },200);




    }

    /**
     * 退出Dialog
     */
    public void outDia(){

        mPublishMainRlmian.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.main_go_out));

        mPublishDialogIvMenu.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.main_rotate_left));
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
               dismiss();
            }
        },500);
            mPublishDialogVideo.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.mian_shoot_out));
            mPublishDialogVideo.setVisibility(View.INVISIBLE);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPublishDialogDanpin.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.mian_shoot_out));
                mPublishDialogDanpin.setVisibility(View.INVISIBLE);;
            }
        },100);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPublishDialogPhoto.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.mian_shoot_out));
                mPublishDialogPhoto.setVisibility(View.INVISIBLE);;

            }
        },150);





    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(isShowing()){
            outDia();
            return true;
        }else {
            return super.onKeyDown(keyCode, event);
        }

    }



    public PublishDialog setVedioClickListener(View.OnClickListener clickListener){

        mPublishDialogVideo.setOnClickListener(clickListener);
        return this;

    }
    public PublishDialog setDanpinClickListener(View.OnClickListener clickListener){

        mPublishDialogDanpin.setOnClickListener(clickListener);
        return this;

    }
    public PublishDialog setPhotoClickListener(View.OnClickListener clickListener){

        mPublishDialogPhoto.setOnClickListener(clickListener);
        return this;

    }

}
