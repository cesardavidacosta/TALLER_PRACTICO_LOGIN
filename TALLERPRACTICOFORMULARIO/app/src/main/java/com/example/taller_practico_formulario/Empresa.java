package com.example.taller_practico_formulario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Empresa implements Serializable {

    List<Person> listaUsuario = new ArrayList<>();
    List<String> listaCargo = new ArrayList<>();
    int Age;

    public Empresa(List<Person> listaUsuario, List<String> listaCargo) {
        this.listaUsuario = listaUsuario;
        this.listaCargo = listaCargo;
    }

    public List<Person> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Person> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<String> getListaCargo() {
        return listaCargo;
    }

    public void setListaCargo(List<String> listaCargo) {
        this.listaCargo = listaCargo;
    }

    public int ObtenerEdadMayor() {
        return this.Age;
    }

    public List<Person> EmpleadoMasJoven() {
        List<Person> listamasjoven = new ArrayList<>();
        Person PrimerObjeto = listaUsuario.get(0);
        int Edad = PrimerObjeto.getAge();

        for (Person Datos:listaUsuario) {
            if (Datos.getAge()<=Edad)
            {
                Edad = Datos.getAge();
            }
        }
        for (Person Datos2:listaUsuario) {
            if (Datos2.getAge() == Edad)
            {
                listamasjoven.add(Datos2);
            }
        }
        return listamasjoven;
    }

    public List<Person> EmpleadoMasSenil() {
        List<Person> listamasCenil = new ArrayList<>();

        int Edad = 0;

        for (Person Datos : listaUsuario) {
            if (Datos.getAge() >= Edad) {
                Edad = Datos.getAge();
            }
        }
        for (Person Datos2 : listaUsuario) {
            if (Datos2.getAge() == Edad) {
                listamasCenil.add(Datos2);
            }
        }
        return listamasCenil;
    }

    public List<Person> SalarioMasAlto() {
        List<Person> listaEmpleados = new ArrayList<>();
        double SalariomasAlto;
        Person PrimerDato = listaUsuario.get(0);
        SalariomasAlto = PrimerDato.getSalary();

        for (Person emple: listaUsuario) {
            if (SalariomasAlto <= emple.getSalary())
            {
               SalariomasAlto = emple.getSalary();
            }
        }
        for (Person emple2 :listaUsuario) {
            if (emple2.getSalary() ==SalariomasAlto)
            {
                listaEmpleados.add(emple2);
            }
        }
        return listaEmpleados;
    }

    public List<Person> SalarioMasBajo() {
        List<Person> listaEmpleados = new ArrayList<>();
        double SalariomasBajo;
        Person PrimerDato = listaUsuario.get(0);
        SalariomasBajo = PrimerDato.getSalary();

        for (Person emple: listaUsuario) {
            if (SalariomasBajo >= emple.getSalary())
            {
                SalariomasBajo = emple.getSalary();
            }
        }
        for (Person emple2 :listaUsuario) {
            if (emple2.getSalary() == SalariomasBajo)
            {
                listaEmpleados.add(emple2);
            }
        }
        return listaEmpleados;
    }

    public double promedioSalarios(){

        int cont = 0;
        double totalSalarios = 0;

        for (Person emp: listaUsuario)
        {
            totalSalarios = totalSalarios + emp.getSalary();
            cont++;
        }

        double promedio = totalSalarios / cont;

        return promedio;
    }

    public String PromedioSalarialPorcargo(){

        int cont = 0;
        double promedio = 0;
        double suma = 0;
        String informe = "";

        for (int i = 0; i <= listaCargo.size()-1; i++){

            for (int j = 0; j <= listaUsuario.size()-1; j++){

                if (listaCargo.get(i).equals(listaUsuario.get(j).getCargo())){

                    cont = cont + 1;
                    suma = suma + listaUsuario.get(j).getSalary();
                }else {

                    suma = suma + 0;
                    cont = cont + 0;
                }
            }

            if (cont == 0){
                promedio = 0;
            }else {
                promedio = suma/cont;
            }

            informe = informe + "\n" + "* Cargo: " + listaCargo.get(i) + "\n-- # de empleados por cargo: " + cont
                    + "\n-- Promedio Salarios cargo: " + promedio;
            cont = 0;
            suma = 0;
        }

        return informe;
    }

}









