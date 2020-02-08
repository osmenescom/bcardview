package com.asgeirr.businesscard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class BCardView extends LinearLayout implements View.OnClickListener {
    private SimpleBCard simpleBCard;
    private ImageView ivLogo;
    private CustomTextView ctvCompany, ctvName, ctvWorkPosition;
    private IconTextView itvWhatsApp, itvEmail, itvWebSite;
    private IconTextView itv1WhatsApp;
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
    public void onClick(View v) {

    }

    public void load(SimpleBCard simpleBCard){
        this.simpleBCard = simpleBCard;
        updateView();
    }

    private void updateView() {
        if(simpleBCard ==null)
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
        if(simpleBCard.getWebSite()==null || TextUtils.isEmpty(simpleBCard.getWebSite().getText())|| (simpleBCard.getWebSite().getWidth()==0 && simpleBCard.getWebSite().getHeight()==0))
            return;
        if(itvWebSite==null) {
            if(heightCard==0)
                return;
            itvWebSite = new IconTextView(getContext());
            itvWebSite.setElem(simpleBCard.getWebSite());
            LayoutParams layoutParams = getLayoutParams(simpleBCard.getWebSite());
            vRoot.addView(itvWebSite, layoutParams);
        }else
            itvWebSite.setText(simpleBCard.getWebSite().getText());
    }

    private void putEmail() {
        if(simpleBCard.getEmail()==null || (simpleBCard.getEmail().getWidth()==0 && simpleBCard.getEmail().getHeight()==0))
            return;
        if(itvEmail==null) {
            if(heightCard==0)
                return;
            itvEmail = new IconTextView(getContext());
            itvEmail.setElem(simpleBCard.getEmail());
            LayoutParams layoutParams = getLayoutParams(simpleBCard.getEmail());
            vRoot.addView(itvEmail, layoutParams);
        }else
            itvEmail.setText(simpleBCard.getEmail().getText());
    }

    private void putPhoneNumber() {
        if(heightCard==0 || simpleBCard.getWhatsApp()==null || (simpleBCard.getWhatsApp().getWidth()==0 && simpleBCard.getWhatsApp().getHeight()==0))
            return;
        if(itv1WhatsApp==null) {
            itv1WhatsApp = new IconTextView(getContext());
            itv1WhatsApp.setElem(simpleBCard.getWhatsApp());
            LayoutParams layoutParams = getLayoutParams(simpleBCard.getWhatsApp());
            vRoot.addView(itv1WhatsApp, layoutParams);
        }else{
            itv1WhatsApp.setText(simpleBCard.getWhatsApp().getText());
        }
    }

    private void putWorkPosition() {
        if(simpleBCard.getWorkPosition()==null || (simpleBCard.getWorkPosition().getWidth()==0 && simpleBCard.getWorkPosition().getHeight()==0))
            return;
        if(ctvWorkPosition==null) {
            if(heightCard==0)
                return;
            ctvWorkPosition = new CustomTextView(getContext());
            ctvWorkPosition.setElem(simpleBCard.getWorkPosition());
            LayoutParams layoutParams = getLayoutParams(simpleBCard.getWorkPosition());
            vRoot.addView(ctvWorkPosition, layoutParams);
        }else
            ctvWorkPosition.updateText(simpleBCard.getWorkPosition().getText());
    }

    private void putName() {
        if(simpleBCard.getName()==null || (simpleBCard.getName().getWidth()==0 && simpleBCard.getName().getHeight()==0))
            return;
        if(ctvName==null) {
            if(heightCard==0)
                return;
            ctvName = new CustomTextView(getContext());
            ctvName.setElem(simpleBCard.getName());
            LayoutParams layoutParams = getLayoutParams(simpleBCard.getName());
            vRoot.addView(ctvName, layoutParams);
        }else
            ctvName.updateText(simpleBCard.getName().getText());
    }

    private void putCompanyName() {
        if(simpleBCard.getCompanyName()==null || (simpleBCard.getCompanyName().getWidth()==0 && simpleBCard.getCompanyName().getHeight()==0))
            return;
        if(ctvCompany==null) {
            if(heightCard==0)
                return;
            ctvCompany = new CustomTextView(getContext());
            ctvCompany.setElem(simpleBCard.getCompanyName());
            LayoutParams layoutParams = getLayoutParams(simpleBCard.getCompanyName());
            vRoot.addView(ctvCompany, layoutParams);
        }else
            ctvCompany.updateText(simpleBCard.getCompanyName().getText());
    }

    private void putImage() {
        if(simpleBCard.getLogo()==null || (simpleBCard.getLogo().getWidth()==0 && simpleBCard.getLogo().getHeight()==0))
            return;
        if(ivLogo==null) {
            if(heightCard==0)
                return;
            ivLogo = new ImageView(getContext());
            LayoutParams layoutParams = getLayoutParams(simpleBCard.getLogo());
            vRoot.addView(ivLogo, layoutParams);
            Glide.with(getContext()).load(simpleBCard.getLogo().getThumbnail()).override(layoutParams.width, layoutParams.height).fitCenter().into(ivLogo);
        }else
            Glide.with(getContext()).load(simpleBCard.getLogo().getThumbnail()).override(ivLogo.getMeasuredWidth(), ivLogo.getMaxHeight()).fitCenter().into(ivLogo);
    }

    private void putBackground() {
        if(TextUtils.isEmpty(simpleBCard.getBackgroundImage()))
            return;
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
