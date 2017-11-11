package br.com.blogspot.rafaelneves17.imc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class IMC extends AppCompatActivity implements View.OnClickListener  {

    private AdView adView;

    private EditText edtvalor1;
    private EditText edtvalor2;


    private Button btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        adView = (AdView) findViewById(R.id.adBanner);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        edtvalor1 = (EditText) findViewById(R.id.edtvalor1);
        edtvalor2 = (EditText) findViewById(R.id.edtvalor2);

        btncalcular = (Button) findViewById(R.id.btncalcular);

        btncalcular.setOnClickListener(this);


    }

    public void onClick(View v) {


        String v1 = edtvalor1.getText().toString();
        String v2 = edtvalor2.getText().toString();


        if (v1.trim().isEmpty() || v2.trim().isEmpty()) {


            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Há dados em branco :");
            dlg.setNeutralButton("OK", null);
            dlg.show();


        } else {
            double valor1 = Double.parseDouble(edtvalor1.getText().toString());
            double valor2 = Double.parseDouble(edtvalor2.getText().toString());

            double resultado;
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);

            resultado = valor2 / (valor1 * valor1);

            if (resultado < 16) {

                dlg.setMessage(""+resultado + "\n Magreza grave");
                dlg.setNeutralButton("OK", null);
                dlg.show();

            } else if (16 < resultado && resultado < 17) {

                dlg.setMessage("" + resultado + "\n Magreza moderada");
                dlg.setNeutralButton("OK", null);
                dlg.show();

            } else if (17 < resultado && resultado < 18.5) {

                dlg.setMessage("" + resultado + "\n Magreza moderada");
                dlg.setNeutralButton("OK", null);
                dlg.show();
            } else if (18.5 < resultado && resultado < 25) {

                dlg.setMessage("" + resultado + "\nSaudável");
                dlg.setNeutralButton("OK", null);
                dlg.show();


            } else if (25 < resultado && resultado < 30) {

                dlg.setMessage("" + resultado + "\nsobrepeso");
                dlg.setNeutralButton("OK", null);
                dlg.show();


            } else if (30 < resultado && resultado < 35) {

                dlg.setMessage("" + resultado + "\n Obesidade Grau I");
                dlg.setNeutralButton("OK", null);
                dlg.show();
            }else if (35 < resultado && resultado < 40) {

                dlg.setMessage("" + resultado + "\n Obesidade Grau II (severa)");
                dlg.setNeutralButton("OK", null);
                dlg.show();
            }
            else if ( resultado >40) {

                dlg.setMessage("" + resultado + "\n Obesidade Grau III (mórbida)");
                dlg.setNeutralButton("OK", null);
                dlg.show();
            }



        }

    }



    @Override
    public void onPause() {

        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume (){
        super.onResume();
        if(adView !=null){
            adView.resume();
        }
    }
    @Override
    public void onDestroy(){
        if(adView!=null){
            adView.destroy();
        }
        super.onDestroy();

    }



}

