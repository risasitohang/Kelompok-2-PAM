package s.develops.asalma_pam_02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import s.develops.asalma_pam_02.R;
import s.develops.asalma_pam_02.entity.EInformasi;


public class InformasiAdapter extends RecyclerView.Adapter<InformasiAdapter.InformasiHolder> {

    private final LayoutInflater mInflater;

    private List<EInformasi> mInformasi;

    public InformasiAdapter(Context context, List<EInformasi> mInformasi){
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public InformasiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recycleview_informasi, parent, false);
        return new InformasiHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InformasiHolder holder, int position) {
       if (mInformasi!=null){
           EInformasi current = mInformasi.get(position);
           holder.judul.setText(current.getJudul());
       }else{
           holder.judul.setText("Tidak ada informasi");
       }
    }

    @Override
    public int getItemCount() {
        if (mInformasi!=null)
            return mInformasi.size();
        else
            return 0;
    }

    public void setInformasi(List<EInformasi> Informasi){
        mInformasi = Informasi;
        notifyDataSetChanged();
    }

    class InformasiHolder extends RecyclerView.ViewHolder{
        private final TextView judul;

        private InformasiHolder(View itemView){
            super(itemView);
            judul = itemView.findViewById(R.id.judul);
        }
    }
}
