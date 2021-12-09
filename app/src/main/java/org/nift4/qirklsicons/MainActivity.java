package org.nift4.qirklsicons;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends Activity {

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private String[] list;

        public RecyclerViewAdapter(@NonNull String[] list) {
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String s = list[position];
            int did = MainActivity.this.getResources().getIdentifier(s, "drawable", MainActivity.this.getPackageName());
            int sid = MainActivity.this.getResources().getIdentifier(s, "string", MainActivity.this.getPackageName());
            holder.t.setText(sid);
            holder.i.setImageDrawable(MainActivity.this.getDrawable(did));
        }

        @Override
        public int getItemCount() {
            return list.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView i;
            TextView t;
            public ViewHolder(View view) {
                super(view);
                i = view.findViewById(R.id.imageView);
                t = view.findViewById(R.id.textView);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = findViewById(R.id.rv);
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), recyclerLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getResources().getStringArray(R.array.icon_pack));
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
