package com.example.inventoryapp;

import android.app.Activity;
import android.content.Intent;
import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class BarcodeScanner {

    private Activity activity;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    public static final int BARCODE_SCANNER_REQUEST_CODE = 101;

    public BarcodeScanner(Activity activity) {
        this.activity = activity;
    }

    public void requestCameraAndScan() {
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            startScanning();
        } else {
            ActivityCompat.requestPermissions(
                    activity,
                    new String[]{Manifest.permission.CAMERA},
                    CAMERA_PERMISSION_REQUEST_CODE
            );
        }
    }

    public void startScanning() {
        Intent intent = new Intent(activity, BarcodeScannerActivity.class);
        activity.startActivityForResult(intent, BARCODE_SCANNER_REQUEST_CODE);
    }
}