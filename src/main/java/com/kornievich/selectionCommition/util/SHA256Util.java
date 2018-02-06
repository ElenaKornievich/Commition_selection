package com.kornievich.selectionCommition.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Util { 
private static final String SALT = "sugar@8&@@**333*2";

public static String encrypt(String password){ 
return DigestUtils.sha256Hex(password + SALT); 
} 
}
