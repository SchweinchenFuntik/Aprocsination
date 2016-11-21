package com.funtik.aprocsination.parser;

/**
 *
 * @author funtik
 */
public abstract class OperatorValue implements Value{
    private double left, right;
    
    public OperatorValue(){}
    public OperatorValue(Number l, Number r){ 
        left = l.doubleValue(); right = r.doubleValue(); 
    }
    
    public OperatorValue set(Number l, Number r){
        left = l.doubleValue(); right = r.doubleValue();
        return this;
    }
    
    public abstract double get(Number left, Number right);
  
    public class Add extends OperatorValue{

        @Override
        public double get(Number left, Number right) {
            return left.doubleValue()+right.doubleValue();
        }

        @Override
        public double get(){ return left+right; }
    }
    
    public class Sub extends OperatorValue{

        @Override
        public double get(Number left, Number right){
            return left.doubleValue()-right.doubleValue();
        }

        @Override
        public double get(){ return left-right; }
    }
    
    public class Mul extends OperatorValue{

        @Override
        public double get(Number left, Number right){
            return left.doubleValue()*right.doubleValue();
        }

        @Override
        public double get(){ return left*right; }
    }
    
    public class Div extends OperatorValue{

        @Override
        public double get(Number left, Number right){
            return left.doubleValue()/right.doubleValue();
        }

        @Override
        public double get(){ return left/right; }
    }
    
    public class Mod extends OperatorValue{

        @Override
        public double get(Number left, Number right){
            return left.doubleValue()%right.doubleValue();
        }

        @Override
        public double get(){ return left%right; }
    }
    
    public class Pow extends OperatorValue{

        @Override
        public double get(Number left, Number right){
            return Math.pow(left.doubleValue(), right.doubleValue());
        }

        @Override
        public double get(){ return Math.pow(left, right); }
    }
}
