package com.example.zakatpayment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityCalculate extends AppCompatActivity {

    private EditText weightInput, goldValueInput;
    private RadioGroup goldTypeGroup;
    private TextView zakatPayableView, totalZakatView;
    private Button calculateButton;

    private static final double KEEP_THRESHOLD = 85.0; // Gold threshold for keeping (grams)
    private static final double WEAR_THRESHOLD = 200.0; // Gold threshold for wearing (grams)
    private static final double ZAKAT_RATE = 0.025; // 2.5% zakat rate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        // Initialize UI components
        weightInput = findViewById(R.id.weightInput);
        goldValueInput = findViewById(R.id.goldValueInput);
        goldTypeGroup = findViewById(R.id.goldTypeGroup);
        zakatPayableView = findViewById(R.id.zakatPayableView);
        totalZakatView = findViewById(R.id.totalZakatView);
        calculateButton = findViewById(R.id.calculateButton);

        // Set calculate button click listener
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateZakat();
            }
        });
    }

    private void calculateZakat() {
        // Get input values
        String weightStr = weightInput.getText().toString();
        String goldValueStr = goldValueInput.getText().toString();

        if (TextUtils.isEmpty(weightStr) || TextUtils.isEmpty(goldValueStr)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double goldWeight = Double.parseDouble(weightStr);
        double goldValue = Double.parseDouble(goldValueStr);

        // Check which radio button is selected
        int selectedId = goldTypeGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Please select gold type", Toast.LENGTH_SHORT).show();
            return;
        }

        double threshold = selectedId == R.id.keepGold ? KEEP_THRESHOLD : WEAR_THRESHOLD;

        // Calculate Zakat
        if (goldWeight >= threshold) {
            double zakatPayableWeight = goldWeight - threshold;
            double zakatPayableValue = zakatPayableWeight * goldValue;
            double totalZakat = zakatPayableValue * ZAKAT_RATE;

            // Display results
            zakatPayableView.setText(String.format("RM %.2f", zakatPayableValue));
            totalZakatView.setText(String.format("RM %.2f", totalZakat));
        } else {
            // No Zakat required
            zakatPayableView.setText("No Zakat Payable");
            totalZakatView.setText("RM 0.00");
        }
    }
}
