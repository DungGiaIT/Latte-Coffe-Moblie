package com.project.cafeshopapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableActivity extends AppCompatActivity {
    GridView gridView;
    List<TableModel> tableList = new ArrayList<>(); // Sửa thành List<TableModel>
    TableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        gridView = findViewById(R.id.gridView);
        adapter = new TableAdapter(this, tableList); // Adapter sẽ nhận List<TableModel>
        gridView.setAdapter(adapter);

        fetchTablesFromApi();

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            // Lấy tableId từ TableModel
            int selectedTableNumber = tableList.get(position).getTableId();
            Intent intent = new Intent(this, OrderActivity.class);
            intent.putExtra("tableNumber", selectedTableNumber);
            startActivity(intent);
        });
    }

    private void fetchTablesFromApi() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<TableModel>> call = apiService.getTables();

        call.enqueue(new Callback<List<TableModel>>() {
            @Override
            public void onResponse(Call<List<TableModel>> call, Response<List<TableModel>> response) {
                Log.d("API_CALL", "onResponse: HTTP " + response.code());

                if (response.isSuccessful() && response.body() != null) {
                    List<TableModel> models = response.body();
                    Log.d("API_CALL", "Số lượng bàn nhận được: " + models.size());

                    tableList.clear();
                    tableList.addAll(models); // Thêm trực tiếp dữ liệu từ API

                    adapter.notifyDataSetChanged();
                } else {
                    try {
                        Log.e("API_CALL", "Response lỗi: " + response.code() + ", body: " + response.errorBody().string());
                    } catch (Exception e) {
                        Log.e("API_CALL", "Không thể đọc errorBody", e);
                    }
                    Toast.makeText(TableActivity.this, "Không tải được dữ liệu bàn", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<TableModel>> call, Throwable t) {
                t.printStackTrace();
                Log.e("API_CALL", "Lỗi kết nối: " + t.getMessage(), t);
                Toast.makeText(TableActivity.this, "Không thể kết nối đến server: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}