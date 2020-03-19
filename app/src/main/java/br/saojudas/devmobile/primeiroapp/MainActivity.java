package br.saojudas.devmobile.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MEUAPP-MAINACTIVITY";
    private final String ERROR_MESSAGE = "ERRO-->Usuário tentou clicar no botão sem inserir texto!!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }


    public void enviarParaSegunda(View view) {

        Intent intent = new Intent(this,SegundaActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextNome);
        String message = editText.getText().toString();
        if(message.isEmpty()){
            Log.e(TAG,ERROR_MESSAGE);
            alertaTextoVazio();
        }else {

            intent.putExtra("EXTRA_MESSAGE", message);
            Log.d(TAG, "Botão foi acionado!");

            startActivity(intent);
        }

    }

    private void alertaTextoVazio() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Ops...");
        alertDialog.setMessage("Digite o nome :/");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

}