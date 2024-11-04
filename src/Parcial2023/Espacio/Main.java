/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2023.Espacio;

/**
 *
 * @author paula
 */
public class Main {
    public static void main(String[] args) {
       FormacionAgua f= new FormacionAgua(3);
       Thread [] hilosOxigeno = new Thread[10];
       Thread [] hilosHidrogeno = new Thread[20];
       
       for (int i = 0; i < hilosOxigeno.length; i++) {
             hilosOxigeno[i] = new Thread(new Oxigeno(f), "Oxigeno "+i);
       }
       for (int i = 0; i < hilosHidrogeno.length; i++) {
             hilosHidrogeno[i] = new Thread(new Hidrogeno(f), "Hidrogeno "+i);
       }
       for (int i = 0; i < hilosHidrogeno.length; i++) {
             hilosHidrogeno[i].start();
       }
       
       for (int i = 0; i < hilosOxigeno.length; i++) {
             hilosOxigeno[i].start();
       }
    }
}
