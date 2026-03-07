package com.example.inventoryapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class InventoryLog extends AppCompatActivity {

    private List<String> categories;
    private CategoryAdapter adapter;
    private EditText etNewCategory;
    private Button btnAddCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inventory_log);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNewCategory = findViewById(R.id.etNewCategory);
        btnAddCategory = findViewById(R.id.btnAddCategory);

        setupCategorySpinner();

        btnAddCategory.setOnClickListener(v -> {
            String newCategory = etNewCategory.getText().toString().trim();
            if (!newCategory.isEmpty()) {
                addCategory(newCategory);
                etNewCategory.setText("");
                Toast.makeText(this, "Category added: " + newCategory, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter a category name", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupCategorySpinner() {
        Spinner spinner = findViewById(R.id.spinner);
        
        // Initialize an empty dynamic list
        categories = new ArrayList<>();
        // You can add a default item if you like
        categories.add("Select Category");
        
        // Create the custom adapter
        adapter = new CategoryAdapter(this, categories);
        
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
    
    public void addCategory(String newCategory) {
        if (categories != null && adapter != null) {
            categories.add(newCategory);
            adapter.notifyDataSetChanged();
        }
    }
}