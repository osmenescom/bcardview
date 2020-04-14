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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class BCardView extends LinearLayout implements View.OnClickListener {
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
        if(widthCard==0 || heightCard==0 || simpleBCard ==null)
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
        if(simpleBCard.getWebSite()==null)
            return;
        if(itvWebSite==null) {
            itvWebSite = new IconTextView(getContext());
            itvWebSite.setElem(simpleBCard.getWebSite());
            LayoutParams layoutParams = getLayoutParams(simpleBCard.getWebSite());
            vRoot.addView(itvWebSite, layoutParams);
        }else
            itvWebSite.setText(simpleBCard.getWebSite().getText());
        if(simpleBCard.getWebSite().getHeight()!=0 && itvWebSite.getLayoutParams().height==0){
            updateLayoutParams(itvWebSite, simpleBCard.getWebSite());
        }
        itvWebSite.setVisibility(simpleBCard.getWebSite().getHeight()==0?GONE:VISIBLE);
    }

    private void updateLayoutParams(View view, Elem elem) {
        LinearLayout.LayoutParams layoutParamsTemp=getLayoutParams(elem);
        RelativeLayout.LayoutParams layoutParamsView= (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParamsView.height=layoutParamsTemp.height;
        layoutParamsView.width=layoutParamsTemp.width;
        layoutParamsView.topMargin=layoutParamsTemp.topMargin;
        layoutParamsView.leftMargin=layoutParamsTemp.leftMargin;
    }

    private void putEmail() {
        if(simpleBCard.getEmail()==null)
            return;
        Elem emailTemp=simpleBCard.getEmail().clone();
        if(TextUtils.isEmpty(emailTemp.getText()))
            emailTemp.setText(getResources().getString(R.string.your_email));
        if(itvEmail==null) {
            if(heightCard==0)
                return;
            itvEmail = new IconTextView(getContext());
            itvEmail.setElem(emailTemp);
            LayoutParams layoutParams = getLayoutParams(emailTemp);
            vRoot.addView(itvEmail, layoutParams);
        }else
            itvEmail.setText(emailTemp.getText());
        itvEmail.setVisibility(emailTemp.getHeight()==0?GONE:VISIBLE);
    }

    private void putPhoneNumber() {
        if(heightCard==0 || simpleBCard.getWhatsApp()==null)
            return;
        Elem whatsAppTemp=simpleBCard.getWhatsApp().clone();
        if(!TextUtils.isEmpty(whatsAppTemp.getText()) || !TextUtils.isEmpty(simpleBCard.getCountryCode()))
            whatsAppTemp.setText((!TextUtils.isEmpty(simpleBCard.getCountryCode())?simpleBCard.getCountryCode():"")+(!TextUtils.isEmpty(simpleBCard.getWhatsApp().getText())?simpleBCard.getWhatsApp().getText():""));
        else
            whatsAppTemp.setText(getResources().getString(R.string.your_phone));
        if(itvWhatsApp ==null) {
            itvWhatsApp = new IconTextView(getContext());
            itvWhatsApp.setElem(whatsAppTemp);
            LayoutParams layoutParams = getLayoutParams(simpleBCard.getWhatsApp());
            vRoot.addView(itvWhatsApp, layoutParams);
        }else{
            itvWhatsApp.setText(whatsAppTemp.getText());
        }
        itvWhatsApp.setVisibility(simpleBCard.getWhatsApp().getHeight()==0?GONE:VISIBLE);
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
        if(simpleBCard.getLogo()==null || (simpleBCard.getLogo().getWidth()==0 && simpleBCard.getLogo().getHeight()==0)) {
            if(ivLogo!=null)
                Glide.with(getContext()).clear(ivLogo);
            return;
        }
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
