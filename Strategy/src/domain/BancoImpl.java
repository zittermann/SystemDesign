package domain;

public class BancoImpl implements IBanco {


    @Override
    public void transferir(Cuenta origen, Cuenta destino, float monto) {

        float comisionIncluida = monto + (monto * origen.getComision());

        if (origen.getSaldo() >= comisionIncluida) {
            origen.restarSaldo(comisionIncluida);
            destino.agregarSaldo(monto);
            System.out.printf("Se han transferido [" + monto + "]" + " con exito\n");
        } else System.err.printf("Error: Saldo insuficiente\n");
    }
}
