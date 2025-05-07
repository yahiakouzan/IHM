package exception;

import java.lang.Exception;

public class ExceptionPlanning extends Exception {
    private int chCodeErreur ;
    public ExceptionPlanning(int parCodeErreur){

        chCodeErreur = parCodeErreur;
    }

    public int getCodeErreur(){
        return chCodeErreur;
    }

}
