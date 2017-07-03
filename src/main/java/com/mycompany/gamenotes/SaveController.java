/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.imageio.ImageIO;

/**
 *
 * @author Kevyn
 */
public class SaveController {
    
    public void captureScreen(){
        try {
            // Save current screen to jpg          
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
