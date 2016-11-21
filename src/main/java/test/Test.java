package test;

import com.funtik.aprocsination.parser.fpu.Function;
import com.funtik.aprocsination.parser.fpu.Parser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author funtik
 */
public class Test {
    public static void main(String[] args){
       Parser.SYS_FUNC.put("cos", new Function("cos", "casc"));
       Parser.F.put("asd", new Function("asd", "a+b"));
       Parser.parser("asd()");
    }   
}
