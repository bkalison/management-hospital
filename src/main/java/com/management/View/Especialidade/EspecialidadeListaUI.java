package com.management.View.Especialidade;

import com.management.Model.Classes.Especialidade;
import com.management.View.PrincipalUI;

import javax.swing.*;

public class EspecialidadeListaUI extends JFrame {
    private JPanel mainPanel;
    private JTextArea txTextShow;

    //PrincipalUI = classe principal com todas as ligações entre outras telas
    //mainUI = nome do atributo que é do TIPO PrincipalUI
    private PrincipalUI mainUI;
    // Construtor
    public EspecialidadeListaUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);



        for(Especialidade umEspecialidade : this.mainUI.getEspecialidades()){
            //append = atribui item
            txTextShow.append(umEspecialidade.toString());
            txTextShow.append("\n");
        }
    }
}