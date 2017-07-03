/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gamenotes;

import javax.swing.JDialog;

/**
 *
 * @author Kevyn
 */
public class SaveDialog extends JDialog {

    public SaveDialog() {
        setTitle("Save Screenshot");
        setSize(300, 200);
        setLocationRelativeTo(null);
        
        setVisible(true);
        setModal(true);
        setAlwaysOnTop(true);
        setModalityType(ModalityType.APPLICATION_MODAL);        
    }
}
