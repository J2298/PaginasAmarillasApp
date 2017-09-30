package com.job.paginasamarillasapp.Controllers;

import android.widget.ArrayAdapter;

import com.job.paginasamarillasapp.Models.Empresa;

import java.util.ArrayList;
import java.util.List;

public class EmpresaRepository {

    private static EmpresaRepository _INSTANCE = null;

    private EmpresaRepository() {
    }

    public static EmpresaRepository getInstance() {
        if (_INSTANCE == null)
            _INSTANCE = new EmpresaRepository();
        return _INSTANCE;
    }

    private List<Empresa> empresas = new ArrayList<>();

    public List<Empresa> getEmpresas() {
        return this.empresas;
    }


    public void agregarEmpresa() {

        Empresa emp1 = new Empresa(100, "Instituto", "Tecsup", "Santa Anita, Avenida Cascanueces 2221, Lima 15011", 3173900, "tecsup@tecsup.edu.pe", "http://www.tecsup.edu.pe/home/", "logo_tecsup", "Tecsup es una organización educativa privada sin fines de lucro, dedicada a formar y capacitar profesionales, así como brindar servicios de consultoría, investigación y aplicación de tecnología. El fundador, Luis Hochschild Plaut, se esforzó por hacer de Tecsup una valiosa obra para beneficio de los jóvenes y profesionales de empresas e instituciones del país.");
        Empresa emp2 = new Empresa(200, "Restaurant", "KFC", "Jirón de la Unión 698, Cercado de Lima 15001", 5050505, "kfc@kfc.edu.pe", "https://www.kfc.com.pe/Online", "logo_kfc", "Todo comenzó con un pollo frito preparado por Harland Sanders, quien nació en Henryville Indiana en 1890. Desde pequeño aprendió a luchar por la vida, por tener la responsabilidad de cuidar a sus hermanos pequeños. Cuando su madre falleció y tuvo que trabajar para sostener a su familia. Sanders logró el dominio del arte culinario, después de haber intentado varias profesiones descubrió su verdadera vocación.");
        Empresa emp3 = new Empresa(300, "Instituto", "Senati", "Av. Alfredo Mendiola # 3520, Independencia, Lima", 80111100, "senati@senati.edu.pe", "http://www.senati.edu.pe/web/", "logo_senati", "Brindamos carreras profesionales con título a nombre de la nación y alta demanda laboral, que responden a la necesidad de profesionales que la industria necesita. Contamos con 64 carreras en 82 sedes a nivel nacional, según la demanda de cada zona.");
        Empresa emp4 = new Empresa(400, "Restaurant", "Pardos Chicken", "Pasaje Santa Rosa 153, Cercado de Lima 15001", 2198000, "pardoschicken@pardoschicken.edu.pe", "http://www.pardoschicken.pe/", "logo_pardo", "La historia de Pardos Chicken tiene mucho sabor porque está íntimamente inspirada en la del pollo a la brasa en el Perú. Sumamos 30 años de total dedicación en brindar, a través de nuestro platillo bandera, una auténtica, sabrosa e inconfundible Experiencia Pardos para todos. Actualmente, creemos que la combinación de los generosos ingredientes peruanos que empleamos sigue siendo el principal activo que nos permite estar presentes en el país con veintisiete restaurantes (dos en Trujillo y uno en Chiclayo) y exponer con pasión parte de nuestra cultura culinaria en el exterior.");
        Empresa emp5 = new Empresa(500, "Entretenimiento", "Cinemark", "C.C. Mega Plaza Alfredo Mendiola 3698, Independencia 15311", 5217125, "cinemark@cinemark.edu.pe", "http://www.cinemark-peru.com/home", "logo_cinemark", "Cinemark es una cadena global de multicines que opera en Estados Unidos, El Salvador, Nicaragua, Guatemala, Panamá, Costa Rica, Honduras, Colombia, Ecuador, Brasil, Argentina, Chile, Taiwán y Perú, expandiéndose año tras año en los Estados Unidos y el extranjero, en estos mercados donde ocupamos posiciones de liderazgo, ocupando la primera o segunda posición en la mayoría de ellos.");

        empresas.add(emp1);
        empresas.add(emp2);
        empresas.add(emp3);
        empresas.add(emp4);
        empresas.add(emp5);
    }

    public void filtrarBusqueda(String nombre, ArrayAdapter adapter) {

        for (Empresa empresa : empresas) {
            if (nombre.equals(empresa.getRubro())) {
                adapter.add(empresa.getNombre());
            }
        }
    }
}
