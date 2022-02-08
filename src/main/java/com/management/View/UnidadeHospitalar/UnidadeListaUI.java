package com.management.View.UnidadeHospitalar;

import com.management.View.PrincipalUI;
import com.management.Model.Classes.UnidadeHospitalar;

import javax.swing.*;

public class UnidadeListaUI extends JFrame{
    private JPanel mainPanel;
    private JTextArea txShowList;
    private PrincipalUI mainUI;

    public UnidadeListaUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);

        txShowList.append("--- Todas as Unidades --- \n");
        for (UnidadeHospitalar umaUnidadeHospitalar: this.mainUI.getUnidadeHospitalares()){
            txShowList.append("--- Informações da unidade --- \n");
            txShowList.append(umaUnidadeHospitalar.toString());
            txShowList.append(umaUnidadeHospitalar.imprimeEquipe());
            txShowList.append(umaUnidadeHospitalar.imprimeQuarto());
            txShowList.append("\n");
        }
    }

}