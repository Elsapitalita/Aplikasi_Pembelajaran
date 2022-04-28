package stud11418025.develops.aplikasipembelajaran.Students;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import stud11418025.develops.aplikasipembelajaran.PBO.Main;
import stud11418025.develops.aplikasipembelajaran.R;

public class PBOAdapter extends RecyclerView.Adapter<PBOAdapter.GridItemViewHolder> {
    private List<Main> gejalaList;

    private Context c;

    public class GridItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvgejala, tvdetail;
        Button btnEdit, btnDelete;

        public GridItemViewHolder(View view) {
            super(view);
            tvgejala = view.findViewById(R.id.tv_judul);
            tvdetail = view.findViewById(R.id.tv_gejala1);
        }
    }

    public PBOAdapter(Context c, List gejalaList) {
        this.c = c;
        this.gejalaList = gejalaList;
    }

    @Override
    public GridItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pbostud, parent, false);
        return new GridItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GridItemViewHolder holder, int position) {
        final Main gejala = gejalaList.get(position);

        holder.tvgejala.setText(gejala.getJudul());
        holder.tvgejala.append(" ");

        holder.tvdetail.setText(gejala.getDetail1());
    }

    @Override
    public int getItemCount() {
        return gejalaList.size();
    }

}
