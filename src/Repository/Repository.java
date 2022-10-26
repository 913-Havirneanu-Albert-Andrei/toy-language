package Repository;

import Domain.ProgramState.PrgState;

public class Repository implements IRepository{

    private PrgState program;

    public Repository(PrgState prg){
        this.program = prg;
    }

    @Override
    public PrgState getCrtPrg ( ) {
        return this.program;
    }
}
