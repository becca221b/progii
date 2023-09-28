package Exceptions;

import java.io.IOException;
import java.util.Scanner;

public class exception1 {
    //que diga si el num no está entre el 1 y el 100
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);

        System.out.println("Ingrese un número del 1 al 100");

        int nro= scanner.nextInt();

        try{
            evaluarNum(nro);
        }catch(response e){
            e.printStackTrace();
        }
        System.out.println("Fin del programa");

    }

    static void evaluarNum(int nro) throws response{

        if(nro>100 || nro<1){
            response miExcepcion= new response("el num no está entre el 1 y el 100");
            throw miExcepcion;
        }

    }

    public static class response extends IOException{
        public response(){

        }

        public response(String messageError){
            super(messageError);
        }
    }


}
