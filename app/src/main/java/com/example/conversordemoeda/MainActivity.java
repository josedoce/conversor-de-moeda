package com.example.conversordemoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText et_valorReais;
    Button bt_converter;
    TextView tv_valorDolares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_valorReais = findViewById(R.id.et_valor_em_reais);
        bt_converter = findViewById(R.id.bt_converter);
        tv_valorDolares = findViewById(R.id.tv_valor_em_dolares);
        converterRealParaDolar(new Conversor(), et_valorReais, bt_converter, tv_valorDolares);
    }

    private void converterRealParaDolar(Conversor c, EditText et, Button bt, TextView tv){
        bt.setOnClickListener((btn)->{
            try {
                double valorEmReal = Double.parseDouble(et.getText().toString());

                double valorEmDolar = c.realParaDolar(valorEmReal);
                String[] status = {
                        "",
                        "es"
                };
                tv.setText(String.format(Locale.GERMANY, "R$ %.2f compram $ %.2f dolar%s ",valorEmReal , valorEmDolar, status[(valorEmDolar <= 1?0:1)] ));
                tv.setTextColor(Color.parseColor("#FF018786"));
            }catch (NumberFormatException e){
                tv.setText("Digite apenas números.");
                tv.setTextColor(Color.rgb(255,99,71));
            }
        });
    }
}