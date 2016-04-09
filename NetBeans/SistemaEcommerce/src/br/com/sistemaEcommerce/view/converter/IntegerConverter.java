/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEcommerce.view.converter;

import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author ggarcia
 */
public class IntegerConverter extends Converter<Integer, String> {

    @Override
    public Integer convertReverse(String value) {
        
        try {
            return Integer.parseInt(value);  
        } catch(Exception e) {            
            System.out.println("[IntegerConverter] Erro ao tentar converter a String " + value +
                    " em Integer. Motivo: " + e.getCause());
            return null;
        }
        
    }

    @Override
    public String convertForward(Integer value) {
      
        if(value != null) {
            return value.toString();
        }
        
        return null;
    }
    
    
    
}
