/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

/**
 *
 * @author Bilo Alejandro Martins Gonzalez
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
