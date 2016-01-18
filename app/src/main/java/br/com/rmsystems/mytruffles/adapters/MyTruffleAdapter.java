package br.com.rmsystems.mytruffles.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.rmsystems.mytruffles.R;
import br.com.rmsystems.mytruffles.models.Truffle;
import br.com.rmsystems.mytruffles.utils.AppUtil;

public class MyTruffleAdapter extends RecyclerView.Adapter<MyTruffleAdapter.ViewHolder> {

    private List<Truffle> mItens;

    public MyTruffleAdapter(List<Truffle> itens) {
        mItens = itens;
    }

    public void setItens(List<Truffle> itens) {
        this.mItens = itens;
    }

    public List<Truffle> getItens() {
        return mItens;
    }

    private void trufflesRequests(Truffle truffle, Context context, ViewHolder holder, boolean add) {
        final int currentAmount = (truffle.getQuantity() != null) ? truffle.getQuantity() : 0;
        final int newAmount;

        if (add) {
            newAmount = currentAmount + 1;
            truffle.setQuantity(newAmount);
            holder.mTxtQuantity.setText((truffle.getQuantity() != null) ? context.getString(R.string.lbl_requesting) + " " + truffle.getQuantity() + " " + context.getString(R.string.lbl_truffle) : context.getString(R.string.lbl_requesting) + " 0 " + context.getString(R.string.lbl_truffle));
        } else {
            newAmount = currentAmount - 1;
            if (newAmount >= 0) {
                truffle.setQuantity(newAmount);
                holder.mTxtQuantity.setText((truffle.getQuantity() != null) ? context.getString(R.string.lbl_requesting) + " " + truffle.getQuantity() + " " + context.getString(R.string.lbl_truffle) : context.getString(R.string.lbl_requesting) + " 0 " + context.getString(R.string.lbl_truffle));
            }
        }
    }

    @Override
    public MyTruffleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.my_truffles_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Context context = holder.mTxtFlavor.getContext();
        final Truffle truffle = mItens.get(position);

        holder.mTxtFlavor.setText(context.getString(R.string.lbl_flavor) + " " + truffle.getFlavor());
        holder.mTxtFlavor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_toggle_star, 0, 0, 0);
        
        holder.mTxtValue.setText(context.getString(R.string.lbl_value) + " " + AppUtil.formatDecimal(truffle.getValue()));
        holder.mTxtValue.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_editor_attach_money, 0, 0, 0);
        
        holder.mTxtQuantity.setText((truffle.getQuantity() != null) ? context.getString(R.string.lbl_requesting) + truffle.getQuantity() + context.getString(R.string.lbl_truffle) : context.getString(R.string.lbl_requesting) + " 0 " + context.getString(R.string.lbl_truffle));
        holder.mTxtQuantity.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_action_quantity, 0, 0, 0);

        holder.mImgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trufflesRequests(truffle, context, holder, true);
            }
        });

        holder.mImgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trufflesRequests(truffle, context, holder, false);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItens.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImgTruffle;
        public TextView mTxtFlavor;
        public TextView mTxtValue;
        public TextView mTxtQuantity;
        public ImageView mImgAdd;
        public ImageView mImgRemove;

        public ViewHolder(View view) {
            super(view);
            mImgTruffle = AppUtil.get(view.findViewById(R.id.imageViewTruffle));
            mTxtFlavor = AppUtil.get(view.findViewById(R.id.textViewFlavor));
            mTxtValue = AppUtil.get(view.findViewById(R.id.textViewValue));
            mTxtQuantity = AppUtil.get(view.findViewById(R.id.textViewQuantity));
            mImgAdd = AppUtil.get(view.findViewById(R.id.imageViewAdd));
            mImgRemove = AppUtil.get(view.findViewById(R.id.imageViewRemove));
        }

    }

}
