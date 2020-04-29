package com.asgeirr.businesscard.example;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.asgeirr.businesscard.BCardBuilder;
import com.asgeirr.businesscard.BCardView;
import com.asgeirr.businesscard.ElemBuilder;
import com.asgeirr.businesscard.SimpleBCard;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BCardAdapter.BCardListener, TextWatcher {

    private BCardView bCardView1, bCardView2, bCardView3, bCardView4, bCardView5;
    private boolean hideWebsite;
    private ViewPager2 rvList;
    private BCardAdapter adapter;
    private List<SimpleBCard> list = new ArrayList<>();
    private TextInputEditText tieName, tieWorkPosition, tieWhatsApp, tieEmail, tieWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvList = findViewById(R.id.Main_rvList);
        tieName = findViewById(R.id.Main_tieName);
        tieWorkPosition = findViewById(R.id.Main_tieWorkPosition);
        tieWhatsApp = findViewById(R.id.Main_tieWhatsApp);
        tieEmail = findViewById(R.id.Main_tieEmail);
        tieWebsite = findViewById(R.id.Main_tieWebsite);
        tieName.setText("Rowena Revanclaw");
        tieWorkPosition.setText("Agente inmobiliario");
        tieWhatsApp.setText("5554121666");
        tieEmail.setText("rowe.rav@gmail.com");
        tieWebsite.setText("www.ravenclaw.com");
        tieName.addTextChangedListener(this);
        tieWorkPosition.addTextChangedListener(this);
        tieWhatsApp.addTextChangedListener(this);
        tieEmail.addTextChangedListener(this);
        tieWebsite.addTextChangedListener(this);

        adapter = new BCardAdapter(this);
        fillList();
        rvList.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        rvList.setOffscreenPageLimit(5);
        rvList.setAdapter(adapter);
        final float pageMargin = getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        final float pageOffset = getResources().getDimensionPixelOffset(R.dimen.offset);
        rvList.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myOffset = position * -(2 * pageOffset + pageMargin);
                if (rvList.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(rvList) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.setTranslationX(-myOffset);
                    } else {
                        page.setTranslationX(myOffset);
                    }
                } else {
                    page.setTranslationY(myOffset);
                }
            }
        });
        adapter.addAll(list);
//        bCardView1=findViewById(R.id.Main_BCard1);
//        bCardView2=findViewById(R.id.Main_BCard2);
//        bCardView3=findViewById(R.id.Main_BCard3);
//        bCardView4=findViewById(R.id.Main_BCard4);
//        bCardView5=findViewById(R.id.Main_BCard5);
//        bCardView1.load(createDummyBCard1());
//        bCardView2.load(createDummyBCard2());
//        bCardView3.load(createDummyBCard3());
//        bCardView4.load(createDummyBCard4());
//        bCardView5.load(createDummyBCard5());
    }

    private void fillList() {
        list.add(createDummyBCard1());
        list.add(createDummyBCard2());
//        list.add(createDummyBCard3());
        list.add(createDummyBCard4());
        list.add(createDummyBCard5());
    }

    private SimpleBCard createDummyBCard1(){
        SimpleBCard simpleBCard = new BCardBuilder()
                .setCardThumbnail("1")
                .setCountryCode("52")
                .setLogo(new ElemBuilder()
                    .setWidth(19.96f)
                    .setHeight(35.97f)
                    .setxPosition(11.57f)
                    .setyPosition(32.37f)
                    .createElem())
                .setName(new ElemBuilder()
                        .setHeight(11.51f)
                        .setxPosition(41.71f)
                        .setyPosition(23.02f)
                        .setColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWorkPosition(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.71f)
                        .setyPosition(34.53f)
                        .setColor("707070")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.71f)
                        .setyPosition(58.27f)
                        .setColor("707070")
                        .setIconType(1)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setEmail(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.71f)
                        .setyPosition(68.70f)
                        .setColor("707070")
                        .setIconType(2)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWebSite(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.71f)
                        .setyPosition(79.85f)
                        .setColor("707070")
                        .setIconType(3)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .createBCard();
        return simpleBCard;
    }

    private SimpleBCard createDummyBCard2(){
        SimpleBCard simpleBCard = new BCardBuilder()
                .setCardThumbnail("2")
                .setCountryCode("52")
                .setLogo(new ElemBuilder()
                    .setWidth(19.96f)
                    .setHeight(35.97f)
                    .setxPosition(7.98f)
                    .setyPosition(8.27f)
                    .createElem())
                .setName(new ElemBuilder()
                        .setHeight(11.51f)
                        .setxPosition(33.53f)
                        .setyPosition(25.17f)
                        .setColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWorkPosition(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(33.53f)
                        .setyPosition(36.69f)
                        .setColor("707070")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(9.38f)
                        .setyPosition(59.71f)
                        .setColor("707070")
                        .setIconType(1)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setEmail(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(9.38f)
                        .setyPosition(69.06f)
                        .setColor("707070")
                        .setIconType(2)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWebSite(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(9.38f)
                        .setyPosition(78.41f)
                        .setColor("707070")
                        .setIconType(3)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .createBCard();
        return simpleBCard;
    }

    private SimpleBCard createDummyBCard3(){
        SimpleBCard simpleBCard = new BCardBuilder()
                .setCountryCode("52")
                .setLogo(new ElemBuilder()
                        .setWidth(19.96f)
                        .setHeight(35.97f)
                        .setxPosition(40.11f)
                        .setyPosition(12.58f)
                        .setThumbnail("https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5d137e105cafe826be509e41/buho0.jpg")
                        .createElem())
                .setName(new ElemBuilder()
                        .setText("Rowena Revanclaw")
                        .setHeight(10.07f)
                        .setxPosition(7.18f)
                        .setyPosition(57.55f)
                        .setColor("FFFFFF")
                        .setFont("7")
                        .createElem())
                .setWorkPosition(new ElemBuilder()
                        .setText("Agente inmobiliario")
                        .setHeight(7.55f)
                        .setxPosition(51.49f)
                        .setyPosition(59.35f)
                        .setColor("FFFFFF")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new ElemBuilder()
                        .setText("5554121666")
                        .setHeight(7.19f)
                        .setxPosition(7.18f)
                        .setyPosition(71.58f)
                        .setColor("707070")
                        .setIconType(1)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setEmail(new ElemBuilder()
                        .setText("rowe.rav@gmail.com")
                        .setHeight(7.19f)
                        .setxPosition(7.18f)
                        .setyPosition(80.93f)
                        .setColor("707070")
                        .setIconType(2)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWebSite(new ElemBuilder()
                        .setText("www.ravenclaw.com")
                        .setHeight(7.19f)//
                        .setxPosition(7.18f)
                        .setyPosition(90.28f)
                        .setColor("707070")
                        .setIconType(3)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setBackgroundImage("file:///android_asset/bg_card1.png")
                .createBCard();
        return simpleBCard;
    }

    private SimpleBCard createDummyBCard4(){
        SimpleBCard simpleBCard = new BCardBuilder()
                .setCardThumbnail("3")
                .setCountryCode("52")
                .setLogo(new ElemBuilder()
                        .setWidth(13.77f)
                        .setHeight(24.82f)
                        .setxPosition(82.03f)
                        .setyPosition(6.83f)
                        .createElem())
                .setName(new ElemBuilder()
                        .setHeight(11.51f)
                        .setxPosition(9.78f)
                        .setyPosition(33.09f)
                        .setColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWorkPosition(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(9.78f)
                        .setyPosition(44.24f)
                        .setColor("707070")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new ElemBuilder()
                        .setHeight(7.19f)
                        .setxPosition(9.58f)
                        .setyPosition(74.1f)
                        .setColor("707070")
                        .setIconType(1)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setEmail(new ElemBuilder()
                        .setHeight(7.19f)
                        .setxPosition(9.58f)
                        .setyPosition(82.73f)
                        .setColor("707070")
                        .setIconType(2)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWebSite(new ElemBuilder()
                        .setHeight(7.19f)
                        .setxPosition(9.58f)
                        .setyPosition(90.64f)
                        .setColor("707070")
                        .setIconType(3)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setBackgroundImage("file:///android_asset/bg_card2.png")
                .createBCard();
        return simpleBCard;
    }

    private SimpleBCard createDummyBCard5(){
        SimpleBCard simpleBCard = new BCardBuilder()
                .setCardThumbnail("4")
                .setCountryCode("52")
                .setLogo(new ElemBuilder()
                        .setWidth(13.77f)
                        .setHeight(24.82f)
                        .setxPosition(11.57f)
                        .setyPosition(32.37f)
                        .createElem())
                .setName(new ElemBuilder()
                        .setHeight(11.51f)
                        .setxPosition(41.91f)
                        .setyPosition(19.42f)
                        .setColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWorkPosition(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.91f)
                        .setyPosition(30.93f)
                        .setColor("707070")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.91f)
                        .setyPosition(54.67f)
                        .setColor("707070")
                        .setIconType(1)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setEmail(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.91f)
                        .setyPosition(65.1f)
                        .setColor("707070")
                        .setIconType(2)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWebSite(new ElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.91f)
                        .setyPosition(76.25f)
                        .setColor("707070")
                        .setIconType(3)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setBackgroundImage("file:///android_asset/bg_card3.png")
                .createBCard();
        return simpleBCard;
    }

    public static <T>String toJson(T object){
        return object == null ? null: new GsonBuilder().create().toJson(object, object.getClass());
    }

    public static <T>T toObject(String json, Class clazz){
        return json == null ? null: (T) new GsonBuilder().create().fromJson(json, clazz);
    }

    @Override
    public String getName() {
        return tieName.getText().toString();
    }

    @Override
    public String getCompany() {
        return "Hogwards";
    }

    @Override
    public String getWorkPosition() {
        return tieWorkPosition.getText().toString();
    }

    @Override
    public String getWhatsApp() {
        return tieWhatsApp.getText().toString();
    }

    @Override
    public String getEmail() {
        return tieEmail.getText().toString();
    }

    @Override
    public String getWebsite() {
        return tieWebsite.getText().toString();
    }

    @Override
    public String getLogo() {
        return "https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5d137e105cafe826be509e41/buho0.jpg";
    }

    public void onClick(View view) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s == null)
            return;
        adapter.notifyDataSetChanged();
    }

//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.Main_btnChange:
//                SimpleBCard simpleBCard =createDummyBCard1();
//                simpleBCard.setBackgroundImage("");
//                simpleBCard.getName().setText("Oscar");
//                simpleBCard.getWorkPosition().setText("Prueba");
//                simpleBCard.setCountryCode("230");
//                simpleBCard.getWhatsApp().setText("56748593");
//                simpleBCard.getEmail().setText("osmenescom@gmail.com");
//                simpleBCard.getWebSite().setText("www.google.com.mx");
//                if(hideWebsite) {
//                    hideWebsite=false;
//                    simpleBCard.getWebSite().setHeight(0);
//                }else
//                    hideWebsite=true;
//                bCardView1.load(simpleBCard);
//                bCardView2.load(simpleBCard);
//                bCardView3.load(simpleBCard);
//                bCardView4.load(simpleBCard);
//                bCardView5.load(simpleBCard);
//                break;
//        }
//    }
}
