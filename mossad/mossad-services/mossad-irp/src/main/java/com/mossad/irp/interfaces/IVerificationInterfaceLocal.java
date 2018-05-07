/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.irp.interfaces;

import javax.ejb.Local;

/**
 *
 * @author mmigdal
 */

@Local
public interface IVerificationInterfaceLocal {
     void verify();
}
