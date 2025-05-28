package com.project.cafeshopapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    TextView tableLabel;
    RecyclerView orderList;
    Button confirmBtn;
    int tableNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tableNumber = getIntent().getIntExtra("tableNumber", 1);
        tableLabel = findViewById(R.id.tableLabel);
        orderList = findViewById(R.id.recyclerView);
        confirmBtn = findViewById(R.id.confirmBtn);

        tableLabel.setText("Bàn số " + tableNumber);

        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem("Trà sữa", "Ít đường, ít đá", 1));
        items.add(new OrderItem("Cà phê đen", "Không đường", 2));

        orderList.setLayoutManager(new LinearLayoutManager(this));
        orderList.setAdapter(new OrderAdapter(items));

        confirmBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Đơn bàn " + tableNumber + " đã hoàn thành", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}