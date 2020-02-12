package com.asgeirr.businesscard;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.asgeirr.businesscard.bcard.R;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    private BCardView bCardView1, bCardView2, bCardView3, bCardView4, bCardView5;
    private boolean hideWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.asgeirr.businesscard.bcard.R.layout.activity_main);
        bCardView1=findViewById(R.id.Main_BCard1);
        bCardView2=findViewById(R.id.Main_BCard2);
        bCardView3=findViewById(R.id.Main_BCard3);
        bCardView4=findViewById(R.id.Main_BCard4);
        bCardView5=findViewById(R.id.Main_BCard5);
        bCardView1.load(createDummyBCard1());
        bCardView2.load(createDummyBCard2());
        bCardView3.load(createDummyBCard3());
        bCardView4.load(createDummyBCard4());
        bCardView5.load(createDummyBCard5());
    }

    private SimpleBCard createDummyBCard1(){
        SimpleBCard simpleBCard = new BCardBuilder()
                .setLogo(new ElemBuilder()
                    .setWidth(19.96f)
                    .setHeight(35.97f)
                    .setxPosition(11.57f)
                    .setyPosition(32.37f)
                    .setThumbnail("https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5d137e105cafe826be509e41/buho0.jpg")
                    .createElem())
                .setName(new ElemBuilder()
                        .setText("Rowena Revanclaw")
//                        .setWidth(50.89f)
                        .setHeight(11.51f)
                        .setxPosition(41.71f)
                        .setyPosition(23.02f)
                        .setColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWorkPosition(new ElemBuilder()
                        .setText("Agente inmobiliario")
//                        .setWidth(50.89f)
                        .setHeight(7.55f)
                        .setxPosition(41.71f)
                        .setyPosition(34.53f)
                        .setColor("707070")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new ElemBuilder()
                        .setText("5554121666")
//                        .setWidth(50.89f)
                        .setHeight(7.55f)
                        .setxPosition(41.71f)
                        .setyPosition(58.27f)
                        .setColor("707070")
                        .setIconType(1)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setEmail(new ElemBuilder()
                        .setText("rowe.rav@gmail.com")
//                        .setWidth(50.89f)
                        .setHeight(7.55f)
                        .setxPosition(41.71f)
                        .setyPosition(68.70f)
                        .setColor("707070")
                        .setIconType(2)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWebSite(new ElemBuilder()
                        .setText("www.ravenclaw.com")
//                        .setWidth(50.89f)
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
                .setLogo(new ElemBuilder()
                    .setWidth(19.96f)
                    .setHeight(35.97f)
                    .setxPosition(7.98f)
                    .setyPosition(8.27f)
                    .setThumbnail("https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5d137e105cafe826be509e41/buho0.jpg")
                    .createElem())
                .setName(new ElemBuilder()
                        .setText("Rowena Revanclaw")
//                        .setWidth(60.27f)
                        .setHeight(11.51f)
                        .setxPosition(33.53f)
                        .setyPosition(25.17f)
                        .setColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWorkPosition(new ElemBuilder()
                        .setText("Agente inmobiliario")
//                        .setWidth(60.27f)
                        .setHeight(7.55f)
                        .setxPosition(33.53f)
                        .setyPosition(36.69f)
                        .setColor("707070")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new ElemBuilder()
                        .setText("5554121666")
//                        .setWidth(84.43f)
                        .setHeight(7.55f)
                        .setxPosition(9.38f)
                        .setyPosition(59.71f)
                        .setColor("707070")
                        .setIconType(1)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setEmail(new ElemBuilder()
                        .setText("rowe.rav@gmail.com")
//                        .setWidth(84.43f)
                        .setHeight(7.55f)
                        .setxPosition(9.38f)
                        .setyPosition(69.06f)
                        .setColor("707070")
                        .setIconType(2)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWebSite(new ElemBuilder()
                        .setText("www.ravenclaw.com")
//                        .setWidth(84.43f)
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
                .setLogo(new ElemBuilder()
                        .setWidth(19.96f)
                        .setHeight(35.97f)
                        .setxPosition(40.11f)
                        .setyPosition(12.58f)
                        .setThumbnail("https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5d137e105cafe826be509e41/buho0.jpg")
                        .createElem())
                .setName(new ElemBuilder()
                        .setText("Rowena Revanclaw")
                        .setWidth(41.11f)
                        .setHeight(10.07f)
                        .setxPosition(7.18f)
                        .setyPosition(57.55f)
                        .setColor("FFFFFF")
                        .setFont("7")
                        .createElem())
                .setWorkPosition(new ElemBuilder()
                        .setText("Agente inmobiliario")
                        .setWidth(46.3f)
                        .setHeight(7.55f)
                        .setxPosition(51.49f)
                        .setyPosition(59.35f)
                        .setColor("FFFFFF")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new ElemBuilder()
                        .setText("5554121666")
                        .setWidth(38.72f)
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
                        .setWidth(38.72f)
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
//                        .setWidth(38.72f)
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
                .setLogo(new ElemBuilder()
                        .setWidth(13.77f)
                        .setHeight(24.82f)
                        .setxPosition(82.03f)
                        .setyPosition(6.83f)
                        .setThumbnail("https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5d137e105cafe826be509e41/buho0.jpg")
                        .createElem())
                .setName(new ElemBuilder()
                        .setText("Rowena Revanclaw")
                        .setWidth(57.48f)
                        .setHeight(11.51f)
                        .setxPosition(9.78f)
                        .setyPosition(33.09f)
                        .setColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWorkPosition(new ElemBuilder()
                        .setText("Agente inmobiliario")
                        .setWidth(46.3f)
                        .setHeight(7.55f)
                        .setxPosition(9.78f)
                        .setyPosition(44.24f)
                        .setColor("707070")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new ElemBuilder()
                        .setText("5554121666")
                        .setWidth(50.89f)
                        .setHeight(7.19f)
                        .setxPosition(9.58f)
                        .setyPosition(74.1f)
                        .setColor("707070")
                        .setIconType(1)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setEmail(new ElemBuilder()
                        .setText("rowe.rav@gmail.com")
                        .setWidth(50.89f)
                        .setHeight(7.19f)
                        .setxPosition(9.58f)
                        .setyPosition(82.73f)
                        .setColor("707070")
                        .setIconType(2)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWebSite(new ElemBuilder()
                        .setText("www.ravenclaw.com")
//                        .setWidth(50.89f)
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
                .setLogo(new ElemBuilder()
                        .setWidth(13.77f)
                        .setHeight(24.82f)
                        .setxPosition(11.57f)
                        .setyPosition(32.37f)
                        .setThumbnail("https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5d137e105cafe826be509e41/buho0.jpg")
                        .createElem())
                .setName(new ElemBuilder()
                        .setText("Rowena Revanclaw")
                        .setWidth(50.89f)
                        .setHeight(11.51f)
                        .setxPosition(41.91f)
                        .setyPosition(19.42f)
                        .setColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWorkPosition(new ElemBuilder()
                        .setText("Agente inmobiliario")
                        .setWidth(50.89f)
                        .setHeight(7.55f)
                        .setxPosition(41.91f)
                        .setyPosition(30.93f)
                        .setColor("707070")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new ElemBuilder()
                        .setText("5554121666")
                        .setWidth(50.89f)
                        .setHeight(7.55f)
                        .setxPosition(41.91f)
                        .setyPosition(54.67f)
                        .setColor("707070")
                        .setIconType(1)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setEmail(new ElemBuilder()
                        .setText("rowe.rav@gmail.com")
                        .setWidth(50.89f)
                        .setHeight(7.55f)
                        .setxPosition(41.91f)
                        .setyPosition(65.1f)
                        .setColor("707070")
                        .setIconType(2)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWebSite(new ElemBuilder()
                        .setText("www.ravenclaw.com")
//                        .setWidth(50.89f)
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

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Main_btnChange:
                SimpleBCard simpleBCard =createDummyBCard1();
                simpleBCard.getName().setText("Oscar");
                simpleBCard.getWorkPosition().setText("Prueba");
                simpleBCard.getWhatsApp().setText("525554121666525554121666");
                simpleBCard.getEmail().setText("osmenescom@gmail.com");
                simpleBCard.getWebSite().setText("www.google.com.mx");
                if(hideWebsite) {
                    hideWebsite=false;
                    simpleBCard.getWebSite().setHeight(0);
                }else
                    hideWebsite=true;
                bCardView1.load(simpleBCard);
                bCardView2.load(simpleBCard);
                bCardView3.load(simpleBCard);
                bCardView4.load(simpleBCard);
                bCardView5.load(simpleBCard);
                break;
        }
    }
}
