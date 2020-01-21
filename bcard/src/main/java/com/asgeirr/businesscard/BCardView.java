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
    private BCard bCard;
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

    public void load(BCard bCard){
        this.bCard=bCard;
        updateView();
    }

    private void updateView() {
        if(bCard==null)
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
        if(bCard.getWebSite()==null || TextUtils.isEmpty(bCard.getWebSite().getText())|| (bCard.getWebSite().getWidth()==0 && bCard.getWebSite().getHeight()==0))
            return;
        itvWebSite =new IconTextView(getContext());
        itvWebSite.setElem(bCard.getWebSite());
        LayoutParams layoutParams=getLayoutParams(bCard.getWebSite());
        vRoot.addView(itvWebSite, layoutParams);
    }

    private void putEmail() {
        if(bCard.getEmail()==null || (bCard.getEmail().getWidth()==0 && bCard.getEmail().getHeight()==0))
            return;
        itvEmail =new IconTextView(getContext());
        itvEmail.setElem(bCard.getEmail());
        LayoutParams layoutParams=getLayoutParams(bCard.getEmail());
        vRoot.addView(itvEmail, layoutParams);
    }

    private void putPhoneNumber() {
        if(bCard.getWhatsApp()==null || (bCard.getWhatsApp().getWidth()==0 && bCard.getWhatsApp().getHeight()==0))
            return;
        itvWhatsApp =new IconTextView(getContext());
        itvWhatsApp.setElem(bCard.getWhatsApp());
        LayoutParams layoutParams=getLayoutParams(bCard.getWhatsApp());
        vRoot.addView(itvWhatsApp, layoutParams);
    }

    private void putWorkPosition() {
        if(bCard.getWorkPosition()==null || (bCard.getWorkPosition().getWidth()==0 && bCard.getWorkPosition().getHeight()==0))
            return;
        ctvWorkPosition=new CustomTextView(getContext());
        ctvWorkPosition.setElem(bCard.getWorkPosition());
        LayoutParams layoutParams=getLayoutParams(bCard.getWorkPosition());
        vRoot.addView(ctvWorkPosition, layoutParams);
    }

    private void putName() {
        if(bCard.getName()==null || (bCard.getName().getWidth()==0 && bCard.getName().getHeight()==0))
            return;
        ctvName=new CustomTextView(getContext());
        ctvName.setElem(bCard.getName());
        LayoutParams layoutParams=getLayoutParams(bCard.getName());
        vRoot.addView(ctvName, layoutParams);
    }

    private void putCompanyName() {
        if(bCard.getCompanyName()==null || (bCard.getCompanyName().getWidth()==0 && bCard.getCompanyName().getHeight()==0))
            return;
        ctvCompany=new CustomTextView(getContext());
        ctvCompany.setElem(bCard.getCompanyName());
        LayoutParams layoutParams=getLayoutParams(bCard.getCompanyName());
        vRoot.addView(ctvCompany, layoutParams) ;
    }

    private void putImage() {
        if(bCard.getLogo()==null || (bCard.getLogo().getWidth()==0 && bCard.getLogo().getHeight()==0))
            return;
        ivLogo=new ImageView(getContext());
        LayoutParams layoutParams= getLayoutParams(bCard.getLogo());
        vRoot.addView(ivLogo, layoutParams);
//        Glide.with(getContext()).load(new ColorDrawable(getResources().getColor(R.textColor.blue_text))).override(layoutParams.width, layoutParams.height).into(ivLogo);
        Glide.with(getContext()).load(bCard.getLogo().getThumbnail()).override(layoutParams.width, layoutParams.height).fitCenter().into(ivLogo);
    }

    private void putBackground() {
        if(TextUtils.isEmpty(bCard.getBackgroundImage()))
            return;
        if(URLUtil.isAssetUrl(bCard.getBackgroundImage())){

            Glide.with(getContext()).asBitmap().load(Uri.parse(bCard.getBackgroundImage())).into(new CustomTarget<Bitmap>() {
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

            Glide.with(getContext()).load(bCard.getBackgroundImage()).into(new CustomTarget<Drawable>() {
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
