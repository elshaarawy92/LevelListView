package com.les.levellistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ListViewAdpter adpter;
    private List<ExampleBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        ExampleBean exampleBean = new ExampleBean();
        exampleBean.id = "235";
        exampleBean.tag = "山东";
        exampleBean.level = 1;
        exampleBean.name = "山东";
        ExampleBean exampleBean2 = new ExampleBean();
        exampleBean2.id = "236";
        exampleBean2.tag = "山东";
        exampleBean2.level = 2;
        exampleBean2.name = "济南";
        ExampleBean exampleBean3 = new ExampleBean();
        exampleBean3.id = "237";
        exampleBean3.tag = "山东";
        exampleBean3.level = 2;
        exampleBean3.name = "青岛";
        ExampleBean exampleBean4 = new ExampleBean();
        exampleBean4.id = "238";
        exampleBean4.tag = "山东";
        exampleBean4.level = 2;
        exampleBean4.name = "德州";
        ExampleBean exampleBean5 = new ExampleBean();
        exampleBean5.id = "239";
        exampleBean5.tag = "山东";
        exampleBean5.level = 2;
        exampleBean5.name = "聊城";
        list.add(exampleBean);
        list.add(exampleBean2);
        list.add(exampleBean3);
        list.add(exampleBean4);
        list.add(exampleBean5);
        ExampleBean exampleBean6 = new ExampleBean();
        exampleBean6.id = "235";
        exampleBean6.tag = "山东2";
        exampleBean6.level = 1;
        exampleBean6.name = "山东";
        ExampleBean exampleBean7 = new ExampleBean();
        exampleBean7.id = "236";
        exampleBean7.tag = "山东2";
        exampleBean7.level = 2;
        exampleBean7.name = "济南";
        ExampleBean exampleBean8 = new ExampleBean();
        exampleBean8.id = "237";
        exampleBean8.tag = "山东2";
        exampleBean8.level = 2;
        exampleBean8.name = "青岛";
        ExampleBean exampleBean9 = new ExampleBean();
        exampleBean9.id = "238";
        exampleBean9.tag = "山东2";
        exampleBean9.level = 2;
        exampleBean9.name = "德州";
        ExampleBean exampleBean10 = new ExampleBean();
        exampleBean10.id = "239";
        exampleBean10.tag = "山东2";
        exampleBean10.level = 2;
        exampleBean10.name = "聊城";
        list.add(exampleBean6);
        list.add(exampleBean7);
        list.add(exampleBean8);
        list.add(exampleBean9);
        list.add(exampleBean10);
        adpter = new ListViewAdpter(MainActivity.this, list);
        listView.setAdapter(adpter);

    }
}
