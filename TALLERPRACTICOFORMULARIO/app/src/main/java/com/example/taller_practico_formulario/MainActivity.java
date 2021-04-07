package com.example.taller_practico_formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ib.custom.toast.CustomToastView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvTECHNO;
    private TextView txtName;
    private TextView txtSurname;
    private TextView txtAge;
    private Spinner SpCargo;
    private TextView txtSalary;
    private TextView txtEmail;
    private Button btnRegistro;
    private Button btnForm;
    List<String>Cargos= new ArrayList<>();
    private static List<Person>listaUsuario= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cargos.add("Jefe");
        Cargos.add("Secretaria");
        Cargos.add("Auxiliar");
        setContentView();

    }

    private void setContentView() {
        tvTECHNO = findViewById(R.id.tvTECHNO);
        txtName = findViewById(R.id.txtName);
        txtSurname = findViewById(R.id.txtSurname);
        txtEmail = findViewById(R.id.txtEmail);
        txtAge = findViewById(R.id.txtAge);
        SpCargo=findViewById(R.id.SpCargo);
        txtSalary = findViewById(R.id.txtsalary);
        btnForm = findViewById(R.id.btnForm);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(this);
        btnForm.setOnClickListener(this);



        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,Cargos);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SpCargo.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegistro) {
            String name = txtName.getText().toString();
            String surname = txtSurname.getText().toString();
            String email = txtEmail.getText().toString();
            int age = Integer.parseInt(txtAge.getText().toString());
            String cargo = SpCargo.getSelectedItem().toString();
            int salary = Integer.parseInt(txtSalary.getText().toString());

            if (name.isEmpty()) {
                CustomToastView.makeErrorToast(this,"Ingrese su nombre",R.layout.custom_toast).show();
                return;
            }
            if(surname.isEmpty()){
                CustomToastView.makeInfoToast(this,"Ingrese su apellido",R.layout.custom_toast).show();
                return;
            }

            if(!isValidEmail(email)) {
                CustomToastView.makeWarningToast(this, "Ingrese su correo electronico", R.layout.custom_toast).show();
                return;
            }
            if (cargo.isEmpty()){
                CustomToastView.makeInfoToast(this, "Ingrese su cargo en la entidad",R.layout.custom_toast).show();
                return;
            }
            Person Empleado = new Person(surname, age, salary,cargo,email, name);
            listaUsuario.add(Empleado);
            CustomToastView.makeSuccessToast(this,"El usuario se registro correctamente ",R.layout.custom_toast).show();
        }
           else if (v.getId()==R.id.btnForm) {
                Intent myIntent = new Intent(this, ConsultaEmpresa.class);
                myIntent.putExtra("lista",(Serializable)listaUsuario);
                myIntent.putExtra("Cargos",(Serializable)Cargos);
                startActivity(myIntent);

            }
    }

    private Boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();

    }
}