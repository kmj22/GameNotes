package com.mycompany.gamenotes;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author Kevyn
 */
public class GameNotesMain implements NativeKeyListener {

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == NativeKeyEvent.VC_ENTER) {
            captureScreen();
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
    
    
    
    public void captureScreen(){
        try {
            Robot robot = new Robot();
            String format = "jpg";
            String directory = "E:\\Users\\Kevyn\\Desktop\\screens\\";
            String name = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
            
            String fileName = directory + name + "." + format;
             
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(fileName));
            
            System.out.println("A full screenshot saved to " + fileName);
        } 
        catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
    }
}
