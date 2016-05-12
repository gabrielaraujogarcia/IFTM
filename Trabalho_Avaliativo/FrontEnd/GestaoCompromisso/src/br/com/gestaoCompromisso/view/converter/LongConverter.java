/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaoCompromisso.view.converter;

import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author carlo
 */
public class LongConverter extends Converter<Long,String> {

    @Override
    public Long convertReverse(String value) {
        if (value == null || value.equals("")) {
            return null;
        }            
        return Long.parseLong(value);
    }

    @Override
    public String convertForward(Long value) {
        return value.toString();
    }

}