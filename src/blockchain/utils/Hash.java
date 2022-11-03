//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2022   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package blockchain.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 28/09/2022, 11:02:33
 *
 * @author IPT - computer
 * @version 1.0
 */
public class Hash {

    public static String toHexString(int n) {
        return Integer.toHexString(n).toUpperCase();
    }

    //metodo alterado para calcular o Hash com SHA-256
    public static String getHash(String data) {
//        MessageDigest dig;
//        try {
//            dig = MessageDigest.getInstance("SHA-128");
//            byte[] hash = dig.digest(data.getBytes("UTF-8"));
//            String encoded = Base64.getEncoder().encodeToString(hash);
//            return encoded;
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(Hash.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(Hash.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
        return toHexString(data.hashCode());
        
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202209281102L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2022  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
