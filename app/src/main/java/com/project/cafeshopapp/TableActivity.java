package com.project.cafeshopapp;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class TableActivity extends AppCompatActivity {
    GridView gridView;
    int[] tableNumbers = {1, 2, 3, 4, 5, 6};
    List<Table> tableList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        // Khởi tạo danh sách Table với trạng thái mặc định
        for (int number : tableNumbers) {
            tableList.add(new Table(number));
        }

        gridView = findViewById(R.id.gridView);
        TableAdapter adapter = new TableAdapter(this, tableList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            int selectedTableNumber = tableList.get(position).getNumber(); // Đúng getter
            Intent intent = new Intent(this, OrderActivity.class);
            intent.putExtra("tableNumber", selectedTableNumber);
            startActivity(intent);
        });
    }
}
