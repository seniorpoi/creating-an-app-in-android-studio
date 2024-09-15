package com.example.splashactivity;

// SplashActivity.java
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Delay for a few seconds
        new Handler().postDelayed(() -> {
            if (isConnectedToInternet()) {
                // Proceed to MainActivity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            } else {
                // Show Snackbar message
                Snackbar.make(findViewById(android.R.id.content),
                        "Internet connection is required.",
                        Snackbar.LENGTH_INDEFINITE).show();
            }
        }, 3000); // 3 seconds delay
    }

    private boolean isConnectedToInternet() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
