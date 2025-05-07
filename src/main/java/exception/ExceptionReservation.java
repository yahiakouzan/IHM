package exception;

import java.lang.Exception;

public class ExceptionReservation extends Exception {
  private int chCodeErreur ;
  public ExceptionReservation(int parCodeErreur){
    chCodeErreur = parCodeErreur;
  }

  public int getCodeErreur(){

    return chCodeErreur;
  }
}
