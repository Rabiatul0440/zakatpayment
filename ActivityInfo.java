package com.example.zakatpayment;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info); // Make sure this matches your XML file name

        // Access and modify TextView elements if needed
        TextView titleText = findViewById(R.id.titleText);
        TextView section1Title = findViewById(R.id.section1Title);
        TextView section1Content = findViewById(R.id.section1Content);
        TextView section2Title = findViewById(R.id.section2Title);
        TextView section2Content = findViewById(R.id.section2Content);
        TextView section3Title = findViewById(R.id.section3Title);
        TextView section3Content = findViewById(R.id.section3Content);

        // Example of updating content dynamically if needed
        titleText.setText("Learn More About Zakat");
        section1Title.setText("What is Zakat?");
        section1Content.setText("Zakat is one of the Five Pillars of Islam and is a mandatory act of giving a specific percentage of wealth to charity. It purifies your income and wealth and supports those in need.");
        section2Title.setText("Why is Zakat Important?");
        section2Content.setText("Zakat helps to reduce poverty, supports the community, and fosters a sense of social responsibility. It ensures the redistribution of wealth and helps those who are less fortunate.");
        section3Title.setText("What is the Law of Issuing Zakat?");
        section3Content.setText("The law of zakat has mu'tamad proofs (القطع) from the point of guidance (الدلالة) and its sickle. It makes the law of zakat clear and easy to understand from a religious point of view.");
    }
}
