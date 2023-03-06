/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

/**
 *
 * Esta interfaz es implementada en GUIInitMenuView y TextInitMenuView y obliga
 * a esas dos clases a implementar estos métodos
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public interface InitMenuView {

    public boolean showLoginMenu();

    public void showLoginErrorMessage();

    public void showConnectionErrorMessage();

    public void showReadErrorMessage();

    public void showWriteErrorMessage();

    public String showNewNameMenu();

    public void showRegisterMenu();

}
