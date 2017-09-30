package com.job.paginasamarillasapp.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.job.paginasamarillasapp.Controllers.EmpresaRepository;
import com.job.paginasamarillasapp.R;

public class MainActivity extends AppCompatActivity {

    public EditText busqueda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        busqueda = (EditText) findViewById(R.id.buscador);

        EmpresaRepository empresaRepository = EmpresaRepository.getInstance();
        empresaRepository.agregarEmpresa();


    }

    public void buscar(View view) {

        String bus = busqueda.getText().toString();

        Intent intent = new Intent(this, ResultadosActivity.class);
        intent.putExtra("nombre", bus);
        startActivity(intent);

    }
}
