package com.hospital;
import java.util.ArrayList;
import java.util.List;

public class ListaPaciente {
    private List<Paciente> pacientes;

    public ListaPaciente() {
        pacientes = new ArrayList<>();
    }

   
    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    
    public void alterarPaciente(int id, Paciente novoPaciente) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getId() == id) {
                pacientes.set(i, novoPaciente);
                return;
            }
        }
    }

    
    public void excluirPaciente(int id) {
        pacientes.removeIf(p -> p.getId() == id);
    }

    
    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            pacientes.forEach(System.out::println);
        }
    }

    
    public Paciente buscarPacientePorId(int id) {
        for (Paciente p : pacientes) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; //
    }
}
