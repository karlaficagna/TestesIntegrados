package com.ficagna.TestesIntegrados;

import com.ficagna.TestesIntegrados.Dominio.Hello;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloTest {

    @Test
    public void saudacaoTest() {
        //arranje
        Hello hello = new Hello();

        //act
        String saudacaoResultado = hello.saudacao();

        //assesrt
        Assertions.assertEquals("oi, tudo bem?", saudacaoResultado);
    }

    @Test
    public void byeTest() {
        //arranje
        Hello hello = new Hello();

        //act
        String saudacaoResultado  hello.bye();

        //assesrt
        Assertions.assertEquals("tchau!", byeResultado);

    }
}
