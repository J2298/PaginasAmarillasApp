package com.job.paginasamarillasapp.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.job.paginasamarillasapp.Models.Empresa;
import com.job.paginasamarillasapp.Controllers.EmpresaRepository;
import com.job.paginasamarillasapp.R;

import java.util.List;

public class ResultadosActivity extends AppCompatActivity {

    private ListView list;
    private String nom;
    private String rub;
    private String dir;
    private String info;
    private String correo;
    private String url;
    private int tele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        list = (ListView) findViewById(R.id.lista_resultados);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        list.setAdapter(adapter);

        adapter = (ArrayAdapter<String>) list.getAdapter();

        Intent intent = getIntent();
        String empresa = intent.getStringExtra("nombre");

        EmpresaRepository empresaRepository = EmpresaRepository.getInstance();
        empresaRepository.filtrarBusqueda(empresa, adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                EmpresaRepository emp = EmpresaRepository.getInstance();
                List<Empresa> empresas = emp.getEmpresas();

                for (Empresa empresa : empresas) {
                    Object listItem = list.getItemAtPosition(position);
                    if (listItem == empresa.getNombre()) {
                        Intent intent = new Intent(ResultadosActivity.this, DetalleActivity.class);
                        intent.putExtra("Empresa", empresa);
                        startActivity(intent);


                       /* id = empresa.getId();
                        nom = empresa.getNombre();
                        rub = empresa.getRubro();
                        dir = empresa.getDireccion();
                        info = empresa.getInfo();
                        correo = empresa.getCorreo();
                        url = empresa.getUrl();
                        tele = empresa.getTelefono();
                        Intent home = new Intent(this,DetalleActivity.class);
                        Empresa uLogeado = new Empresa(nom,rub,dir,info,correo,url,tele);
                        home.putExtra("Usuario",uLogeado);
                        startActivity(home);
                        finish();*/
                    }
                }
            }


        });

    }
}
