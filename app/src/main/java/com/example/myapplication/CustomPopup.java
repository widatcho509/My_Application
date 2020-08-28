package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CustomPopup extends AppCompatActivity {
    TextView txtClose,txtPrecio;
    EditText etCantidad;
    ImageButton ibAdd,ibMen;
    Button btComprar;
    int cantidad,precio=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_popup);

        txtClose=(TextView) findViewById(R.id.txtClose);
        txtPrecio=(TextView) findViewById(R.id.txtPrice);
        etCantidad=(EditText) findViewById(R.id.etcantidad);
        ibAdd=(ImageButton) findViewById(R.id.imgSum);
        ibMen=(ImageButton) findViewById(R.id.imgMen);
        btComprar=findViewById(R.id.btn_buy);

        precio= Integer.parseInt(txtPrecio.getText().toString());
        //Toast.makeText(this, txtPrecio.getText().toString(), Toast.LENGTH_SHORT).show();
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

         cantidad=Integer.parseInt(etCantidad.getText().toString());
        ibAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ibMen.setEnabled(true);
                cantidad++;




                    int precioFinal=cantidad*precio;
                    etCantidad.setText(String.valueOf(cantidad));
                    txtPrecio.setText(String.valueOf(precioFinal));



              //  Sumar(cantidad);

            }
        });
        ibMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad--;

                if (cantidad < 1){
                    ibMen.setEnabled(false);
                }else{
                    ibMen.setEnabled(true);
                    int precioFinal=cantidad*precio;
                    etCantidad.setText(String.valueOf(cantidad));
                    txtPrecio.setText(String.valueOf(precioFinal));
                }
            }
        });
        btComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }


}