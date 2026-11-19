package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Entregar uma encomenda. */
@StateSet({"criada", "expedida", "entregue", "devolvida", "arquivada"})
public class Encomenda {

    @StateRefinement(to="criada()")
    public Encomenda() {}

    /** Volta a preparar a encomenda devolvida. */
    @StateRefinement(from="devolvida()", to="criada()")
    public void repor() {}

    /** Entrega a encomenda ao destinatário. */
    @StateRefinement(from="expedida()", to="entregue()")
    public void entregar() {}

    /** Expede a encomenda. */
    @StateRefinement(from="criada()", to="expedida()")
    public void expedir() {}

    /** O destinatário recusa a encomenda; é devolvida. */
    @StateRefinement(from="expedida()", to="devolvida()")
    public void recusar() {}

    /** Arquiva a encomenda (definitivo). */
    @StateRefinement(from="entregue() || devolvida()", to="arquivada()")
    public void arquivar() {}
}
