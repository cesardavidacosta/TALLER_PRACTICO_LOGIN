package com.example.taller_practico_formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.ib.custom.toast.CustomToastView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConsultaEmpresa extends AppCompatActivity implements View.OnClickListener {
    private TextView txtRegistrados;
    private Spinner spinnerSeleccion;
    private TextView txtCalculos;
    private Button btnCalcular;
    private Button btnBack;
    private List<Person>ResultadoEmpleado=new ArrayList<>();
    private List<Person>ResultadoSalario=new ArrayList<>();
    private Empresa empresa;
    private String Mensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_empresa);
        List<String>Cargos= (List<String>)getIntent().getSerializableExtra("Cargos");

        List<Person> LISTAUSUARIO=(List<Person>)getIntent().getSerializableExtra("lista");
        empresa=new Empresa(LISTAUSUARIO , Cargos);

        txtRegistrados = findViewById(R.id.txtRegistrados);
        txtCalculos = findViewById(R.id.txtCalculos);
        spinnerSeleccion = findViewById(R.id.spinnerSeleccion);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.seleccion, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerSeleccion.setAdapter(adapter);
        btnBack = findViewById(R.id.btnBack);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);

        if (LISTAUSUARIO !=null){
            Cargarlista(LISTAUSUARIO);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular) {
            int elementosSpinner = (int) spinnerSeleccion.getSelectedItemId();
            switch (elementosSpinner) {
                case 0:
                    CustomToastView.makeErrorToast(this, "Seleccione su consulta", R.layout.custom_toast).show();
                    break;

                case 1:
                    Mensaje= null;
                    Mensaje ="El empleado mas joven es ";
                    ResultadoEmpleado = null;
                    ResultadoEmpleado = empresa.EmpleadoMasJoven();

                    for (int i=0; i<= ResultadoEmpleado.size()-1; i++){
                        Mensaje= Mensaje + "\n" + " Nombre y apellidos " + ResultadoEmpleado.get(i).getName() + " " + ResultadoEmpleado.get(i).getSurname()
                                + " Edad " + ResultadoEmpleado.get(i).getAge();
                    }
                    txtCalculos.setText(Mensaje);
                    break;


                case 2:
                    Mensaje= null;
                    Mensaje ="El empleado mas senil es ";
                    ResultadoEmpleado = null;
                    ResultadoEmpleado = empresa.EmpleadoMasSenil();

                    for (int i=0; i<= ResultadoEmpleado.size()-1; i++){
                        Mensaje= Mensaje + "\n" + " Nombre y apellidos " + ResultadoEmpleado.get(i).getName() + " " + ResultadoEmpleado.get(i).getSurname()
                                + " Edad " + ResultadoEmpleado.get(i).getAge();
                    }
                    txtCalculos.setText(Mensaje);
                    break;


                case 3:
                    Mensaje= null;
                    Mensaje ="El salario mas alto es ";
                    ResultadoEmpleado = null;
                    ResultadoEmpleado = empresa.SalarioMasAlto();

                    for (int i=0; i<= ResultadoEmpleado.size()-1; i++){
                        Mensaje= Mensaje + "\n" + " Nombre y apellidos " + ResultadoEmpleado.get(i).getName() + " " + ResultadoEmpleado.get(i).getSurname()
                                + " el Salario es " + ResultadoEmpleado.get(i).getSalary();
                    }
                    txtCalculos.setText(Mensaje);
                    break;

                case 4:
                    Mensaje= null;
                    Mensaje ="El salario mas bajo es ";
                    ResultadoEmpleado = null;
                    ResultadoEmpleado = empresa.SalarioMasBajo();

                    for (int i=0; i<= ResultadoEmpleado.size()-1; i++){
                        Mensaje= Mensaje + "\n" + "  " + ResultadoEmpleado.get(i).getName() + " " + ResultadoEmpleado.get(i).getSurname()
                                + " el Salario mas bajo es " + ResultadoEmpleado.get(i).getSalary();
                    }
                    txtCalculos.setText(Mensaje);
                    break;

                case 5:
                    Mensaje= null;
                    Mensaje = "El promedio salarial es: \n";

                    double promedio = empresa.promedioSalarios();

                    txtCalculos.setText(Mensaje + "\n" + promedio);

                    break;

                case 6:
                    String PonderadoporCargo = "";
                    PonderadoporCargo = empresa.PromedioSalarialPorcargo();
                    txtCalculos.setText(PonderadoporCargo);

                    break;

            }

        }
        else if (v.getId() == R.id.btnBack) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

    }
    public void Cargarlista(List<Person> Cargarlista){
        String Resultado = "";
        for (int i = 0; i <= Cargarlista.size()-1; ++i)  {
            Resultado=Resultado + "\n" + Cargarlista.get(i).getName() + " " + Cargarlista.get(i).getSurname();
        }
        txtRegistrados.setText(Resultado);

    }
}