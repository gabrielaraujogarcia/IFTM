/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaoCompromisso.view.popup;

/**
 *
 * @author ggarcia
 * @param <T>
 */
public interface IMestrePopUp<T> {
   
    public abstract void processarSelecionado(T selecionado);
       
}