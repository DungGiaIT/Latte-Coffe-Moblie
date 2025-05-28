package com.project.cafeshopapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private LinearLayout staffInfoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Bắt lỗi không tìm thấy ID nếu chưa có main
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        staffInfoLayout = findViewById(R.id.staffInfoLayout);
        ImageView iconProfile = findViewById(R.id.iconProfile);
        Button btnBack = findViewById(R.id.btnBack);

        iconProfile.setOnClickListener(v -> staffInfoLayout.setVisibility(View.VISIBLE));
        btnBack.setOnClickListener(v -> staffInfoLayout.setVisibility(View.GONE));
    }
}
