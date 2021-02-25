package org.androidtown.samplelistview;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CharacterItemView extends LinearLayout {
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    public CharacterItemView(Context context){
        super(context);
        init(context);
    }

    public CharacterItemView(Context context, AttributeSet attrs){
        super(context,attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.character_item,this,true);

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
    }

    public void setName(String name){
        textView2.setText(name);
    }

    public void setRankPoint(String point){
        textView3.setText(point);
    }

    public void setLevel(int level){
        textView4.setText(String.valueOf(level));
    }

    public void setClass(String classname){
        textView.setText(classname);
    }
}
