package com.asgeirr.businesscard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
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

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class BCardView extends RelativeLayout implements View.OnClickListener {
    private SimpleBCard simpleBCard;
    private ImageView ivLogo;
    private CustomTextView ctvCompany, ctvName, ctvWorkPosition;
    private IconTextView itvWhatsApp, itvEmail, itvWebSite;
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
        if (simpleBCard == null || widthCard == 0 || heightCard == 0)
            return;
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
            if (itvWebSite == null) {
                itvWebSite = new IconTextView(getContext());
                itvWebSite.setElem(simpleBCard.getWebSite());
                vRoot.addView(itvWebSite, getLayoutParams(simpleBCard.getWebSite()));
            } else
                itvWebSite.updateText(simpleBCard.getWebSite().getText());
            itvWebSite.setVisibility(VISIBLE);
        } else {
            if (itvWebSite != null)
                itvWebSite.setVisibility(GONE);
        }
    }

    private void putEmail() {
        if (simpleBCard.getEmail() != null && simpleBCard.getEmail().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getEmail().getText()))
                simpleBCard.getEmail().setText(getResources().getString(R.string.your_email));
            if (itvEmail == null) {
                itvEmail = new IconTextView(getContext());
                itvEmail.setElem(simpleBCard.getEmail());
                vRoot.addView(itvEmail, getLayoutParams(simpleBCard.getEmail()));
            } else
                itvEmail.updateText(simpleBCard.getEmail().getText());
            itvEmail.setVisibility(VISIBLE);
        } else {
            if (itvEmail != null)
                itvEmail.setVisibility(GONE);
        }
    }

    private void putPhoneNumber() {
        if (simpleBCard.getWhatsApp() != null && simpleBCard.getWhatsApp().getHeight() > 0) {
            Elem whatsAppTemp = simpleBCard.getWhatsApp().clone();
            if (!TextUtils.isEmpty(whatsAppTemp.getText()) || !TextUtils.isEmpty(simpleBCard.getCountryCode()))
                whatsAppTemp.setText((!TextUtils.isEmpty(simpleBCard.getCountryCode()) ? simpleBCard.getCountryCode() : "") + (!TextUtils.isEmpty(simpleBCard.getWhatsApp().getText()) ? simpleBCard.getWhatsApp().getText() : ""));
            else
                whatsAppTemp.setText(getResources().getString(R.string.your_phone));
            if (itvWhatsApp == null) {
                itvWhatsApp = new IconTextView(getContext());
                itvWhatsApp.setElem(whatsAppTemp);
                vRoot.addView(itvWhatsApp, getLayoutParams(simpleBCard.getWhatsApp()));
            } else
                itvWhatsApp.updateText((!TextUtils.isEmpty(simpleBCard.getCountryCode()) ? simpleBCard.getCountryCode() : "") + (!TextUtils.isEmpty(simpleBCard.getWhatsApp().getText()) ? simpleBCard.getWhatsApp().getText() : ""));
            itvWhatsApp.setVisibility(VISIBLE);
        } else {
            if (itvWhatsApp != null)
                itvWhatsApp.setVisibility(GONE);
        }
    }

    private void putWorkPosition() {
        if (simpleBCard.getWorkPosition() != null && simpleBCard.getWorkPosition().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getWorkPosition().getText()))
                simpleBCard.getWorkPosition().setText(getResources().getString(R.string.your_work_position));
            if (ctvWorkPosition == null) {
                ctvWorkPosition = new CustomTextView(getContext());
                ctvWorkPosition.setElem(simpleBCard.getWorkPosition());
                vRoot.addView(ctvWorkPosition, getLayoutParams(simpleBCard.getWorkPosition()));
            } else
                ctvWorkPosition.updateText(simpleBCard.getWorkPosition().getText());
            ctvWorkPosition.setVisibility(VISIBLE);
        } else {
            if (ctvWorkPosition != null)
                ctvWorkPosition.setVisibility(GONE);
        }
    }

    private void putName() {
        if (simpleBCard.getName() != null && simpleBCard.getName().getHeight() > 0) {
            if (TextUtils.isEmpty(simpleBCard.getName().getText()))
                simpleBCard.getName().setText(getResources().getString(R.string.your_name));
            if (ctvName == null) {
                ctvName = new CustomTextView(getContext());
                ctvName.setElem(simpleBCard.getName());
                vRoot.addView(ctvName, getLayoutParams(simpleBCard.getName()));
            } else
                ctvName.updateText(simpleBCard.getName().getText());
            ctvName.setVisibility(VISIBLE);
        } else {
            if (ctvName != null)
                ctvName.setVisibility(GONE);
        }
    }

    private void putCompanyName() {
        if (simpleBCard.getCompanyName() != null && simpleBCard.getCompanyName().getHeight() > 0) {
            ctvCompany.setVisibility(VISIBLE);
            if (TextUtils.isEmpty(simpleBCard.getCompanyName().getText()))
                simpleBCard.getCompanyName().setText(getResources().getString(R.string.your_company));
            if (ctvCompany == null) {
                ctvCompany = new CustomTextView(getContext());
                vRoot.addView(ctvCompany, getLayoutParams(simpleBCard.getCompanyName()));
                ctvCompany.setElem(simpleBCard.getCompanyName());
            } else
                ctvCompany.updateText(simpleBCard.getCompanyName().getText());
            ctvCompany.setVisibility(VISIBLE);
        } else {
            if (ctvCompany != null)
                ctvCompany.setVisibility(GONE);
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

    public LayoutParams getLayoutParams(Elem elem){
        LayoutParams layoutParams= new LayoutParams(elem.getWidth()==0? WRAP_CONTENT:(int)(elem.getWidth()*widthCard)/ 100, (int)(elem.getHeight()*heightCard)/100);
        layoutParams.leftMargin=(int)(elem.getxPosition()*widthCard)/100;
        layoutParams.topMargin=(int)(elem.getyPosition()*heightCard)/100;
        return layoutParams;
    }
}
