package me.vdipalma.enzo.recyclerinpillole;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by enzo on 12/02/18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private final Context mContext;
    private ArrayList<OggettoStupido> mDataset;
    public RubricaItemClickedListener listener;

    public interface RubricaItemClickedListener {
        public void itemClicked(OggettoStupido oggettoStupido);
    }

    public CustomAdapter(Context context, ArrayList<OggettoStupido> dataset){
        this.mDataset = dataset;
        this.mContext = context;
        listener = (MainActivity)context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.nome.setText(mDataset.get(position).getNome());
        holder.cognome.setText(mDataset.get(position).getCognome());
        holder.numero.setText(""+mDataset.get(position).getNumero());
        holder.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClicked(mDataset.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        private View mView; //salvala per comodità, potrebbe servirti
        public TextView nome;
        public TextView cognome;
        public TextView numero;


        public CustomViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome);
            cognome = itemView.findViewById(R.id.cognome);
            numero = itemView.findViewById(R.id.numero);
            mView = itemView;
        }

        public View getmView(){
            return mView;
        }

        public void setListener(View.OnClickListener listener) {
            mView.setOnClickListener(listener);
        }

//        public void setOggettoStupido(OggettoStupido oggettoStupido){
//
//        }
    }
}
