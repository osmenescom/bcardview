package com.asgeirr.businesscard.example;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asgeirr.businesscard.BCardView;
import com.asgeirr.businesscard.SimpleBCard;

import java.util.ArrayList;
import java.util.List;

public class BCardAdapter extends RecyclerView.Adapter<BCardAdapter.BCardViewHolder> {


    List<SimpleBCard> list = new ArrayList<>();
    private BCardListener listener;

    public BCardAdapter(BCardListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public BCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BCardViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_simplebcard, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BCardViewHolder holder, int position) {
        holder.bindView(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(List<SimpleBCard> items) {
        list.addAll(items);
        notifyDataSetChanged();
    }

    public interface BCardListener {

        String getName();

        String getCompany();

        String getWorkPosition();

        String getWhatsApp();

        String getEmail();

        String getWebsite();

        String getLogo();
    }

    public class BCardViewHolder extends RecyclerView.ViewHolder {

        private BCardView bCardView;

        public BCardViewHolder(@NonNull View itemView) {
            super(itemView);
            bCardView = itemView.findViewById(R.id.BussinessCard_vBcard);
        }

        public void bindView(SimpleBCard simpleBCard) {
            fillSimpleBCard(simpleBCard);
            bCardView.load(simpleBCard);
        }

        private void fillSimpleBCard(SimpleBCard simpleBCard) {
            simpleBCard.getLogo().setThumbnail(listener.getLogo());
            simpleBCard.getName().setText(listener.getName());
//            simpleBCard.getCompanyName().setText(listener.getCompany());
            simpleBCard.getWorkPosition().setText(listener.getWorkPosition());
            simpleBCard.getWhatsApp().setText(listener.getWhatsApp());
            simpleBCard.getEmail().setText(listener.getEmail());
            simpleBCard.getWebSite().setText(listener.getWebsite());
        }

    }
}
