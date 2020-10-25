package com.asgeirr.businesscard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;

public class BCardView extends RelativeLayout implements View.OnClickListener {
    private SimpleBCard simpleBCard;
    private ImageView ivLogo;
    private ElemView evCompany, evName, evWorkPosition, evWhatsApp, evEmail, evWebSite;
    private RelativeLayout vRoot;
    private int widthCard, heightCard;

    public BCardView(Context context) {
        super(context);
        init(context);
    }

    public BCardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BCardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BCardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_bcard_view, this);
        vRoot = findViewById(R.id.BusinessCardView_vRoot);
        Log.d("BCardView", "init view");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthCard = vRoot.getMeasuredWidth();
        heightCard = vRoot.getMeasuredHeight();
        Log.d("BCardView", String.format("onMeasure: wMs:%d hMs:%d w%d h%d", widthMeasureSpec, heightMeasureSpec, widthCard, heightCard));
        updateView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("BCardView", String.format("onDraw: w:%d h:%d", vRoot.getMeasuredWidth(), vRoot.getMeasuredHeight()));
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("BCardView", "onFinishInflate");
        updateView();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        widthCard = vRoot.getMeasuredWidth();
        heightCard = vRoot.getMeasuredHeight();
        Log.d("BCardView", String.format("onSizeChanged: w:%d h:%d Oldw:%d Oldh%d", w, h, oldw, oldh));
        updateView();
    }

    @Override
    public void onClick(View v) {

    }

    public void load(SimpleBCard simpleBCard){
        this.simpleBCard = simpleBCard;
        Log.d("BCardView", "load");
        updateView();
    }

    private void updateView() {
        if (simpleBCard == null || widthCard == 0 || heightCard == 0) {
            Log.d("BCardView", String.format("updateView: Can't update view %s", simpleBCard == null ? "Object is null" : widthCard == 0 ? "widthView is 0" : heightCard == 0 ? "height View is 0" : "unknown"));
            return;
        }
        putBackground();
        putImage();
        putCompanyName();
        putName();
        putWorkPosition();
        putPhoneNumber();
        putEmail();
        putWebSite();
    }

    private String layoutParamsToString(LayoutParams layoutParams) {
        return String.format("w:%d h:%d l:%d t:%d", layoutParams.width, layoutParams.height, layoutParams.leftMargin, layoutParams.topMargin);
    }

    private void putWebSite() {
        if (simpleBCard.getWebSite() != null && simpleBCard.getWebSite().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getWebSite().getText())) {
                if (simpleBCard.isDummy())
                    simpleBCard.getWebSite().setText(getResources().getString(R.string.your_website));
                else {
                    if (evWebSite != null)
                        evWebSite.setVisibility(GONE);
                    return;
                }
            }
            Log.d("BCardView", String.format("Loading webSite %s", CommonUtils.toJson(simpleBCard.getWebSite())));
            if (evWebSite == null) {
                evWebSite = new ElemView(getContext());
                evWebSite.setElem(simpleBCard.getWebSite());
                evWebSite.setRotation(simpleBCard.getWebSite().getAngle());
                LayoutParams layoutParams = getLayoutParams(simpleBCard.getWebSite());
                vRoot.addView(evWebSite, layoutParams);
                Log.d("BCardView", String.format("set webSite position %s", layoutParamsToString(layoutParams)));
            } else
                evWebSite.updateText(simpleBCard.getWebSite().getText());
            evWebSite.setVisibility(VISIBLE);
        } else {
            Log.d("BCardView", String.format("Can't loading webSite %s", simpleBCard.getWebSite() == null ? "null" : CommonUtils.toJson(simpleBCard.getWebSite())));
            if (evWebSite != null)
                evWebSite.setVisibility(GONE);
        }
    }

    private void putEmail() {
        if (simpleBCard.getEmail() != null && simpleBCard.getEmail().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getEmail().getText())) {
                if (simpleBCard.isDummy())
                    simpleBCard.getEmail().setText(getResources().getString(R.string.your_email));
                else {
                    if (evEmail != null)
                        evEmail.setVisibility(GONE);
                    return;
                }
            }
            Log.d("BCardView", String.format("Loading email %s", CommonUtils.toJson(simpleBCard.getEmail())));
            if (evEmail == null) {
                evEmail = new ElemView(getContext());
                evEmail.setElem(simpleBCard.getEmail());
                evEmail.setRotation(simpleBCard.getEmail().getAngle());
                LayoutParams layoutParams = getLayoutParams(simpleBCard.getEmail());
                vRoot.addView(evEmail, layoutParams);
                Log.d("BCardView", String.format("set email position %s", layoutParamsToString(layoutParams)));
            } else
                evEmail.updateText(simpleBCard.getEmail().getText());
            evEmail.setVisibility(VISIBLE);
        } else {
            Log.d("BCardView", String.format("Can't loading email %s", simpleBCard.getEmail() == null ? "null" : CommonUtils.toJson(simpleBCard.getEmail())));
            if (evEmail != null)
                evEmail.setVisibility(GONE);
        }
    }

    private void putPhoneNumber() {
        if (simpleBCard.getWhatsApp() != null && simpleBCard.getWhatsApp().getHeight() > 0) {
            SimpleElem whatsAppTemp = simpleBCard.getWhatsApp().clone();
            if (!TextUtils.isEmpty(whatsAppTemp.getText()) || !TextUtils.isEmpty(simpleBCard.getCountryCode()))
                whatsAppTemp.setText((!TextUtils.isEmpty(simpleBCard.getCountryCode()) ? simpleBCard.getCountryCode() : "") + (!TextUtils.isEmpty(simpleBCard.getWhatsApp().getText()) ? simpleBCard.getWhatsApp().getText() : ""));
            else {
                if (simpleBCard.isDummy())
                    whatsAppTemp.setText(getResources().getString(R.string.your_phone));
                else {
                    if (evWhatsApp != null)
                        evWhatsApp.setVisibility(GONE);
                    return;
                }
            }
            Log.d("BCardView", String.format("Loading whatsApp %s", CommonUtils.toJson(simpleBCard.getWhatsApp())));
            if (evWhatsApp == null) {
                evWhatsApp = new ElemView(getContext());
                evWhatsApp.setElem(whatsAppTemp);
                evWhatsApp.setRotation(simpleBCard.getWhatsApp().getAngle());
                vRoot.addView(evWhatsApp, getLayoutParams(simpleBCard.getWhatsApp()));
            } else
                evWhatsApp.updateText(whatsAppTemp.getText());
            evWhatsApp.setVisibility(VISIBLE);
        } else {
            Log.d("BCardView", String.format("Can't loading whatsApp %s", simpleBCard.getWhatsApp() == null ? "null" : CommonUtils.toJson(simpleBCard.getWhatsApp())));
            if (evWhatsApp != null)
                evWhatsApp.setVisibility(GONE);
        }
    }

    private void putWorkPosition() {
        if (simpleBCard.getWorkPosition() != null && simpleBCard.getWorkPosition().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getWorkPosition().getText())) {
                if (simpleBCard.isDummy())
                    simpleBCard.getWorkPosition().setText(getResources().getString(R.string.your_work_position));
                else {
                    if (evWorkPosition != null)
                        evWorkPosition.setVisibility(GONE);
                    return;
                }
            }
            Log.d("BCardView", String.format("Loading workPosition %s", CommonUtils.toJson(simpleBCard.getWorkPosition())));
            if (evWorkPosition == null) {
                evWorkPosition = new ElemView(getContext());
                evWorkPosition.setElem(simpleBCard.getWorkPosition());
                evWorkPosition.setRotation(simpleBCard.getWorkPosition().getAngle());
                vRoot.addView(evWorkPosition, getLayoutParams(simpleBCard.getWorkPosition()));
            } else
                evWorkPosition.updateText(simpleBCard.getWorkPosition().getText());
            evWorkPosition.setVisibility(VISIBLE);
        } else {
            Log.d("BCardView", String.format("Can't loading workPosition %s", simpleBCard.getWorkPosition() == null ? "null" : CommonUtils.toJson(simpleBCard.getWorkPosition())));
            if (evWorkPosition != null)
                evWorkPosition.setVisibility(GONE);
        }
    }

    private void putName() {
        if (simpleBCard.getName() != null && simpleBCard.getName().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getName().getText())) {
                if (simpleBCard.isDummy) {
                    simpleBCard.getName().setText(getResources().getString(R.string.your_name));
                } else {
                    if (evName != null)
                        evName.setVisibility(GONE);
                    return;
                }
            }
            Log.d("BCardView", String.format("Loading name %s", CommonUtils.toJson(simpleBCard.getName())));
            if (evName == null) {
                evName = new ElemView(getContext());
                evName.setElem(simpleBCard.getName());
                LayoutParams layoutParams = getLayoutParams(simpleBCard.getName());
                vRoot.addView(evName, layoutParams);
//                evName.setPivotX(layoutParams.height/2);
//                evName.setPivotY(layoutParams.width/2);
                evName.setRotation(simpleBCard.getName().getAngle());
            } else
                evName.updateText(simpleBCard.getName().getText());
            evName.setVisibility(VISIBLE);
        } else {
            Log.d("BCardView", String.format("Can't loading name %s", simpleBCard.getName() == null ? "null" : CommonUtils.toJson(simpleBCard.getName())));
            if (evName != null)
                evName.setVisibility(GONE);
        }
    }

    private void putCompanyName() {
        if (simpleBCard.getCompanyName() != null && simpleBCard.getCompanyName().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getCompanyName().getText())) {
                if (simpleBCard.isDummy())
                    simpleBCard.getCompanyName().setText(getResources().getString(R.string.your_company));
                else {
                    if (evCompany != null)
                        evCompany.setVisibility(GONE);
                    return;
                }
            }
            Log.d("BCardView", String.format("Loading companyName %s", CommonUtils.toJson(simpleBCard.getCompanyName())));
            if (evCompany == null) {
                evCompany = new ElemView(getContext());
                evCompany.setRotation(simpleBCard.getCompanyName().getAngle());
                vRoot.addView(evCompany, getLayoutParams(simpleBCard.getCompanyName()));
                evCompany.setElem(simpleBCard.getCompanyName());
            } else
                evCompany.updateText(simpleBCard.getCompanyName().getText());
            evCompany.setVisibility(VISIBLE);
        } else {
            Log.d("BCardView", String.format("Can't loading companyName %s", simpleBCard.getCompanyName() == null ? "null" : CommonUtils.toJson(simpleBCard.getCompanyName())));
            if (evCompany != null)
                evCompany.setVisibility(GONE);
        }
    }

    private void putImage() {
        if (simpleBCard.getLogo() != null && simpleBCard.getLogo().getWidth() > 0 && simpleBCard.getLogo().getHeight() > 0) {
            if (ivLogo == null) {
                ivLogo = new ImageView(getContext());
                ivLogo.setRotation(simpleBCard.getLogo().getAngle());
                vRoot.addView(ivLogo, getLayoutParams(simpleBCard.getLogo()));
            }
            Glide.with(getContext()).load(simpleBCard.getLogo().getThumbnail()).override(ivLogo.getLayoutParams().width, ivLogo.getLayoutParams().height).fitCenter().into(ivLogo);
            Log.d("BCardView", String.format("Loading logo %s", CommonUtils.toJson(simpleBCard.getLogo())));
        } else if (ivLogo != null) {
            Glide.with(getContext()).clear(ivLogo);
            Log.d("BCardView", String.format("Can't loading logo %s", simpleBCard.getLogo() == null ? "null" : CommonUtils.toJson(simpleBCard.getLogo())));
        }
    }

    private void putBackground() {
        if (TextUtils.isEmpty(simpleBCard.getBackgroundImage())) {
            vRoot.setBackground(null);
            Log.d("BCardView", "Can't loading background, its empty");
            return;
        }
        Log.d("BCardView", String.format("Loading background %s", simpleBCard.getBackgroundImage()));
        RequestBuilder<Drawable> requestBuilder = Glide.with(getContext()).asDrawable();
        File file = new File(simpleBCard.getBackgroundImage());
        if (file.exists()) {
            requestBuilder = requestBuilder.load(new File(simpleBCard.getBackgroundImage()));
        } else if (URLUtil.isAssetUrl(simpleBCard.getBackgroundImage())) {
            requestBuilder = requestBuilder.load(Uri.parse(simpleBCard.getBackgroundImage()));
        } else if (URLUtil.isValidUrl(simpleBCard.getBackgroundImage())) {
            requestBuilder = requestBuilder.load(simpleBCard.getBackgroundImage());
        } else if (simpleBCard.getBackgroundImage().matches("([A-Fa-f0-9]){6}")) {
            int color;
            try {
                color = CommonUtils.parseStringColor(simpleBCard.getBackgroundImage());
            } catch (Exception e) {
                color = CommonUtils.parseStringColor("FFF");
            }
            requestBuilder = requestBuilder.load(new ColorDrawable(color));
        } else
            return;
        requestBuilder.override(getMeasuredWidth(), getMeasuredHeight()).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                vRoot.setBackground(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }

            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
            }
        });
    }

    public LayoutParams getLayoutParams(SimpleElem simpleElem) {
        LayoutParams layoutParams = new LayoutParams(simpleElem.getWidth() == 0 ?
                (widthCard - (int) (simpleElem.getxPosition() * widthCard) / 100) :
                (int) (simpleElem.getWidth() * widthCard) / 100, (int) (simpleElem.getHeight() * heightCard) / 100);
        layoutParams.leftMargin = (int) (simpleElem.getxPosition() * widthCard) / 100;
        layoutParams.topMargin = (int) (simpleElem.getyPosition() * heightCard) / 100;
        return layoutParams;
    }

    public void takeBcScreenShot(final ScreenShotCallback callback) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = CommonUtils.loadBitmapFromView(vRoot);
                String path = CommonUtils.saveBitmap(bitmap, getContext(), "card");
                if (!TextUtils.isEmpty(path)) {
                    callback.finish(path);
                }
            }
        });
    }
}
