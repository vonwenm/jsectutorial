package com.huuzkee.jstut;

import com.huuzkee.jstut.AES.*;
import com.huuzkee.jstut.ARC.*;
import com.huuzkee.jstut.ASN.*;
import com.huuzkee.jstut.AES.*;
import com.huuzkee.jstut.BLOW.*;
import com.huuzkee.jstut.BOUNCY.*;
import com.huuzkee.jstut.CERT.*;
import com.huuzkee.jstut.CFAC.*;
import com.huuzkee.jstut.CSTOR.*;
import com.huuzkee.jstut.CYPH.*;
import com.huuzkee.jstut.CYST.*;
import com.huuzkee.jstut.DES.*;
import com.huuzkee.jstut.DHKA.*;
import com.huuzkee.jstut.DIGS.*;
import com.huuzkee.jstut.DSED.*;
import com.huuzkee.jstut.KTOOL.*;
import com.huuzkee.jstut.DSA.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
		try{

        System.out.println( "Hello World!" );

        des04.main( args );
        des03.main( args );
        ktool01.main( args );

        } catch (Exception e){

		    // Deal with e as you please.
		    //e may be any type of exception at all.

		}

    }
}
