package stud11418025.develops.aplikasipembelajaran.PBO;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.List;

import stud11418025.develops.aplikasipembelajaran.R;

class PBOAdapter extends RecyclerView.Adapter<PBOAdapter.GridItemViewHolder> {
    private List<Main> PBOList;

    private Context c;

    public class GridItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvgejala, tvdetail;
        Button btnEdit, btnDelete;

        public GridItemViewHolder(View view) {
            super(view);
            tvgejala = view.findViewById(R.id.tv_judul);
            tvdetail = view.findViewById(R.id.tv_gejala1);
            btnEdit = view.findViewById(R.id.btn_edit);
            btnDelete = view.findViewById(R.id.btn_delete);
        }
    }

    public PBOAdapter(Context c, List PBOList) {
        this.c = c;
        this.PBOList = PBOList;
    }

    @Override
    public GridItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pbo, parent, false);
        return new GridItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GridItemViewHolder holder, int position) {
        final Main PBO = PBOList.get(position);

        holder.tvgejala.setText(PBO.getJudul());
        holder.tvgejala.append(" ");

        holder.tvdetail.setText(PBO.getDetail1());

        holder.btnEdit.setTag(position);
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(v.getTag().toString());

                Intent i = new Intent(c, AddPBOActivity.class);
                i.putExtra("id", PBOList.get(pos).getId());
                c.startActivity(i);
            }
        });

        holder.btnDelete.setTag(position);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int pos = Integer.parseInt(v.getTag().toString());

                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setMessage("Are you sure you want to delete this materi?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                new DeletePBO(c, PBOList.remove(pos)).execute();
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return PBOList.size();
    }

    static class DeletePBO extends AsyncTask<Void, Void, Void> {
        private Main u;
        private WeakReference<Context> c;

        public DeletePBO(Context c, Main u) {
            this.c = new WeakReference<>(c);
            this.u = u;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            PBODatabase ud = PBODatabase.getAppDatabase(c.get());
            ud.PBODao().delete(u);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(c.get(), "materi deleted successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}
