package org.androidtown.samplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    ListView listView;
    CharacterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        adapter = new CharacterAdapter();
        adapter.addItem(new CharacterItem("케일","12000","전사",15));
        adapter.addItem(new CharacterItem("다리우스","15000","브루저",20));
        adapter.addItem(new CharacterItem("카사딘","20000","마법사",18));
        adapter.addItem(new CharacterItem("유미","10","서포터",10));

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                CharacterItem item = (CharacterItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 : " + item.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }

    class CharacterAdapter extends BaseAdapter{
        ArrayList<CharacterItem> items = new ArrayList<CharacterItem>();

        @Override
        public int getCount(){
            return items.size();
        }

        public void addItem(CharacterItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position){
            return items.get(position);
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup){
            CharacterItemView view = new CharacterItemView(getApplicationContext());
            CharacterItem item = items.get(position);
            view.setName(item.getName());
            view.setLevel(item.getLevel());
            view.setRankPoint(item.getPoint());
            view.setClass(item.getClassname());

            return view;
        }
    }
}