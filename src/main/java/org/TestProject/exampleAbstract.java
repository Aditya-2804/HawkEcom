package org.TestProject;

import org.openqa.selenium.WebDriver;

public abstract class exampleAbstract {

    int a ;
    public exampleAbstract(int a){
        this.a =a;
    }
    abstract int multiply(int val);
}

class example extends exampleAbstract{
    example(){
        super(2);
    }

    @Override
    int multiply(int val) {
        return this.a * val;
    }
}


