package com.management.View.LeitoHospitalar;

import com.management.Model.Classes.Funcionario;
import com.management.Model.Classes.LeitoHospitalar;
import com.management.Model.Classes.Paciente;
import com.management.View.PrincipalUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LeitoAddPacienteUI extends JFrame{
    private JComboBox<LeitoHospitalar> cbLeitosDisponiveis;
    private JButton confirmarButton;
    private JPanel mainPanel;
    private JComboBox<Paciente> cbPacientes;
    private JComboBox<Funcionario> cbFuncionarios;
    private PrincipalUI mainUI;
    private ArrayList<LeitoHospitalar> leitoHospitalares;

    public LeitoAddPacienteUI(PrincipalUI principalUI){
        this.mainUI = principalUI;
        this.leitoHospitalares = this.mainUI.getLeitos();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        for(LeitoHospitalar umLeito : this.mainUI.getLeitos()){
            if(!umLeito.getOcupado()){
                cbLeitosDisponiveis.addItem(umLeito);
            }
        }

        for (Paciente umPaciente : this.mainUI.getPacientes()){
            if(umPaciente.getStatusPaciente().equals("aguardando")){
                cbPacientes.addItem(umPaciente);
            }
        }

        for (Funcionario umFuncionario : this.mainUI.getFuncionarios()){
            cbFuncionarios.addItem(umFuncionario);
        }

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeitoHospitalar leitoSelecionado = cbLeitosDisponiveis.getItemAt(cbLeitosDisponiveis.getSelectedIndex());
                Paciente pacienteSelecionado = cbPacientes.getItemAt(cbPacientes.getSelectedIndex());
                Funcionario funcionarioSelecionado = cbFuncionarios.getItemAt(cbFuncionarios.getSelectedIndex());

                confirmarLeitoAddPaciente(leitoSelecionado, pacienteSelecionado, funcionarioSelecionado);
            }
        });
    }

    private void confirmarLeitoAddPaciente(LeitoHospitalar leitoSelecionado, Paciente pacienteSelecionado, Funcionario funcionarioSelecionado){

        funcionarioSelecionado.atendimento(pacienteSelecionado.getNome());
        pacienteSelecionado.atendimento(funcionarioSelecionado.getNome());

        for(LeitoHospitalar umleito : this.mainUI.getLeitos()){
            if(umleito.getIdLeito() == leitoSelecionado.getIdLeito()){
                umleito.setPaciente(pacienteSelecionado);

                umleito.setOcupado(true);
                pacienteSelecionado.setStatusPaciente("emLeito");
            }
        }
    }
}
