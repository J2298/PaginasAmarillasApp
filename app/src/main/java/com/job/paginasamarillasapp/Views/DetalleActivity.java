package com.job.paginasamarillasapp.Views;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.job.paginasamarillasapp.Models.Empresa;
import com.job.paginasamarillasapp.R;

public class DetalleActivity extends AppCompatActivity {

    public TextView nombI, direI, teleI, rubI, infoI, urlI, corrI;
    private Empresa empI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        nombI = (TextView) findViewById(R.id.nom_emp);
        direI = (TextView) findViewById(R.id.dir_emp);
        teleI = (TextView) findViewById(R.id.tel_emp);
        rubI = (TextView) findViewById(R.id.rub_emp);
        infoI = (TextView) findViewById(R.id.inf_emp);

        Intent intent = getIntent();
        empI = (Empresa) intent.getSerializableExtra("Empresa");

        nombI.setText(empI.getNombre());
        direI.setText(empI.getDireccion());
        teleI.setText(String.valueOf(empI.getTelefono()));
        rubI.setText(empI.getRubro());
        infoI.setText(empI.getInfo());

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_web:
                        String url = empI.getUrl();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        //Toast.makeText(DetalleActivity.this, "Go home section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_email:
                        String c = empI.getCorreo();
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + c));
                        startActivity(emailIntent);
                        //Toast.makeText(DetalleActivity.this, "Go camera section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_sms:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", String.valueOf(empI.getTelefono()), null)));
                        /*Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.putExtra(Intent.EXTRA_TEXT, "sms :" + teleI);
                        intent.setType("text/plain");
                        startActivity(intent);*/
                        //Toast.makeText(DetalleActivity.this, "Go share section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_compartir:
                        Intent share = new Intent(android.content.Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.putExtra(Intent.EXTRA_TEXT, "numero: " + infoI);
                        startActivity(Intent.createChooser(share, "Compartir"));
                        //Toast.makeText(DetalleActivity.this, "Go notification section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_llamar:
                        //Toast.makeText(DetalleActivity.this, "Go more sections...", Toast.LENGTH_SHORT).show();
                        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                        dialIntent.setData(Uri.parse("tel:" + empI.getTelefono()));
                        startActivity(dialIntent);
                        break;
                }
                return true;
            }
        });
    }
}

