package com.mycompany.gamenotes;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author Kevyn
 */
public class GameNotesMain implements NativeKeyListener {
    SaveController saveController = new SaveController();
    
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == NativeKeyEvent.VC_F10) {
           saveController.captureScreen();
        }
        else if (key == NativeKeyEvent.VC_ESCAPE) {
            System.exit(0);
        } 
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }

    public static void main(String[] args) {
        // Disable console output for jNativeHook
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);

        // Start listening for keypresses
        try {
            GlobalScreen.registerNativeHook();
        } 
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GameNotesMain());
    }
}
