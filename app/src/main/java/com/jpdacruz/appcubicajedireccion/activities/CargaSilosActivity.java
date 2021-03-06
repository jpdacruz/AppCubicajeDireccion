package com.jpdacruz.appcubicajedireccion.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.jpdacruz.appcubicajedireccion.MainActivity;
import com.jpdacruz.appcubicajedireccion.R;
import com.jpdacruz.appcubicajedireccion.dialogs.DialogAlturaGranoFragment;
import com.jpdacruz.appcubicajedireccion.dialogs.DialogConoSiloFragment;
import com.jpdacruz.appcubicajedireccion.dialogs.DialogCopeteSiloFragment;
import com.jpdacruz.appcubicajedireccion.dialogs.DialogDiametroSiloFragment;
import com.jpdacruz.appcubicajedireccion.dialogs.DialogTipoPHFragment;

public class CargaSilosActivity extends AppCompatActivity implements
        DialogDiametroSiloFragment.TomarDatosDialogListener,
        DialogConoSiloFragment.TomarDatosDialogListener,
        DialogCopeteSiloFragment.TomarDatosDialogListener,
        DialogAlturaGranoFragment.TomarDatosDialogListener,
        DialogTipoPHFragment.TomarDatosDialogListener {

    //vars

    private static final String TAG = "CargaSilosActivity";
    String idSilo,tipoGrano,phGranoString,diametroSiloString,alturaConoSiloString, alturaCopeteSiloString,
            alturaGranoString, cubicajeSiloString;
    double  phGrano,diametroSilo, radio2, volumenCilindro, alturaGrano,alturaConoSilo,conoSilo,alturaCopeteSilo,
            copeteSilo, volumenSilo, cubicajeSilo;

    //widgets
    FloatingActionButton fabAceptar;
    Button mCalcularDiametro, mCalcularAlturaGrano, mIngreseTipoPh,mCalcularCono, mCalcularCopete, mCalcularCubicaje;
    TextView mToneladasSilo;
    Toolbar toolbar;
    TextInputLayout mIdSilo,mPhGrano,mDiametro,mAlturaGrano,mCono, mCopete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_silos);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        iniciarWidgets();
        iniciarBotonesListener();
    }

    private void iniciarWidgets() {

        mIdSilo = findViewById(R.id.textinputIDSilo);
        mPhGrano = findViewById(R.id.textinputPHSilo);
        mDiametro = findViewById(R.id.textinputDiametroSilo);
        mAlturaGrano = findViewById(R.id.textinputAlturaGrano);
        mCono = findViewById(R.id.textinputConoSilo);
        mCopete = findViewById(R.id.textinputCopeteSilo);
        mToneladasSilo = findViewById(R.id.textViewMostrarToneldas);
        mIngreseTipoPh = findViewById(R.id.buttonTipoPH);
        mCalcularDiametro = findViewById(R.id.buttonCalcularDiametro);
        mCalcularAlturaGrano = findViewById(R.id.buttonCalcularAlturaGrano);
        mCalcularCono = findViewById(R.id.buttonCalcularCono);
        mCalcularCopete = findViewById(R.id.buttonCalcularCopete);
        mCalcularCubicaje = findViewById(R.id.botonCalcularSilo);
        fabAceptar = findViewById(R.id.fabGuardar);
    }

    private void iniciarBotonesListener() {

        fabAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               Intent intent = new Intent(getApplicationContext(), MainActivity.class);
               startActivity(intent);
            }
        });

        mIngreseTipoPh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iniciarDialogTipoPH();
            }
        });

        mCalcularDiametro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                iniciarDialogDiametro();
            }
        });

        mCalcularAlturaGrano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iniciarDialogAlturaGrano();
            }
        });

        mCalcularCono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                iniciarDialogCono();
            }
        });

        mCalcularCopete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                iniciarDialogCopete();
            }
        });

        mCalcularCubicaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcularCubicajeSilo();
            }
        });
    }

    private void iniciarDialogTipoPH() {

        DialogTipoPHFragment dialogF = new DialogTipoPHFragment();
        dialogF.show(getSupportFragmentManager(),TAG);
    }

    private void iniciarDialogDiametro() {

        if (!validarProcesoDiametro()){

            return;
        }

        DialogDiametroSiloFragment dialogF = new DialogDiametroSiloFragment();
        dialogF.show(getSupportFragmentManager(),TAG);
    }

    private void iniciarDialogAlturaGrano() {

        DialogAlturaGranoFragment dialogF = new DialogAlturaGranoFragment();
        dialogF.show(getSupportFragmentManager(),TAG);
    }

    private void iniciarDialogCono() {

        if (!validadProcesoConoCopete()){

            return;
        }

        DialogConoSiloFragment dialogF = new DialogConoSiloFragment();
        dialogF.show(getSupportFragmentManager(),TAG);
    }

    private void iniciarDialogCopete() {

        if (!validadProcesoConoCopete()){

            return;
        }

        DialogCopeteSiloFragment dialogF = new DialogCopeteSiloFragment();
        dialogF.show(getSupportFragmentManager(),TAG);
    }

    private void calcularCono() {

        if (!validadProcesoConoCopete()){

            return;
        }

        diametroSiloString = getEditTextString(mDiametro);
        diametroSilo = Double.parseDouble(diametroSiloString);
        alturaConoSilo = Math.round(((diametroSilo / 2) * 0.7) * 100) / 100.0;
        alturaConoSiloString = String.valueOf(alturaConoSilo);
        setEditText(mCono,alturaConoSiloString);
    }

    private void calcularCopete(boolean b) {

        if (!validadProcesoConoCopete()){

            return;
        }

        if (b) {

            diametroSiloString = getEditTextString(mDiametro);
            diametroSilo = Double.parseDouble(diametroSiloString);
            alturaCopeteSilo = Math.round(((diametroSilo / 2) * 0.5) * 100) / 100.0;
            alturaCopeteSiloString = String.valueOf(alturaCopeteSilo);
            setEditText(mCopete, alturaCopeteSiloString);

        }else {

            diametroSiloString = getEditTextString(mDiametro);
            diametroSilo = Double.parseDouble(diametroSiloString);
            alturaCopeteSilo = -((diametroSilo /2) *0.5);
            alturaCopeteSiloString = String.valueOf(alturaCopeteSilo);
            setEditText(mCopete, alturaCopeteSiloString);
        }
    }

    public void calcularCubicajeSilo() {

        if (!validarDatos()){

            return;
        }

        idSilo = "SiloEntity " + getEditTextString(mIdSilo);
        diametroSiloString = getEditTextString(mDiametro);
        alturaGranoString = getEditTextString(mAlturaGrano);
        alturaConoSiloString = getEditTextString(mCono);
        alturaCopeteSiloString = getEditTextString(mCopete);
        diametroSilo = Double.parseDouble(diametroSiloString);
        alturaGrano= Double.parseDouble(alturaGranoString);
        alturaConoSilo = Double.parseDouble(alturaConoSiloString);
        alturaCopeteSilo = Double.parseDouble(alturaCopeteSiloString);

        radio2 = (diametroSilo/2)*(diametroSilo/2);
        volumenCilindro = (Math.PI * radio2 *alturaGrano);

        if (alturaConoSilo == 0){

            conoSilo = 0;

        }else {

            conoSilo = (Math.PI * radio2 * alturaConoSilo)/3;
        }

        if (alturaCopeteSilo == 0){

            copeteSilo = 0;

        }else {

            copeteSilo = (Math.PI * radio2 * alturaCopeteSilo)/3;
        }

        volumenSilo = volumenCilindro + conoSilo + copeteSilo;
        cubicajeSilo = Math.round((volumenSilo * phGrano) * 100)/100.0;

        cubicajeSiloString = String.valueOf(cubicajeSilo);

        mToneladasSilo.setText(cubicajeSiloString + " Toneladas");

    }

    private boolean validarDatos() {

        if (!validarProcesoDiametro()){

            return false;

        }else if (!validadProcesoConoCopete()){

            return false;

        }else if (!validarProcesoCalcular()) {

            return false;

        }else {

            return true;
        }
    }

    private boolean validarProcesoCalcular() {

        alturaGranoString = getEditTextString(mAlturaGrano);
        alturaConoSiloString = getEditTextString(mCono);
        alturaCopeteSiloString = getEditTextString(mCopete);

        if (alturaGranoString.isEmpty()){

            mAlturaGrano.setError("Dato requerido");
            return false;

        }else if(alturaConoSiloString.isEmpty()){

            mCono.setError("Dato requerido");
            return false;

        }else if (alturaCopeteSiloString.isEmpty()){

            mCopete.setError("Dato requerido");
            return false;
        }

        mAlturaGrano.setError("");
        mCono.setError("");
        mCopete.setError("");

        return true;
    }

    private boolean validarProcesoDiametro() {

        idSilo = getEditTextString(mIdSilo);
        phGranoString = getEditTextString(mPhGrano);

        if (idSilo.isEmpty()) {

            mIdSilo.setError("Dato requerido");
            return false;

        } else if (phGranoString.isEmpty()) {

            mPhGrano.setError("Dato requerido");
            return false;

        } else if (tipoGrano.equals("SELECCIONA")) {

            Toast.makeText(getApplicationContext(), "DEBE SELECCIONAR UN GRANO", Toast.LENGTH_LONG).show();
            return false;

        } else {

            mIdSilo.setError(null);
            mPhGrano.setError(null);
            return true;
        }
    }

    private boolean validadProcesoConoCopete() {

        diametroSiloString = getEditTextString(mDiametro);

        if (diametroSiloString.isEmpty()){

            mDiametro.setError("Dato requerido");
            return false;

        }else {

            mDiametro.setError("");
            return true;
        }
    }

    @Override
    public void enviarDatosDialogTipoPh(String tipo, String ph) {

        tipoGrano = tipo;
        phGranoString = ph;

        setEditText(mPhGrano, tipoGrano + " " +  phGranoString);
        phGrano = Double.parseDouble(phGranoString);

    }

    @Override
    public void enviarDatosDialogDiametro(String diametro) {

        diametroSiloString = diametro;
        setEditText(mDiametro, diametroSiloString);
    }

    @Override
    public void enviarDatosDialogAlturaGrano(String alturaGrano) {

        alturaGranoString = alturaGrano;
        setEditText(mAlturaGrano, alturaGranoString);
    }

    @Override
    public void enviarDatosDialogCono(Boolean bool) {

        if (bool){

            calcularCono();

        }else {

           setEditText(mCono, "0.00");
        }
    }

    @Override
    public void enviarDatosDialogCopete(String string) {

        if (string.equals("p")){

            calcularCopete(true);

        }else if (string.equals("n")){

            calcularCopete(false);

        }else {

            setEditText(mCopete, "0.00");
        }
   }

    private void setEditText(TextInputLayout editText, String string) {

        editText.getEditText().setText(string);
    }

    private String getEditTextString(TextInputLayout editText) {

        return editText.getEditText().getText().toString();

    }

    private void resetEditText(TextInputLayout editText){

        editText.getEditText().setText("");
    }

}
