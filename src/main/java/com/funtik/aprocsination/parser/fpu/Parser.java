package com.funtik.aprocsination.parser.fpu;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author funtik
 */
public class Parser {
    private static final int    DOUBLE      = 1,
                                NUMBER      = 2,
                                VAR         = 3,
                                FUNC        = 4,
                                OPER        = 5,
                                FAKTORIAL   = 6;
    
    private static final char [] O = { '^', '*', '/', '%', '+', '-' };
    private static final Stack<Point> ST = new Stack<>();
    public static final HashMap<String, Function> SYS_FUNC = new HashMap<>();
    public static HashMap<String, Function> F = new HashMap<>(); //?????
    
    public static void parser(String s){
        parserSkobki(new StringBuilder(s));
    }
    
    public static final int FP = 1; 
    private static int parserSkobki(StringBuilder sb){
        int end = sb.length();
        for(int i=0; i<end; i++){
            char c = sb.charAt(i);
            if(c=='('){
                Point p = new Point();
                String s = getFunc(sb, i, end);
                Function f;
                if(s!=null){ 
                    f = SYS_FUNC.get(s);
                    if(f==null) f = F.get(s);
                    if(f==null) return -1;
                    p.type = FP;
                } else p.type = 2; 
            } else if(c==')'){
                
            }
        }
        return 0;
    }
    
    private static String getFunc(StringBuilder sb, int begin, int end){
        int i = begin-1;
        for(; i>end; i--){
            char c  = sb.charAt(i);
            if(end==i && !((c>='a' && c<='z') || (c>='A' && c<='Z'))) return null; 
            if(getOperator(c)!=-1){ 
                if(i==begin-1) return null;
                i--; break; 
            }
            if(!((c>='a' && c<='z') || (c>='A' && c<='Z') || c=='_' 
                    || (c>='0' && c<='9'))) return null;        
        }
        return sb.substring(i, begin);
    }
    
    private static char automat(StringBuilder s, int begin, int end){
        int p = 0, pb, pe; boolean minus, post, pref; // post, pref operator ++ -- +=
        StringBuilder sb = new StringBuilder();
        for(int i=begin; i<end; i++){
            char c = s.charAt(i);
            switch(p){
                case -1:
                    p = 0;
                    if(c=='-'){ minus = true; continue; }
                case 0:
                    sb.append(c);
                    if(c=='!') p = FAKTORIAL;
                    else if(c>='0' && c<='9') p = DOUBLE;
                    else if((c>='a' && c<='z') || (c>='A' && c<='Z')) p = VAR;
                    else return c;
                case DOUBLE:
                    if(c>='0' && c<='9') sb.append(c);
                    else if(c=='.'){ p = NUMBER; sb.append(c); }
                    else if(c=='!');
                    else { p = OPER; --i; }
                case NUMBER:
                    if(c>='0' && c<='9') sb.append(c);
                    else if(c=='!');
                    else { p = OPER; --i; }
                    break;
                case VAR:
                    if((c>='a' && c<='z') || (c>='A' && c<='Z') || c=='_' 
                            ||  (c>='0' && c<='9')) sb.append(c);
                    else if(c=='!');
                    else { p = OPER; --i; }
                    break;
                case FAKTORIAL:
                    if(getOperator(c)==-1) return c;
                    break;
            }
        }
        
        return 0;
    }
    
    private static int getOperator(char c){
        for(int i=0; i<O.length; i++) if(c == O[i]) return i;
        return -1;
    }
    
    public static class Point{ public int begin, end, type; }
    public static class Stack<T> extends ArrayList<T>{
        public T pop(){
            int sz = super.size();
            T t = super.get(sz-1);
            super.remove(sz-1);
            return t;
        }
        public void push(T t){ super.add(t); }
    }
}
