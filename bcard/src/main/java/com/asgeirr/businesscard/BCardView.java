package com.asgeirr.businesscard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
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
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

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
        vRoot=findViewById(R.id.BusinessCardView_vRoot);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthCard =vRoot.getMeasuredWidth();
        heightCard=vRoot.getMeasuredHeight();
        updateView();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateView();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        widthCard =vRoot.getMeasuredWidth();
        heightCard=vRoot.getMeasuredHeight();
        updateView();
    }

    @Override
    public void onClick(View v) {

    }

    public void load(SimpleBCard simpleBCard){
        this.simpleBCard = simpleBCard;
        updateView();
    }

    private void updateView() {
        if (simpleBCard == null || widthCard == 0 || heightCard == 0) {
            if (simpleBCard != null)
                Log.e(BCardView.class.getSimpleName(), "Not loaded ID :" + simpleBCard.getCardThumbnail());
            return;
        }
        Log.d(BCardView.class.getSimpleName(), "Loaded ID :" + simpleBCard.getCardThumbnail());
        putBackground();
        putImage();
        putCompanyName();
        putName();
        putWorkPosition();
        putPhoneNumber();
        putEmail();
        putWebSite();
    }

    private void putWebSite() {
        if (simpleBCard.getWebSite() != null && simpleBCard.getWebSite().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getWebSite().getText()))
                simpleBCard.getWebSite().setText(getResources().getString(R.string.your_website));
            if (evWebSite == null) {
                evWebSite = new ElemView(getContext());
                evWebSite.setElem(simpleBCard.getWebSite());
                vRoot.addView(evWebSite, getLayoutParams(simpleBCard.getWebSite()));
            } else
                evWebSite.updateText(simpleBCard.getWebSite().getText());
            evWebSite.setVisibility(VISIBLE);
        } else {
            if (evWebSite != null)
                evWebSite.setVisibility(GONE);
        }
    }

    private void putEmail() {
        if (simpleBCard.getEmail() != null && simpleBCard.getEmail().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getEmail().getText()))
                simpleBCard.getEmail().setText(getResources().getString(R.string.your_email));
            if (evEmail == null) {
                evEmail = new ElemView(getContext());
                evEmail.setElem(simpleBCard.getEmail());
                vRoot.addView(evEmail, getLayoutParams(simpleBCard.getEmail()));
            } else
                evEmail.updateText(simpleBCard.getEmail().getText());
            evEmail.setVisibility(VISIBLE);
        } else {
            if (evEmail != null)
                evEmail.setVisibility(GONE);
        }
    }

    private void putPhoneNumber() {
        if (simpleBCard.getWhatsApp() != null && simpleBCard.getWhatsApp().getHeight() > 0) {
            SimpleElem whatsAppTemp = simpleBCard.getWhatsApp().clone();
            if (!TextUtils.isEmpty(whatsAppTemp.getText()) || !TextUtils.isEmpty(simpleBCard.getCountryCode()))
                whatsAppTemp.setText((!TextUtils.isEmpty(simpleBCard.getCountryCode()) ? simpleBCard.getCountryCode() : "") + (!TextUtils.isEmpty(simpleBCard.getWhatsApp().getText()) ? simpleBCard.getWhatsApp().getText() : ""));
            else
                whatsAppTemp.setText(getResources().getString(R.string.your_phone));
            if (evWhatsApp == null) {
                evWhatsApp = new ElemView(getContext());
                evWhatsApp.setElem(whatsAppTemp);
                vRoot.addView(evWhatsApp, getLayoutParams(simpleBCard.getWhatsApp()));
            } else
                evWhatsApp.updateText(whatsAppTemp.getText());
            evWhatsApp.setVisibility(VISIBLE);
        } else {
            if (evWhatsApp != null)
                evWhatsApp.setVisibility(GONE);
        }
    }

    private void putWorkPosition() {
        if (simpleBCard.getWorkPosition() != null && simpleBCard.getWorkPosition().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getWorkPosition().getText()))
                simpleBCard.getWorkPosition().setText(getResources().getString(R.string.your_work_position));
            if (evWorkPosition == null) {
                evWorkPosition = new ElemView(getContext());
                evWorkPosition.setElem(simpleBCard.getWorkPosition());
                vRoot.addView(evWorkPosition, getLayoutParams(simpleBCard.getWorkPosition()));
            } else
                evWorkPosition.updateText(simpleBCard.getWorkPosition().getText());
            evWorkPosition.setVisibility(VISIBLE);
        } else {
            if (evWorkPosition != null)
                evWorkPosition.setVisibility(GONE);
        }
    }

    private void putName() {
        if (simpleBCard.getName() != null && simpleBCard.getName().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getName().getText()))
                simpleBCard.getName().setText(getResources().getString(R.string.your_name));
            if (evName == null) {
                evName = new ElemView(getContext());
                evName.setElem(simpleBCard.getName());
                vRoot.addView(evName, getLayoutParams(simpleBCard.getName()));
            } else
                evName.updateText(simpleBCard.getName().getText());
            evName.setVisibility(VISIBLE);
        } else {
            if (evName != null)
                evName.setVisibility(GONE);
        }
    }

    private void putCompanyName() {
        if (simpleBCard.getCompanyName() != null && simpleBCard.getCompanyName().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getCompanyName().getText()))
                simpleBCard.getCompanyName().setText(getResources().getString(R.string.your_company));
            if (evCompany == null) {
                evCompany = new ElemView(getContext());
                vRoot.addView(evCompany, getLayoutParams(simpleBCard.getCompanyName()));
                evCompany.setElem(simpleBCard.getCompanyName());
            } else
                evCompany.updateText(simpleBCard.getCompanyName().getText());
            evCompany.setVisibility(VISIBLE);
        } else {
            if (evCompany != null)
                evCompany.setVisibility(GONE);
        }
    }

    private void putImage() {
        if (simpleBCard.getLogo() != null && simpleBCard.getLogo().getWidth() > 0 && simpleBCard.getLogo().getHeight() > 0) {
            if (ivLogo == null) {
                ivLogo = new ImageView(getContext());
                vRoot.addView(ivLogo, getLayoutParams(simpleBCard.getLogo()));
            }
            Glide.with(getContext()).load(simpleBCard.getLogo().getThumbnail()).override(ivLogo.getLayoutParams().width, ivLogo.getLayoutParams().height).fitCenter().into(ivLogo);
        }else if (ivLogo != null)
            Glide.with(getContext()).clear(ivLogo);
    }

    private void putBackground() {
        if(TextUtils.isEmpty(simpleBCard.getBackgroundImage())) {
            vRoot.setBackground(null);
            return;
        }
        if(URLUtil.isAssetUrl(simpleBCard.getBackgroundImage())){
            Glide.with(getContext()).asBitmap().load(Uri.parse(simpleBCard.getBackgroundImage())).into(new CustomTarget<Bitmap>() {
                @Override
                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                    vRoot.setBackground(new BitmapDrawable(getResources(), resource));
                }

                @Override
                public void onLoadFailed(@Nullable Drawable errorDrawable) {
                    super.onLoadFailed(errorDrawable);
                }

                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {
                }
            });
        }else{
            Glide.with(getContext()).load(simpleBCard.getBackgroundImage()).into(new CustomTarget<Drawable>() {
                @Override
                public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                    vRoot.setBackground(resource);
                }

                @Override
                public void onLoadFailed(@Nullable Drawable errorDrawable) {
                    super.onLoadFailed(errorDrawable);
                }

                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {
                }
            });
        }
    }

    public LayoutParams getLayoutParams(SimpleElem simpleElem) {
        LayoutParams layoutParams = new LayoutParams(simpleElem.getWidth() == 0 ?
                (widthCard - (int) (simpleElem.getxPosition() * widthCard) / 100) :
                (int) (simpleElem.getWidth() * widthCard) / 100, (int) (simpleElem.getHeight() * heightCard) / 100);
        layoutParams.leftMargin = (int) (simpleElem.getxPosition() * widthCard) / 100;
        layoutParams.topMargin = (int) (simpleElem.getyPosition() * heightCard) / 100;
        return layoutParams;
    }
}
