package info.hernanramirez.mismapas.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import info.hernanramirez.mismapas.MapaFragment;
import info.hernanramirez.mismapas.R;
import info.hernanramirez.mismapas.models.SitioMerida;

public class SitioDataAdapter extends RecyclerView.Adapter<SitioDataAdapter.ViewHolder> {
    private ArrayList<SitioMerida> arrayList;
    private Context mcontext;
    Activity activity;

    public SitioDataAdapter(Context context, ArrayList<SitioMerida> sitios) {
        this.arrayList = sitios;
        this.mcontext = context;
    }

    @Override
    public void onBindViewHolder(SitioDataAdapter.ViewHolder holder, int i) {

        final int aa = i;

        holder.textView.setText(arrayList.get(i).getrecyclerViewTitleText());
        holder.imageView.setImageResource(arrayList.get(i).getrecyclerViewImage());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle data = new Bundle();

                if (aa == 0) {
                    data.putDouble("lat", 8.631507656148878);
                    data.putDouble("log", -71.14622384167097);
                    data.putString("title", "Parque Los Chorros de Milla");

                } else  if (aa == 1) {

                    data.putDouble("lat", 8.591769151422758);
                    data.putDouble("log", -71.14155679798506);
                    data.putString("title", "Teleférico de Mérida");

                } else  if (aa == 2) {

                    data.putDouble("lat", 8.597469692969272);
                    data.putDouble("log", -71.14509194946669);
                    data.putString("title", "Museo Arqueologico");

                }else  if (aa == 3) {

                    data.putDouble("lat", 8.592827169436221);
                    data.putDouble("log", -71.15808456993483);
                    data.putString("title", "Mecado Principal de Mérida");

                }


                MapaFragment mapaFragment = new MapaFragment();
                mapaFragment.setArguments(data);

                FragmentManager manager = ((AppCompatActivity)mcontext).getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.content_frame, mapaFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


    }

    @Override
    public SitioDataAdapter.ViewHolder onCreateViewHolder(ViewGroup vGroup, int i) {

        View view = LayoutInflater.from(vGroup.getContext()).inflate(R.layout.row_layout, vGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View v) {
            super(v);

            textView = (TextView) v.findViewById(R.id.text);
            imageView = (ImageView) v.findViewById(R.id.image);
        }
    }

}
