package com.example.zakatpayment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAbout extends AppCompatActivity {

    private TextView githubLink;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Initialize UI components
        githubLink = findViewById(R.id.githubLink);
        shareButton = findViewById(R.id.shareButton);

        // Set up GitHub link
        githubLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/rubyzawawi";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        // Set up share button functionality
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareDeveloperInfo();
            }
        });
    }

    private void shareDeveloperInfo() {
        String shareText = "Check out this amazing developer!\n\n" +
                "Name: Rabiatul Adawiyah Binti Mohd Zawawi\n" +
                "Student No: 2022868198\n" +
                "Programme Code: CDCS240\n" +
                "GitHub: https://github.com/rubyzawawi";

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}
