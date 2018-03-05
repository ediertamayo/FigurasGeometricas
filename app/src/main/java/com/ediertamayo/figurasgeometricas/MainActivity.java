package com.ediertamayo.figurasgeometricas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    RadioButton rCuadro,rCirculo,rTriangulo,rCubo;
    TextView tv1,tv2,tv3,tvPerimetro,tvArea,tvVolumen;
    EditText et1,et2,et3;
    Button bCalcular,bReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen=findViewById(R.id.imagen);
        rCuadro=findViewById(R.id.rCuadro);
        rCirculo=findViewById(R.id.rCirculo);
        rTriangulo=findViewById(R.id.rTriangulo);
        rCubo=findViewById(R.id.rCubo);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tvPerimetro=findViewById(R.id.tvPerimetro);
        tvArea=findViewById(R.id.tvArea);
        tvVolumen=findViewById(R.id.tvVolumen);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        bCalcular=findViewById(R.id.bCalcular);
        bReset=findViewById(R.id.bReset);

        rCuadro.setChecked(true);
        tv1.setText("Lado:");
        tv2.setVisibility(View.GONE);
        tv3.setVisibility(View.GONE);
        et2.setVisibility(View.GONE);
        et3.setVisibility(View.GONE);
        tvVolumen.setVisibility(View.GONE);
    }

    public void onRadioButtonClicked(View view) {
        int id=view.getId();

        if(id==R.id.rCuadro){
            imagen.setImageResource(R.drawable.cuadrado);
            tv1.setText("Lado:");
            tv2.setVisibility(View.GONE);
            tv3.setVisibility(View.GONE);
            et2.setVisibility(View.GONE);
            et3.setVisibility(View.GONE);
            tvVolumen.setVisibility(View.GONE);
            tvPerimetro.setVisibility(View.VISIBLE);
        }if(id==R.id.rCirculo){
            imagen.setImageResource(R.drawable.circulo);
            tv1.setText("Radio:");
            tv2.setVisibility(View.GONE);
            tv3.setVisibility(View.GONE);
            et2.setVisibility(View.GONE);
            et3.setVisibility(View.GONE);
            tvVolumen.setVisibility(View.GONE);
            tvPerimetro.setVisibility(View.VISIBLE);
        }if(id==R.id.rTriangulo){
            imagen.setImageResource(R.drawable.triangulo);
            tv1.setText("Lado1:");
            tv2.setText("Lado2:");
            tv3.setText("Lado3:");
            tv2.setVisibility(View.VISIBLE);
            tv3.setVisibility(View.VISIBLE);
            et2.setVisibility(View.VISIBLE);
            et3.setVisibility(View.VISIBLE);
            tvPerimetro.setVisibility(View.VISIBLE);
            tvVolumen.setVisibility(View.GONE);
        }if(id==R.id.rCubo){
            imagen.setImageResource(R.drawable.cubo);
            tv1.setText("Lado:");
            tv2.setVisibility(View.GONE);
            tv3.setVisibility(View.GONE);
            et2.setVisibility(View.GONE);
            et3.setVisibility(View.GONE);
            tvPerimetro.setVisibility(View.GONE);
            tvVolumen.setVisibility(View.VISIBLE);
        }
    }

    public void reset(View view) {
        rCuadro.setChecked(true);
        tv1.setText("Lado:");
        tv2.setVisibility(View.GONE);
        tv3.setVisibility(View.GONE);
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et2.setVisibility(View.GONE);
        et3.setVisibility(View.GONE);
        tvVolumen.setVisibility(View.GONE);
    }

    public void calcular(View view) {
        double area=0,perimetro=0,volumen=0;

        if(rCuadro.isChecked()&&!et1.getText().toString().isEmpty()){
            area=Double.valueOf(et1.getText().toString()).doubleValue()*Double.valueOf(et1.getText().toString()).doubleValue();
            perimetro=Double.valueOf(et1.getText().toString())*4;
        }
        else if(rCirculo.isChecked()&&!et1.getText().toString().isEmpty()){
            double r=Double.valueOf(et1.getText().toString()).doubleValue();
            perimetro=3.1416*r*2;
            area=3.1416*r*r;
        }
        else if(rTriangulo.isChecked()&&!et1.getText().toString().isEmpty()&&!et2.getText().toString().isEmpty()&&!et3.getText().toString().isEmpty()){
            double s,a,b,c;
            a=Double.valueOf(et1.getText().toString()).doubleValue();
            b=Double.valueOf(et2.getText().toString()).doubleValue();
            c=Double.valueOf(et3.getText().toString()).doubleValue();
            perimetro=a+b+c;
            s=perimetro/2;
            area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
        }
        else if(rCubo.isChecked()&&!et1.getText().toString().isEmpty()){
            area=Double.valueOf(et1.getText().toString()).doubleValue()*Double.valueOf(et1.getText().toString()).doubleValue()*6;
            volumen=Double.valueOf(et1.getText().toString()).doubleValue()*Double.valueOf(et1.getText().toString()).doubleValue()*Double.valueOf(et1.getText().toString()).doubleValue();
            tvVolumen.setVisibility(View.VISIBLE);
            tvVolumen.setText("Volumen:"+String.valueOf(volumen));
        }
        tvPerimetro.setText("Perimetro:"+perimetro);
        tvArea.setText("Área:"+area);
    }
}
